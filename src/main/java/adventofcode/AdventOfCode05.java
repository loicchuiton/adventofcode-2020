package adventofcode;

import java.util.ArrayList;
import java.util.List;

public class AdventOfCode05 {
    private final List<String> input;

    public AdventOfCode05(List<String> input) {
        this.input = input;
    }

    public Integer processFirstPart() {

        List<Integer> listOfSeats = getListOfSeats();

        listOfSeats.sort((Integer::compareTo));

        return listOfSeats.get(listOfSeats.size() - 1);
    }

    private List<Integer> getListOfSeats() {
        List<Integer> listOfSeats = new ArrayList<>();
        for (String s : input) {

            int column = getColumn(s);
            int row = getRow(s);
            int seatId = row * 8 + column;


            listOfSeats.add(seatId);
        }
        return listOfSeats;
    }

    public Integer processSecondPart() {
        List<Integer> listOfSeats = getListOfSeats();

        listOfSeats.sort((Integer::compareTo));

        for (int i = 0; i < listOfSeats.size() - 1; i++) {
            if ((listOfSeats.get(i + 1) > listOfSeats.get(i) + 1)) {
                return listOfSeats.get(i) + 1;
            }

        }
        return 0;
    }

    Integer getRow(String s) {
        int minRow = 0;
        int maxRow = 127;

        for (char c : s.toCharArray()) {

            if (c == 'F') {
                maxRow = maxRow - (maxRow - minRow) / 2 - (maxRow - minRow) % 2;
            } else if (c == 'B') {
                minRow = minRow + (maxRow - minRow) / 2 + (maxRow - minRow) % 2;
            }

        }

        return minRow;
    }

    public Integer getColumn(String s) {
        int minColumn = 0;
        int maxColumn = 7;

        for (char c : s.toCharArray()) {
            if (c == 'L') {
                maxColumn = maxColumn - (maxColumn - minColumn) / 2 - (maxColumn - minColumn) % 2;
            } else if (c == 'R') {
                minColumn = minColumn + (maxColumn - minColumn) / 2 + (maxColumn - minColumn) % 2;
            }

        }

        return minColumn;
    }
}
