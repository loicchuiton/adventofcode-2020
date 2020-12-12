package adventofcode;

import java.util.List;

public class AdventOfCode09 {

    private final List<Long> input;

    public AdventOfCode09(List<Long> input) {
        this.input = input;
    }

    public Long processFirstPart(int preambleSize) {

        Long result = 0L;
        for (int i = preambleSize; i < input.size(); i++) {

            boolean isValid = false;
            int j = i - preambleSize;
            while (j < i) {
                for (int k = i - preambleSize; k < i; k++) {
                    if (j != k && input.get(i).equals(input.get(j) + input.get(k))) {
                        isValid = true;

                        break;
                    }
                }
                j++;

            }

            if (!isValid) {
                return input.get(i);
            }

        }
        return result;
    }


    public Long processSecondPart(Long invalidNumber) {
        Long result = 0L;

        for (int numberOfNumbers = 2; numberOfNumbers < 998; numberOfNumbers++) {
            for (int i = 0; i < input.size(); i++) {

                if (sumXNumberOfConsecutive(numberOfNumbers, i).equals(invalidNumber) && !input.get(i).equals(invalidNumber)) {
                    return minOfXConsecutiveNumber(i, numberOfNumbers) + maxOfTheXConsecutiveNumbers(i, numberOfNumbers);
                }
            }
        }
        return result;
    }

    private Long maxOfTheXConsecutiveNumbers(int i, int numberOfNumbers) {
        Long max = input.get(i);

        for (int j = i; j < i + numberOfNumbers; j++) {
            if (max < input.get(j)) {
                max = input.get(j);
            }
        }
        return max;
    }

    private Long minOfXConsecutiveNumber(int i, int numberOfNumbers) {
        Long min = input.get(i);

        for (int j = i; j < i + numberOfNumbers; j++) {
            if (min > input.get(j)) {

                min = input.get(j);
            }
        }
        return min;
    }

    private Long sumXNumberOfConsecutive(int numberOfNumbers, int i) {
        Long result = 0L;

        for (int k = 0; k < numberOfNumbers; k++) {
            if (i + k < input.size()) {

                result += input.get(i + k);
            }
        }

        return result;


    }

}
