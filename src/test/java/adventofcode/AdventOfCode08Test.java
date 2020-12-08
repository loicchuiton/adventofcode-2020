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

class AdventOfCode08Test {

    private static final String PROBLEM_NUMBER = "08";

    List<String> input = new ArrayList<>();

    private AdventOfCode08 code08;

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
    @MethodSource("provideUseCasesForAdventOfCode08Part1")
    void part1_unitTests(List<String> input, int expected) {
        code08 = new AdventOfCode08(input);

        Integer result = code08.processFirstPart();

        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideUseCasesForAdventOfCode08Part1() {
        return Stream.of(
                Arguments.of(Arrays.asList(
                        "nop +0",
                        "acc +1",
                        "jmp +4",
                        "acc +3",
                        "jmp -3",
                        "acc -99",
                        "acc +1",
                        "jmp -4",
                        "acc +6"), 5
                ));
    }


    @Test
    void part1_final() {
        code08 = new AdventOfCode08(input);

        Integer result = code08.processFirstPart();

        assertEquals(1548, result);
    }

    @ParameterizedTest
    @MethodSource("provideUseCasesForAdventOfCode08Part2")
    void part2_unitTests(List<String> input, int expected) {
        code08 = new AdventOfCode08(input);

        Integer result = code08.processSecondPart();

        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideUseCasesForAdventOfCode08Part2() {
        return Stream.of(
                Arguments.of(Arrays.asList(
                        "nop +0",
                        "acc +1",
                        "jmp +4",
                        "acc +3",
                        "jmp -3",
                        "acc -99",
                        "acc +1",
                        "jmp -4",
                        "acc +6"), 8
                ));

    }

    @Test
    void part2_final() {
        code08 = new AdventOfCode08(input);

        Integer result = code08.processSecondPart();

        assertEquals(1375, result);
    }


}
