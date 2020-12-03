package adventofcode;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.List;

public class AdventOfCode03 {

    private final List<String> input;

    public AdventOfCode03(List<String> input) {
        this.input = input;
    }

    public Long processFirstPart(SimpleImmutableEntry<Integer, Integer> slope) {
        int slopeX = slope.getKey();
        int slopeY = slope.getValue();
        return treeHitsWithSlope(slopeX, slopeY);
    }


    private Long treeHitsWithSlope(int slopeX, int slopeY) {
        Long result = 0L;
        int length = input.get(0).length();
        int position = 0;

        for (int verticalIndex = slopeY; verticalIndex < input.size(); verticalIndex = verticalIndex + slopeY) {
            position = position + slopeX;

            if (input.get(verticalIndex).charAt(position % length) == '#') {
                result++;
            }

        }

        return result;
    }


    public Long processSecondPart(List<SimpleImmutableEntry<Integer, Integer>> slopes) {
        Long result = 1L;
        for (SimpleImmutableEntry<Integer, Integer> slope : slopes) {
            result *= treeHitsWithSlope(slope.getKey(), slope.getValue());
        }

        return result;
    }


}
