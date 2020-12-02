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

class AdventOfCode02Test {

    private static final String PROBLEM_NUMBER = "02";

    List<String> input = new ArrayList<>();

    private AdventOfCode02 code02;

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
    @MethodSource("provideUseCasesForAdventOfCode02Part1")
    void part1_unitTests(String input, int expected) {
        code02 = new AdventOfCode02(singletonList(input));

        Integer result = code02.processFirstPart();

        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideUseCasesForAdventOfCode02Part1() {
        return Stream.of(
                Arguments.of("1-3 a: abcde", 1),
                Arguments.of("11-13 a: aaaaaaaaaaaa", 1),
                Arguments.of("1-3 a: aaaaaaaaaaaa", 0),
                Arguments.of("1-3 a: bbbbbb", 0)
        );
    }


    @Test
    void part1_final() {
        code02 = new AdventOfCode02(input);

        Integer result = code02.processFirstPart();

        assertEquals(393, result);

    }


    @ParameterizedTest
    @MethodSource("provideUseCasesForAdventOfCode02Part2")
    void part2_unitTests(String input, int expected) {
        code02 = new AdventOfCode02(singletonList(input));

        Integer result = code02.processSecondPart();

        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideUseCasesForAdventOfCode02Part2() {
        return Stream.of(
                Arguments.of("1-3 a: abcde", 1),
                Arguments.of("1-3 a: bbade", 1),
                Arguments.of("1-3 a: abade", 0),
                Arguments.of("1-3 a: bbbde", 0)
        );
    }
    

    @Test
    void part2_final() {
        code02 = new AdventOfCode02(input);

        Integer result = code02.processSecondPart();

        assertEquals(690, result);
    }
}
