package adventofcode;

import java.util.ArrayList;
import java.util.List;

public class AdventOfCode04 {

    private final List<String> input;

    public AdventOfCode04(List<String> input) {
        this.input = input;
    }

    public Long processFirstPart() {
        List<String> listOfPassport = getPassportList();

        return listOfPassport.stream()
                .filter(this::hasRequestedFields)
                .count();
    }


    public Long processSecondPart() {
        List<String> listOfPassport = getPassportList();

        return listOfPassport.stream()
                .filter(this::hasRequestedFields)
                .filter(this::hasValidBirthYear)
                .filter(this::hasValidExpirationYear)
                .filter(this::hasValidIssueYear)
                .filter(this::hasValidHeight)
                .filter(this::hasValidHairColor)
                .filter(this::hasValidEyeColor)
                .filter(this::hasValidPassportId)
                .count();


    }

    private List<String> getPassportList() {
        List<String> listOfPassport = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for (String string : input) {
            if (string.isEmpty()) {
                listOfPassport.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(string).append(" ");
            }

        }

        listOfPassport.add(sb.toString());

        return listOfPassport;
    }

    boolean hasRequestedFields(String s) {
        return s.matches(".*(?=(.*byr:))(?=(.*iyr))(?=(.*eyr:))(?=(.*hgt))(?=(.*hcl:))(?=(.*ecl:))(?=(.*pid:)).*");
    }

    boolean hasValidBirthYear(String s) {
        final String REGEX_BIRTHDATE_YEAR = ".*byr:(19[2-9][0-9]|200[0-2])\\b.*";
        return s.matches(REGEX_BIRTHDATE_YEAR);
    }

    boolean hasValidIssueYear(String s) {
        final String REGEX_ISSUE_YEAR = ".*iyr:(201[0-9]|2020)\\b.*";
        return s.matches(REGEX_ISSUE_YEAR);
    }

    boolean hasValidExpirationYear(String s) {
        final String REGEX_EXPIRATION_YEAR = ".*eyr:(202[0-9]|2030)\\b.*";
        return s.matches(REGEX_EXPIRATION_YEAR);
    }

    boolean hasValidHeight(String s) {
        final String REGEX_HEIGHT = ".*hgt:((59|6[0-9]|7[0-6])in|(1[5-8][0-9]|19[0-3])cm)\\b.*";

        return s.matches(REGEX_HEIGHT);
    }

    boolean hasValidHairColor(String s) {
        final String REGEX_HAIR_COLOR = ".*hcl:#[0-9a-f]{6}\\b.*";
        return s.matches(REGEX_HAIR_COLOR);
    }

    boolean hasValidEyeColor(String s) {
        final String REGEX_EYE_COLOR = ".*ecl:(amb|blu|brn|gry|grn|hzl|oth).*";
        return s.matches(REGEX_EYE_COLOR);
    }

    boolean hasValidPassportId(String s) {
        final String REGEX_PASSPORT_ID = ".*pid:([0-9]{9})\\b.*";
        return s.matches(REGEX_PASSPORT_ID);
    }


}
