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

class AdventOfCode09Test {

    private static final String PROBLEM_NUMBER = "09";

    List<Long> input = new ArrayList<>();

    private AdventOfCode09 code09;

    @BeforeEach
    public void setup() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/test/resources/" + PROBLEM_NUMBER + "-input"));
        String line = br.readLine();

        while (line != null) {
            input.add(Long.parseLong(line));
            line = br.readLine();
        }

    }

    @ParameterizedTest
    @MethodSource("provideUseCasesForAdventOfCode09Part1")
    void part1_unitTests(List<Long> input, int preambleSize, Long expected) {
        code09 = new AdventOfCode09(input);

        Long result = code09.processFirstPart(preambleSize);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideUseCasesForAdventOfCode09Part1() {
        return Stream.of(
                Arguments.of(Arrays.asList(
                        35L,
                        20L,
                        15L,
                        25L,
                        47L,
                        40L,
                        62L,
                        55L,
                        65L,
                        95L,
                        102L,
                        117L,
                        150L,
                        182L,
                        127L,
                        219L,
                        299L,
                        277L,
                        309L,
                        576L
                        ), 5, 127L
                ));
    }


    @Test
    void part1_final() {
        code09 = new AdventOfCode09(input);

        Long result = code09.processFirstPart(25);

        assertEquals(50047984L, result);
    }

    @ParameterizedTest
    @MethodSource("provideUseCasesForAdventOfCode09Part2")
    void part2_unitTests(List<Long> input, Long invalidNumber, Long expected) {
        code09 = new AdventOfCode09(input);

        Long result = code09.processSecondPart(invalidNumber);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideUseCasesForAdventOfCode09Part2() {
        return Stream.of(
                Arguments.of(Arrays.asList(
                        35L,
                        20L,
                        15L,
                        25L,
                        47L,
                        40L,
                        62L,
                        55L,
                        65L,
                        95L,
                        102L,
                        117L,
                        150L,
                        182L,
                        127L,
                        219L,
                        299L,
                        277L,
                        309L,
                        576L
                        ), 127L, 62L
                ));

    }

    @Test
    void part2_final() {
        code09 = new AdventOfCode09(input);

        Long result = code09.processSecondPart(50047984L);

        assertEquals(5407707L, result);
    }


}
