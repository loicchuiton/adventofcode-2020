package adventofcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdventOfCode10 {

    private List<Integer> input;

    public AdventOfCode10(List<Integer> input) {
        this.input = input;
    }

    public Long processFirstPart() {
        ArrayList<Integer> sortedAdaptersList = new ArrayList<>(input);
        sortedAdaptersList.add(0);
        sortedAdaptersList.sort(Integer::compare);

        Long diff1Jolt = 0L;
        Long diff3Jolt = 1L;
        for (int indexOfCurrentAdapter = 0; indexOfCurrentAdapter < sortedAdaptersList.size() - 1; indexOfCurrentAdapter++) {

            int currentAdapterValue = sortedAdaptersList.get(indexOfCurrentAdapter);
            int nextAdapterValue = sortedAdaptersList.get(indexOfCurrentAdapter + 1);
            if (currentAdapterValue + 1 == nextAdapterValue) {
                ++diff1Jolt;

            } else if (currentAdapterValue + 3 == nextAdapterValue) {
                ++diff3Jolt;
            }
        }

        return (diff1Jolt * diff3Jolt);


    }


    public Long processSecondPart() {

        ArrayList<Integer> sortedAdaptersList = new ArrayList<>(input);
        sortedAdaptersList.add(0);
        sortedAdaptersList.sort(Integer::compare);

        Map<Integer, Long> pathMap = new HashMap<>();

        pathMap.put(0, 1L);

        for (int indexOfCurrentAdapter = 0; indexOfCurrentAdapter < sortedAdaptersList.size(); indexOfCurrentAdapter++) {
            int indexOfNextAdapter = indexOfCurrentAdapter + 1;

            while (indexOfNextAdapter < sortedAdaptersList.size()
                    && isCompatibleAdapter(sortedAdaptersList.get(indexOfCurrentAdapter), sortedAdaptersList.get(indexOfNextAdapter))) {

                pathMap.merge(indexOfNextAdapter, pathMap.get(indexOfCurrentAdapter), Long::sum);
                indexOfNextAdapter++;
            }
        }

        return pathMap.get(sortedAdaptersList.size() - 1);

    }

    private boolean isCompatibleAdapter(Integer currentAdapter, Integer nextAdapter) {
        return nextAdapter <= currentAdapter + 3;
    }
}