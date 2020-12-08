package adventofcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdventOfCode08 {

    private final List<String> input;

    private final Set<String> set = new HashSet<>();

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


            if (currentOperation.matches("^nop.*")) {
                ++currentIndex;
            } else if (currentOperation.matches("^acc.*")) {
                ++currentIndex;
                result += Integer.parseInt(currentOperation.split(" ")[1]);

            } else if (currentOperation.matches("^jmp.*")) {

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
            if (newS.matches("^nop.*")) {
                newS = newS.replace("nop", "jmp");
            } else if (newS.matches("^jmp.*")) {
                newS = newS.replace("jmp", "nop");
            }
            tempInput.set(i, newS);

            int currentIndex = 0;
            List<Integer> alreadyProcessedOperation = new ArrayList<>();
            while (!alreadyProcessedOperation.contains(currentIndex)) {
                alreadyProcessedOperation.add(currentIndex);

                String currentOperation = tempInput.get(currentIndex);


                if (currentOperation.matches("^nop.*")) {
                    ++currentIndex;
                } else if (currentOperation.matches("^acc.*")) {
                    ++currentIndex;
                    result += Integer.parseInt(currentOperation.split(" ")[1]);

                } else if (currentOperation.matches("^jmp.*")) {

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
