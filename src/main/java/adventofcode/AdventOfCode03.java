package adventofcode;

import java.util.List;

public class AdventOfCode03 {

    private final List<String> input;

    public AdventOfCode03(List<String> input) {
        this.input = input;
    }

    public Long processFirstPart() {
        Long result = 0L;
        Integer length = input.get(0).length();
        Integer position = 0;

        Integer slopeX = 3;
        int slopeY = 1;

        for (int verticalIndex = slopeY; verticalIndex < input.size(); verticalIndex = verticalIndex + slopeY) {
            position = position + slopeX;

            if (input.get(verticalIndex).charAt(position % length) == '#') {
                result++;
            }

        }

        return result;
    }


    public Long processSecondPart(Integer slopeX, Integer slopeY) {
        Long result = 0L;
        Integer length = input.get(0).length();
        Integer position = 0;

        for (int verticalIndex = slopeY; verticalIndex < input.size(); verticalIndex = verticalIndex + slopeY) {
            position = position + slopeX;

            if (input.get(verticalIndex).charAt(position % length) == '#') {
                result++;
            }
        }

        return result;
    }


}
