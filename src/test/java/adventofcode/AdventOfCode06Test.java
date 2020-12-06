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

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AdventOfCode06Test {

    private static final String PROBLEM_NUMBER = "06";

    List<String> input = new ArrayList<>();

    private AdventOfCode06 code06;

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
    @MethodSource("provideUseCasesForAdventOfCode06Part1")
    void part1_unitTests(String input, int expected) {
        code06 = new AdventOfCode06(singletonList(input));

        Integer result = code06.processFirstPart();

        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideUseCasesForAdventOfCode06Part1() {
        return Stream.of(
                Arguments.of("abc ad abcd", 4),
                Arguments.of("abc ad d", 4),
                Arguments.of("a ad d", 2)
        );
    }


    @Test
    void part1_final() {
        code06 = new AdventOfCode06(input);

        Integer result = code06.processFirstPart();

        assertEquals(6763, result);
    }

    @ParameterizedTest
    @MethodSource("provideUseCasesForAdventOfCode06Part2")
    void part2_unitTests(List<String> input, int expected) {
        code06 = new AdventOfCode06(input);

        Integer result = code06.processSecondPart();

        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideUseCasesForAdventOfCode06Part2() {
        return Stream.of(
                Arguments.of(asList("abc", "ad", "abcd"), 1),
                Arguments.of(asList("abc", "ad", "ad"), 1),
                Arguments.of(asList("a", "ad", "d"), 0),
                Arguments.of(asList("abcd", "acd", "acd"), 3)
        );
    }

    @Test
    void part2_final() {
        code06 = new AdventOfCode06(input);

        Integer result = code06.processSecondPart();

        assertEquals(3512, result);
    }


}
