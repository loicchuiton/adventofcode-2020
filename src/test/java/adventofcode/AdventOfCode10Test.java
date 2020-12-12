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
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdventOfCode10Test {

    private static final String PROBLEM_NUMBER = "10";

    List<Integer> input = new ArrayList<>();

    private AdventOfCode10 code09;

    @BeforeEach
    public void setup() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/test/resources/" + PROBLEM_NUMBER + "-input"));
        String line = br.readLine();

        while (line != null) {
            input.add(Integer.parseInt(line));
            line = br.readLine();
        }

    }

    @ParameterizedTest
    @MethodSource("provideUseCasesForAdventOfCode10Part1")
    void part1_unitTests(List<Integer> input, Long expected) {
        code09 = new AdventOfCode10(input);

        Long result = code09.processFirstPart();

        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideUseCasesForAdventOfCode10Part1() {
        return Stream.of(
                Arguments.of(Arrays.asList(
                        16,
                        10,
                        15,
                        5,
                        1,
                        11,
                        7,
                        19,
                        6,
                        12,
                        4
                        ), 35L
                ));
    }


    @Test
    void part1_final() {
        code09 = new AdventOfCode10(input);

        Long result = code09.processFirstPart();

        assertEquals(2080, result);
    }

    @ParameterizedTest
    @MethodSource("provideUseCasesForAdventOfCode10Part2")
    void part2_unitTests(List<Integer> input, Long expected) {
        code09 = new AdventOfCode10(input);

        Long result = code09.processSecondPart();

        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideUseCasesForAdventOfCode10Part2() {
        return Stream.of(
                Arguments.of(Arrays.asList(
                        16,
                        10,
                        15,
                        5,
                        1,
                        11,
                        7,
                        19,
                        6,
                        12,
                        4
                        ), 8L
                ),
                Arguments.of(Arrays.asList(
                        28,
                        33,
                        18,
                        42,
                        31,
                        14,
                        46,
                        20,
                        48,
                        47,
                        24,
                        23,
                        49,
                        45,
                        19,
                        38,
                        39,
                        11,
                        1,
                        32,
                        25,
                        35,
                        8,
                        17,
                        7,
                        9,
                        4,
                        2,
                        34,
                        10,
                        3
                ), 19208L));

    }

    @Test
    void part2_final() {
        code09 = new AdventOfCode10(input);

        Long result = code09.processSecondPart();

        assertEquals(6908379398144L, result);
    }


}
