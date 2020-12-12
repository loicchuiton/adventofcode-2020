package adventofcode;

import java.util.*;
import java.util.stream.Collectors;

public class AdventOfCode07 {

    private final List<String> input;

    private final Set<String> set = new HashSet<>();

    public AdventOfCode07(List<String> input) {
        this.input = input;
    }

    public Integer processFirstPart() {
        Map<String, String> map = prepareInput();

        for (Map.Entry<String, String> e : map.entrySet()) {

            if (containsAShinyBag(e.getValue(), map)) {
                set.add(e.getKey());
            }

        }

        return set.size();
    }

    private boolean containsAShinyBag(String e, Map<String, String> map) {

        if (e.matches("no other bags.")) {
            return false;
        }
        if (e.matches(".*shiny gold.*")) {
            return true;
        } else {
            String[] containedBags = e.split(", ");
            boolean isChildContainsBag = false;

            for (String bag : containedBags) {
                String keyToSearch = getKeyToSearch(bag);

                if (containsAShinyBag(map.get(keyToSearch), map)) {
                    isChildContainsBag = true;
                }
            }
            return isChildContainsBag;

        }
    }


    private String getKeyToSearch(String containedBag) {
        StringBuilder keyToSearch = new StringBuilder();
        List<String> temp = Arrays.stream(containedBag.split(" "))
                .filter(a -> !a.matches(".*[0-9].*") && !a.matches(".*bag.*"))
                .collect(Collectors.toList());
        for (String s : temp) {
            keyToSearch.append(s).append(" ");
        }

        return keyToSearch.toString().trim();
    }


    public Integer processSecondPart(String bag) {

        int result = 0;

        Map<String, String> map = prepareInput();

        result += nbOfBags(map.get(bag), map);

        return result - 1;
    }

    private Map<String, String> prepareInput() {
        Map<String, String> map = new HashMap<>();
        for (String s : input) {

            String[] split1 = s.split(" bags contain ");

            map.put(split1[0], split1[1]);

        }
        return map;
    }

    private int nbOfBags(String e, Map<String, String> map) {

        if (e == null || e.matches("no other bags.")) {
            return 1;
        } else {
            int result = 1;
            String[] containedBags = e.split(", ");

            for (String containedBag : containedBags) {
                StringBuilder sb = new StringBuilder();
                final String[] s1 = containedBag.split(" ");
                List<String> temp = Arrays.stream(s1)
                        .filter(a -> !a.matches(".*[0-9].*") && !a.matches(".*bag.*"))
                        .collect(Collectors.toList());

                int nbTest = Integer.parseInt(s1[0]);
                for (int i = 0; i < temp.size(); i++) {
                    if (i > 0) {
                        sb.append(" ");
                    }
                    sb.append(temp.get(i));
                }
                result += nbTest * nbOfBags(map.get(sb.toString()), map);

            }
            return result;
        }
    }

}
