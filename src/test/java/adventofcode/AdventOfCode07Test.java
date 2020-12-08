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

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AdventOfCode07Test {

    private static final String PROBLEM_NUMBER = "07";

    List<String> input = new ArrayList<>();

    private AdventOfCode07 code07;

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
    @MethodSource("provideUseCasesForAdventOfCode07Part1")
    void part1_unitTests(List<String> input) {
        code07 = new AdventOfCode07(input);

        Integer result = code07.processFirstPart();

        assertEquals(4, result);
    }

    private static Stream<Arguments> provideUseCasesForAdventOfCode07Part1() {
        return Stream.of(
                Arguments.of(Arrays.asList("light red bags contain 1 bright white bag, 2 muted yellow bags.",
                        "dark orange bags contain 3 bright white bags, 4 muted yellow bags.",
                        "bright white bags contain 1 shiny gold bag.",
                        "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.",
                        "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
                        "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",
                        "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
                        "faded blue bags contain no other bags.",
                        "dotted black bags contain no other bags.")
                ), Arguments.of(Arrays.asList("light red bags contain 1 bright white bag.",
                        "dark orange bags contain 3 bright white bags, 4 muted yellow bags.",
                        "bright white bags contain 1 shiny gold bag.",
                        "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.",
                        "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
                        "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",
                        "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
                        "faded blue bags contain no other bags.",
                        "dotted black bags contain no other bags.")
                ));
    }


    @Test
    void part1_final() {
        code07 = new AdventOfCode07(input);

        Integer result = code07.processFirstPart();

        assertEquals(229, result);
    }

    @ParameterizedTest
    @MethodSource("provideUseCasesForAdventOfCode07Part2")
    void part2_unitTests(String target, List<String> input, int expected) {
        code07 = new AdventOfCode07(input);

        Integer result = code07.processSecondPart(target);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideUseCasesForAdventOfCode07Part2() {
        return Stream.of(
                Arguments.of("shiny gold", asList(
                        "shiny gold bags contain 2 dark red bags.",
                        "dark red bags contain 2 dark orange bags.",
                        "dark orange bags contain 2 dark yellow bags.",
                        "dark yellow bags contain 2 dark green bags.",
                        "dark green bags contain 2 dark blue bags.",
                        "dark blue bags contain 2 dark violet bags.",
                        "dark violet bags contain no other bags."
                ), 126)
        );
    }

    @Test
    void part2_final() {
        code07 = new AdventOfCode07(input);

        Integer result = code07.processSecondPart("shiny gold");

        assertEquals(6683, result);
    }


}
