package adventofcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdventOfCode03Test {

    private static final String PROBLEM_NUMBER = "03";

    List<String> input = new ArrayList<>();

    private AdventOfCode03 code03;

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
        code03 = new AdventOfCode03(input);

        SimpleImmutableEntry<Integer, Integer> slope31 = new SimpleImmutableEntry<>(3, 1);

        Long result = code03.processFirstPart(slope31);

        assertEquals(262L, result);

    }


    @Test
    void part2_final() {
        code03 = new AdventOfCode03(input);

        SimpleImmutableEntry<Integer, Integer> slope1 = new SimpleImmutableEntry<>(1, 1);
        SimpleImmutableEntry<Integer, Integer> slope2 = new SimpleImmutableEntry<>(3, 1);
        SimpleImmutableEntry<Integer, Integer> slope3 = new SimpleImmutableEntry<>(5, 1);
        SimpleImmutableEntry<Integer, Integer> slope4 = new SimpleImmutableEntry<>(7, 1);
        SimpleImmutableEntry<Integer, Integer> slope5 = new SimpleImmutableEntry<>(1, 2);
        List<SimpleImmutableEntry<Integer, Integer>> listOfValues = Arrays.asList(slope1, slope2, slope3, slope4, slope5);

        Long result = code03.processSecondPart(listOfValues);

        assertEquals(2698900776L, result);

    }
}
