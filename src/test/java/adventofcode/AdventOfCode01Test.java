package adventofcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdventOfCode01Test {

    private static final String PROBLEM_NUMBER = "01";

    List<Integer> input = new ArrayList<>();

    private AdventOfCode01 code01;

    @BeforeEach
    public void setup() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/test/resources/" + PROBLEM_NUMBER + "-input"));
        String line = br.readLine();

        while (line != null) {
            input.add(Integer.valueOf(line));
            line = br.readLine();
        }

    }

    @Test
    void part1_final() {
        code01 = new AdventOfCode01(input);

        Integer result = code01.processFirstPart(2020);

        assertEquals(1013211, result);
    }

    @Test
    void part2_final() {
        code01 = new AdventOfCode01(input);

        Integer result = code01.processSecondPart(2020);

        assertEquals(13891280, result);
    }

}
