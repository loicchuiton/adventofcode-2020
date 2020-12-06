package adventofcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdventOfCode06 {
    public static final String SEPARATOR = " ";
    private final List<String> input;

    public AdventOfCode06(List<String> input) {
        this.input = input;
    }

    public Integer processFirstPart() {
        List<String> listOfSeats = getAnswersByGroup();

        int result = 0;

        for (String s : listOfSeats) {
            result += countUniqueCharacters(s);
        }

        return result;
    }

    public Integer processSecondPart() {
        List<String> listOfSeats = getAnswersByGroup();

        int result = 0;

        for (String s : listOfSeats) {
            final String[] split = s.split(SEPARATOR);

            if (split.length == 1) {
                result += split[0].length();
            } else {
                for (char c : split[0].toCharArray()) {
                    boolean isCharOK = true;

                    for (int i = 1; i < split.length; i++) {
                        if (split[i].indexOf(c) == -1) {
                            isCharOK = false;
                        }
                    }
                    if (isCharOK) {
                        result += 1;
                    }
                }
            }
        }

        return result;
    }


    private List<String> getAnswersByGroup() {
        List<String> listOfPassport = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for (String string : input) {
            if (string.isEmpty()) {
                listOfPassport.add(sb.toString());
                sb = new StringBuilder();
            } else {
                if (!sb.toString().isBlank()) {
                    sb.append(SEPARATOR);
                }
                sb.append(string);
            }

        }

        listOfPassport.add(sb.toString());

        return listOfPassport;
    }

    private Integer countUniqueCharacters(String string) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c != SEPARATOR.charAt(0)) {
                set.add(string.charAt(i));
            }
        }

        return set.size();
    }
}
