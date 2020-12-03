package adventofcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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

        Long result = code03.processFirstPart();

        assertEquals(262L, result);

    }


    @Test
    void part2_final() {
        code03 = new AdventOfCode03(input);

        Long result1 = code03.processSecondPart(1, 1);
        Long result2 = code03.processSecondPart(3, 1);
        Long result3 = code03.processSecondPart(5, 1);
        Long result4 = code03.processSecondPart(7, 1);
        Long result5 = code03.processSecondPart(1, 2);

        Long result = result1 * result2 * result3 * result4 * result5;
        assertEquals(2698900776L, result);

    }
}
