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

class AdventOfCode11Test {

    private static final String PROBLEM_NUMBER = "11";

    List<String> input = new ArrayList<>();

    private AdventOfCode11 code11;

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
    @MethodSource("provideUseCasesForAdventOfCode11Part1")
    void part1_unitTests(List<String> input, Long expected) {
        code11 = new AdventOfCode11(input);

        Long result = code11.processFirstPart();

        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideUseCasesForAdventOfCode11Part1() {
        return Stream.of(
                Arguments.of(Arrays.asList(
                        "L.LL.LL.LL",
                        "LLLLLLL.LL",
                        "L.L.L..L..",
                        "LLLL.LL.LL",
                        "L.LL.LL.LL",
                        "L.LLLLL.LL",
                        "..L.L.....",
                        "LLLLLLLLLL",
                        "L.LLLLLL.L",
                        "L.LLLLL.LL"
                        ), 37L
                ));
    }


    @Test
    void part1_final() {
        code11 = new AdventOfCode11(input);

        Long result = code11.processFirstPart();

        assertEquals(2303, result);
    }

    @ParameterizedTest
    @MethodSource("provideUseCasesForAdventOfCode11Part2")
    void part2_unitTests(List<String> input, Long expected) {
        code11 = new AdventOfCode11(input);

        Long result = code11.processSecondPart();

        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideUseCasesForAdventOfCode11Part2() {
        return Stream.of(
                Arguments.of(Arrays.asList(
                        "L.LL.LL.LL",
                        "LLLLLLL.LL",
                        "L.L.L..L..",
                        "LLLL.LL.LL",
                        "L.LL.LL.LL",
                        "L.LLLLL.LL",
                        "..L.L.....",
                        "LLLLLLLLLL",
                        "L.LLLLLL.L",
                        "L.LLLLL.LL"
                        ), 26L
                ));

    }

    @Test
    void part2_final() {
        code11 = new AdventOfCode11(input);

        Long result = code11.processSecondPart();

        assertEquals(2057L, result);
    }


}
