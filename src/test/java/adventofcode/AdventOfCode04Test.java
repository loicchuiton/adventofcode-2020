package adventofcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AdventOfCode04Test {

    private static final String PROBLEM_NUMBER = "04";

    List<String> input = new ArrayList<>();

    private AdventOfCode04 code04;

    @BeforeEach
    public void setup() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/test/resources/" + PROBLEM_NUMBER + "-input"));
        String line = br.readLine();

        while (line != null) {
            input.add(line);
            line = br.readLine();
        }


    }

    @Test
    void part1_final() {
        code04 = new AdventOfCode04(input);


        Long result = code04.processFirstPart();

        assertEquals(192L, result);

    }

    @Test
    void part2_final() {
        code04 = new AdventOfCode04(input);

        Long result = code04.processSecondPart();

        assertEquals(101L, result);

    }

    @ParameterizedTest
    @MethodSource("provideUseCasesForHasValidBirthYear_true")
    void hasValidBirthYear_true(String passportInput) {
        code04 = new AdventOfCode04(input);

        assertTrue(code04.hasValidBirthYear(passportInput));

    }

    private static Stream<Arguments> provideUseCasesForHasValidBirthYear_true() {
        return Stream.of(
                Arguments.of("byr:1966 cid:133 pid:9953651821 ecl:gry iyr:2020 hgt:152cm hcl:#fffffd eyr:2026"),
                Arguments.of("byr:1988 cid:133 pid:9953651821 ecl:gry iyr:2020 hgt:152cm hcl:#fffffd eyr:2026"),
                Arguments.of("cid:133 byr:1966 pid:9953651821 ecl:gry iyr:2020 hgt:152cm hcl:#fffffd byr:1966"),
                Arguments.of("byr:1920 cid:133 pid:9953651821 ecl:gry iyr:2020 hgt:152cm hcl:#fffffd eyr:2026"),
                Arguments.of("byr:2002 cid:133 pid:9953651821 ecl:gry iyr:2020 hgt:152cm hcl:#fffffd eyr:2026")
        );
    }

    @ParameterizedTest
    @MethodSource("provideUseCasesForHasValidBirthYear_false")
    void hasValidBirthYear_false(String passportInput) {
        code04 = new AdventOfCode04(input);

        assertFalse(code04.hasValidBirthYear(passportInput));

    }

    private static Stream<Arguments> provideUseCasesForHasValidBirthYear_false() {
        return Stream.of(
                Arguments.of("byr:1915 cid:133 pid:9953651821 ecl:gry iyr:2020 hgt:152cm hcl:#fffffd eyr:2026"),
                Arguments.of("byr:2003 cid:133 pid:9953651821 ecl:gry iyr:2020 hgt:152cm hcl:#fffffd eyr:2026"),
                Arguments.of("cid:133 eyr:2026 pid:9953651821 ecl:gry iyr:2020 hgt:152cm hcl:#fffffd byr:1855"),
                Arguments.of("byr:19200 cid:133 pid:9953651821 ecl:gry iyr:2020 hgt:152cm hcl:#fffffd eyr:2026"),
                Arguments.of("byr:20020 cid:133 pid:9953651821 ecl:gry iyr:2020 hgt:152cm hcl:#fffffd eyr:2026")
        );
    }

    @ParameterizedTest
    @MethodSource("provideUseCasesForHasValidExpirationYear_true")
    void hasValidExpirationYear_true(String passportInput) {
        code04 = new AdventOfCode04(input);

        assertTrue(code04.hasValidExpirationYear(passportInput));

    }

    private static Stream<Arguments> provideUseCasesForHasValidExpirationYear_true() {
        return Stream.of(
                Arguments.of("abcde eyr:2021 123456"),
                Arguments.of("eyr:2021 abcde"),
                Arguments.of("abcde eyr:2030"),
                Arguments.of("abcde eyr:2020")
        );
    }

    @ParameterizedTest
    @MethodSource("provideUseCasesForHasValidExpirationYear_false")
    void hasValidExpirationYear_false(String passportInput) {
        code04 = new AdventOfCode04(input);

        assertFalse(code04.hasValidExpirationYear(passportInput));

    }

    private static Stream<Arguments> provideUseCasesForHasValidExpirationYear_false() {
        return Stream.of(
                Arguments.of("abcde eyr:1915 123456"),
                Arguments.of("eyr:1915 abcde"),
                Arguments.of("abcde eyr:1915"),
                Arguments.of("abcde eyr:20255"),
                Arguments.of("eyr:2010 abcde")
        );
    }

    @ParameterizedTest
    @MethodSource("provideUseCasesForHasValidHeight_true")
    void hasValidHeight_true(String passportInput) {
        code04 = new AdventOfCode04(input);

        assertTrue(code04.hasValidHeight(passportInput));

    }

    private static Stream<Arguments> provideUseCasesForHasValidHeight_true() {
        return Stream.of(
                Arguments.of("abcde hgt:160cm 123456"),
                Arguments.of("hgt:160cm abcde"),
                Arguments.of("abcde hgt:160cm"),
                Arguments.of("abcde hgt:60in 123456"),
                Arguments.of("hgt:60in abcde"),
                Arguments.of("abcde hgt:60in")
        );
    }

    @ParameterizedTest
    @MethodSource("provideUseCasesForHasValidHeight_false")
    void hasValidHeight_false(String passportInput) {
        code04 = new AdventOfCode04(input);

        assertFalse(code04.hasValidHeight(passportInput));

    }

    private static Stream<Arguments> provideUseCasesForHasValidHeight_false() {
        return Stream.of(
                Arguments.of("abcde hgt:160in 123456"),
                Arguments.of("hgt:160in abcde"),
                Arguments.of("abcde hgt:160in"),
                Arguments.of("abcde hgt:60cm 123456"),
                Arguments.of("hgt:60cm abcde"),
                Arguments.of("abcde hgt:60cm"),
                Arguments.of("abcde hgt:150"),
                Arguments.of("hgt:60 abcde")
        );
    }

    @ParameterizedTest
    @MethodSource("provideUseCasesForHasValidPassportId_true")
    void hasValidPassportId_true(String passportInput) {
        code04 = new AdventOfCode04(input);

        assertTrue(code04.hasValidPassportId(passportInput));

    }

    private static Stream<Arguments> provideUseCasesForHasValidPassportId_true() {
        return Stream.of(
                Arguments.of("abcde pid:012345678 123456"),
                Arguments.of("pid:012345678 abcde"),
                Arguments.of("abcde pid:012345678"),
                Arguments.of("abcde pid:112345678 123456"),
                Arguments.of("pid:000000001 abcde"),
                Arguments.of("abcde pid:000000001")
        );
    }

    @ParameterizedTest
    @MethodSource("provideUseCasesForHasValidPassportId_false")
    void hasValidPassportId_false(String passportInput) {
        code04 = new AdventOfCode04(input);

        assertFalse(code04.hasValidPassportId(passportInput));

    }

    private static Stream<Arguments> provideUseCasesForHasValidPassportId_false() {
        return Stream.of(
                Arguments.of("abcde pid:0123 123456"),
                Arguments.of("pid:0123456789 abcde"),
                Arguments.of("abcde pid:0123456789"),
                Arguments.of("abcde pid:0123456789 123456"),
                Arguments.of("pid:012345t789 abcde")
        );
    }

    @ParameterizedTest
    @MethodSource("provideUseCasesForHasValidHairColor_true")
    void hasValidHairColor_true(String passportInput) {
        code04 = new AdventOfCode04(input);

        assertTrue(code04.hasValidHairColor(passportInput));

    }

    private static Stream<Arguments> provideUseCasesForHasValidHairColor_true() {
        return Stream.of(
                Arguments.of("abcde hcl:#123abc 123456"),
                Arguments.of("hcl:#123abc abcde"),
                Arguments.of("abcde hcl:#123abc")
        );
    }

    @ParameterizedTest
    @MethodSource("provideUseCasesForHasValidHairColor_false")
    void hasValidHairColor_false(String passportInput) {
        code04 = new AdventOfCode04(input);

        assertFalse(code04.hasValidHairColor(passportInput));

    }

    private static Stream<Arguments> provideUseCasesForHasValidHairColor_false() {
        return Stream.of(
                Arguments.of("abcde hcl:123abc 123456"),
                Arguments.of("hcl:#123abn abcde"),
                Arguments.of("abcde hcl:#123abn")
        );
    }

    @ParameterizedTest
    @MethodSource("provideUseCasesForHasValidEyeColor_true")
    void hasValidEyeColor_true(String passportInput) {
        code04 = new AdventOfCode04(input);

        assertTrue(code04.hasValidEyeColor(passportInput));

    }

    private static Stream<Arguments> provideUseCasesForHasValidEyeColor_true() {
        return Stream.of(
                Arguments.of("abcde ecl:brn 123456"),
                Arguments.of("ecl:brn abcde"),
                Arguments.of("abcde ecl:brn")
        );
    }

    @ParameterizedTest
    @MethodSource("provideUseCasesForHasValidEyeColor_false")
    void hasValidEyeColor_false(String passportInput) {
        code04 = new AdventOfCode04(input);

        assertFalse(code04.hasValidEyeColor(passportInput));

    }

    private static Stream<Arguments> provideUseCasesForHasValidEyeColor_false() {
        return Stream.of(
                Arguments.of("abcde ecl:wat 123456"),
                Arguments.of("ecl:wat abcde"),
                Arguments.of("abcde ecl:wat")
        );
    }
}
