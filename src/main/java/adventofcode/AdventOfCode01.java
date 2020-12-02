package adventofcode;

import java.util.List;

public class AdventOfCode01 {

    private final List<Integer> input;

    public AdventOfCode01(List<Integer> input) {
        this.input = input;
    }

    public Integer processFirstPart(Integer target) {
        for (Integer integer1 : input) {
            for (Integer integer2 : input) {

                if (integer1 + integer2 == target) {
                    return (integer1 * integer2);
                }
                
            }
        }

        return 0;
    }

    public Integer processSecondPart(Integer target) {
        for (Integer integer1 : input) {
            for (Integer integer2 : input) {
                for (Integer integer3 : input) {

                    if (integer1 + integer2 + integer3 == target) {
                        return (integer1 * integer2 * integer3);
                    }
                }
            }
        }

        return 0;
    }
}
