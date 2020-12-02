package adventofcode;

import java.util.List;

public class AdventOfCode02 {

    private final List<String> input;

    public AdventOfCode02(List<String> input) {
        this.input = input;
    }

    public Integer processFirstPart() {
        Integer result = 0;

        for (String string : input) {
            Integer minOccurrence = parseFirstIndex(string);
            Integer maxOccurrence = parseSecondIndex(string);
            char rule = parseRule(string);
            String password = parsePassword(string);

            if (isPasswordValidFirstRule(minOccurrence, maxOccurrence, rule, password)) {
                result++;
            }
        }

        return result;
    }


    public Integer processSecondPart() {
        Integer result = 0;

        for (String string : input) {
            Integer firstIndex = parseFirstIndex(string);
            Integer secondIndex = parseSecondIndex(string);
            char rule = parseRule(string);
            String password = parsePassword(string);

            if (isPasswordValidSecondRule(firstIndex, secondIndex, rule, password)) {
                result++;
            }
        }

        return result;
    }


    private boolean isPasswordValidFirstRule(Integer minOccurrence, Integer maxOccurrence, char rule, String password) {
        long occurrence = password.chars().filter(ch -> ch == rule).count();
        return occurrence >= minOccurrence && occurrence <= maxOccurrence;
    }

    private boolean isPasswordValidSecondRule(Integer firstIndex, Integer secondIndex, char rule, String password) {
        return (password.charAt(firstIndex) == rule || password.charAt(secondIndex) == rule) && password.charAt(firstIndex) != password.charAt(secondIndex);
    }


    private Integer parseFirstIndex(String input) {
        return Integer.valueOf(input.substring(0, input.indexOf("-")));
    }

    private Integer parseSecondIndex(String input) {
        return Integer.valueOf(input.substring(input.indexOf("-") + 1, input.indexOf(" ")));
    }

    private char parseRule(String input) {
        return input.charAt(input.indexOf(" ") + 1);
    }

    private String parsePassword(String input) {
        return input.substring(input.indexOf(" ") + 3);
    }
}
