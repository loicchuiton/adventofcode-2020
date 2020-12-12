package adventofcode;

import java.util.ArrayList;
import java.util.List;

public class AdventOfCode08 {

    public static final String REGEX_NOP = "^nop.*";
    public static final String REGEX_ACC = "^acc.*";
    public static final String REGEX_JMP = "^jmp.*";
    private final List<String> input;

    public AdventOfCode08(List<String> input) {
        this.input = input;
    }

    public Integer processFirstPart() {

        List<Integer> alreadyProcessedOperation = new ArrayList<>();
        int result = 0;
        int currentIndex = 0;


        while (!alreadyProcessedOperation.contains(currentIndex)) {
            alreadyProcessedOperation.add(currentIndex);

            String currentOperation = input.get(currentIndex);


            if (currentOperation.matches(REGEX_NOP)) {
                ++currentIndex;
            } else if (currentOperation.matches(REGEX_ACC)) {
                ++currentIndex;
                result += Integer.parseInt(currentOperation.split(" ")[1]);

            } else if (currentOperation.matches(REGEX_JMP)) {

                currentIndex += Integer.parseInt(currentOperation.split(" ")[1]);
            }


        }

        return result;


    }


    public Integer processSecondPart() {


        for (int i = 0; i < this.input.size(); i++) {
            int result = 0;
            List<String> tempInput = new ArrayList<>(input);

            String newS = tempInput.get(i);
            if (newS.matches(REGEX_NOP)) {
                newS = newS.replace("nop", "jmp");
            } else if (newS.matches(REGEX_JMP)) {
                newS = newS.replace("jmp", "nop");
            }
            tempInput.set(i, newS);

            int currentIndex = 0;
            List<Integer> alreadyProcessedOperation = new ArrayList<>();
            while (!alreadyProcessedOperation.contains(currentIndex)) {
                alreadyProcessedOperation.add(currentIndex);

                String currentOperation = tempInput.get(currentIndex);


                if (currentOperation.matches(REGEX_NOP)) {
                    ++currentIndex;
                } else if (currentOperation.matches(REGEX_ACC)) {
                    ++currentIndex;
                    result += Integer.parseInt(currentOperation.split(" ")[1]);

                } else if (currentOperation.matches(REGEX_JMP)) {

                    currentIndex += Integer.parseInt(currentOperation.split(" ")[1]);
                }

                if (currentIndex >= tempInput.size()) {
                    return result;
                }

            }

        }
        return 0;


    }

}
