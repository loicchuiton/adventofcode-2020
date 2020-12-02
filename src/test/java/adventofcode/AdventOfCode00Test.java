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

public class AdventOfCode00Test {

    private static final String PROBLEM_NUMBER = "00";

    List<String> input = new ArrayList<>();

    private AdventOfCode00 code00;

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
    @MethodSource("provideUseCasesForAdventOfCode00Part1")
    void part1_unitTests(String input, int expected) {
        code00 = new AdventOfCode00(singletonList(input));

        Integer result = code00.processFirstPart();

        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideUseCasesForAdventOfCode00Part1() {
        return Stream.of(
                Arguments.of("Input - Part 1 - test 1", 1),
                Arguments.of("Input - Part 1 - test 2", 1)
        );
    }

    @Test
    void part1_final() {
        code00 = new AdventOfCode00(input);

        Integer result = code00.processFirstPart();

        assertEquals(1, result);
    }


    @ParameterizedTest
    @MethodSource("provideUseCasesForAdventOfCode00Part2")
    void part2_unitTests(String input, int expected) {
        code00 = new AdventOfCode00(singletonList(input));

        Integer result = code00.processFirstPart();

        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideUseCasesForAdventOfCode00Part2() {
        return Stream.of(
                Arguments.of("Input - Part 2 - test 1", 1),
                Arguments.of("Input - Part 2 - test 2", 1)
        );
    }

    @Test
    void part2_final() {
        code00 = new AdventOfCode00(input);

        Integer result = code00.processSecondPart();

        assertEquals(1, result);
    }


}
