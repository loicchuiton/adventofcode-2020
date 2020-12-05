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

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AdventOfCode05Test {

    private static final String PROBLEM_NUMBER = "05";

    List<String> input = new ArrayList<>();

    private AdventOfCode05 code05;

    @BeforeEach
    public void setup() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/test/resources/" + PROBLEM_NUMBER + "-input"));
        String line = br.readLine();

        while (line != null) {
            input.add(line);
            line = br.readLine();
        }

    }

    @ParameterizedTest
    @MethodSource("provideUseCasesForAdventOfCode05Part1")
    void part1_unitTests(String input, int expected) {
        code05 = new AdventOfCode05(singletonList(input));

        Integer result = code05.processFirstPart();

        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideUseCasesForAdventOfCode05Part1() {
        return Stream.of(
                Arguments.of("BFFFBBFRRR", 567),
                Arguments.of("FFFBBBFRRR", 119),
                Arguments.of("BBFFBBFRLL", 820)
        );
    }

    @ParameterizedTest
    @MethodSource("provideUseCasesForAdventOfCode05Part1_row")
    void part1_unitTests_row(String input, int expected) {
        code05 = new AdventOfCode05(singletonList(input));

        Integer result = code05.getRow(input);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideUseCasesForAdventOfCode05Part1_row() {
        return Stream.of(
                Arguments.of("FBFBBFFRLR", 44),
                Arguments.of("BFFFBBFRRR", 70),
                Arguments.of("FFFBBBFRRR", 14),
                Arguments.of("BBFFBBFRLL", 102)
        );
    }

    @ParameterizedTest
    @MethodSource("provideUseCasesForAdventOfCode05Part1_column")
    void part1_unitTests_column(String input, int expected) {
        code05 = new AdventOfCode05(singletonList(input));

        Integer result = code05.getColumn(input);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideUseCasesForAdventOfCode05Part1_column() {
        return Stream.of(
                Arguments.of("FBFBBFFRLR", 5),
                Arguments.of("BFFFBBFRRR", 7),
                Arguments.of("FFFBBBFRRR", 7),
                Arguments.of("BBFFBBFRLL", 4)
        );
    }

    @Test
    void part1_final() {
        code05 = new AdventOfCode05(input);

        Integer result = code05.processFirstPart();

        assertEquals(901, result);
    }


    @Test
    void part2_final() {
        code05 = new AdventOfCode05(input);

        Integer result = code05.processSecondPart();

        assertEquals(661, result);
    }


}
