package adventofcode;

import java.util.List;

public class AdventOfCode11 {

    private List<String> input;

    public AdventOfCode11(List<String> input) {
        this.input = input;
    }

    public Long processFirstPart() {

        int rowSize = input.get(0).length();
        StringBuilder sb = new StringBuilder();
        for (String s : input) {
            sb.append(s);
        }

        String layout = sb.toString();

        String processedLayout = "";
        while (!layout.equals(processedLayout)) {
            sb = new StringBuilder();
            for (int i = 0; i < layout.length(); i++) {
                if (layout.charAt(i) != '.') {

                    if (layout.charAt(i) == 'L' && numberOfAdjacentOccupiedSeats(layout, i, rowSize) == 0) {
                        sb.append('#');
                    } else if (layout.charAt(i) == '#' && numberOfAdjacentOccupiedSeats(layout, i, rowSize) > 3) {
                        sb.append('L');
                    } else {
                        sb.append(layout.charAt(i));
                    }

                } else {
                    sb.append(".");
                }

            }
            processedLayout = layout;
            layout = sb.toString();
        }

        return layout.codePoints().filter(ch -> ch == '#').count();
    }


    private int numberOfAdjacentOccupiedSeats(String layout, int x, int rowSize) {
        int numberOfAdjacentOccupiedSeats = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (!(i == 0 && j == 0) && adjacentSeat(layout, x, i, j, rowSize) == '#') {
                    numberOfAdjacentOccupiedSeats++;
                }
            }
        }

        return numberOfAdjacentOccupiedSeats;
    }

    static char adjacentSeat(String layout, int pos, int x, int y, int gap) {
        int seatPos = pos + x;

        if (!(seatPos % gap == 0 && x == 1) && !(x == -1 && (pos) % gap == 0)) {
            if (y == 1) {
                seatPos += gap;
            } else if (y == -1) {
                seatPos -= gap;
            }

            if (seatPos >= 0 && seatPos < layout.length()) {
                return layout.charAt(seatPos);
            }
        }

        return '.';

    }

    public Long processSecondPart() {

        int rowSize = input.get(0).length();
        StringBuilder sb = new StringBuilder();
        for (String s : input) {
            sb.append(s);
        }

        String layout = sb.toString();

        String processedLayout = "";
        while (!layout.equals(processedLayout)) {
            sb = new StringBuilder();
            for (int i = 0; i < layout.length(); i++) {
                if (layout.charAt(i) != '.') {

                    if (layout.charAt(i) == 'L' && numberOfVisibleOccupiedSeats(layout, i, rowSize) == 0) {
                        sb.append('#');
                    } else if (layout.charAt(i) == '#' && numberOfVisibleOccupiedSeats(layout, i, rowSize) > 4) {
                        sb.append('L');
                    } else {
                        sb.append(layout.charAt(i));
                    }
                } else {
                    sb.append(".");
                }

            }
            processedLayout = layout;
            layout = sb.toString();
        }


        return layout.codePoints().filter(ch -> ch == '#').count();

    }


    private int numberOfVisibleOccupiedSeats(String layout, int x, int rowSize) {
        int numberOfAdjacentOccupiedSeats = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (!(i == 0 && j == 0) && visibleSeat(layout, x, i, j, rowSize) == '#') {
                    numberOfAdjacentOccupiedSeats++;
                }
            }
        }

        return numberOfAdjacentOccupiedSeats;
    }

    static char visibleSeat(String layout, int pos, int x, int y, int gap) {
        int seatPos = pos + x;

        if (!(seatPos % gap == 0 && x == 1) && !(x == -1 && (pos) % gap == 0)) {
            if (y == 1) {
                seatPos += gap;
            } else if (y == -1) {
                seatPos -= gap;
            }

            if (seatPos >= 0 && seatPos < layout.length()) {
                if (layout.charAt(seatPos) == '.') {
                    return visibleSeat(layout, seatPos, x, y, gap);
                }
                return layout.charAt(seatPos);
            }
        }

        return '.';

    }

}