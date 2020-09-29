package coding.reservation;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Plane seat reservation challenge
 * A plane has arrangement of 10 seats in a row, separated by two isles
 * example:  A B C _ D E F G  _ H J K
 * Count number of max possible family reservations,
 * for the given number of rows , starting from 1.
 * Family considered a group of 4 people
 * Members of a family must be seated together, in continuous row of 4 seats,
 * or separated by isle as 2+2 scheme.
 * Examples of group seating:
 *  DEFG - valid
 *  BCDE - valid
 *  FGHJ - valid
 *  ABCD - invalid
 *  GHJK - invalid
 */
public class PlaneSeatReservation {

    private static int MAX_ROWS = 100; // A380 has 94 rows in max capacity configuration

    // Bitmap mask for occupied seat in a row
    // all occupied seats in a row coded as bitwise OR operation
    private static Map<String, Integer> seatCodeToMask = new HashMap<>();

    static {
        seatCodeToMask.put("A", 0b100_0000_000);
        seatCodeToMask.put("B", 0b010_0000_000);
        seatCodeToMask.put("C", 0b001_0000_000);
        seatCodeToMask.put("D", 0b000_1000_000);
        seatCodeToMask.put("E", 0b000_0100_000);
        seatCodeToMask.put("F", 0b000_0010_000);
        seatCodeToMask.put("G", 0b000_0001_000);
        seatCodeToMask.put("H", 0b000_0000_100);
        seatCodeToMask.put("J", 0b000_0000_010);
        seatCodeToMask.put("K", 0b000_0000_001);
    }

    /**
     * Count possible reservations of groups of 4 people, where group can be seated
     * either together (4 seats in a row), or 2+2 separated by isle
     *
     * @param requiredRows    how many rows to check, starting from 1
     * @param occupiedSeatMap encoded map of reserved seats, as string "1A 3C 1F 10D"
     * @return number of max group reservations, for the given rows
     */
    public int countGroupReservations(int requiredRows, String occupiedSeatMap) {

        if (requiredRows > MAX_ROWS) {
            throw new RuntimeException("Max rows exceeded");
        }

        if (StringUtils.isEmpty(occupiedSeatMap)) {
            return 2 * requiredRows;
        }

        Map<Integer, Integer> occupiedSeat = new HashMap<>();
        Pattern pattern = Pattern.compile("((\\d+)([ABCDEFGHJK]))\\s?");
        Matcher matcher = pattern.matcher(occupiedSeatMap);
        boolean found = false;
        while (matcher.find()) {
            found = true;
            int row = Integer.parseInt(matcher.group(2));
            String seat = matcher.group(3);
            occupiedSeat.put(row, occupiedSeat.getOrDefault(row, 0) | seatCodeToMask.get(seat));
        }
        if (!found) {
            throw new RuntimeException("Invalid input format");
        }

        // Continuous seat arrangement in group of 4 possible only on seats B to D and F to J,
        // or D to G , but not simultaneiously
        // zeroes corresponding seats we need to test availability against
        int maskFreeBtoD = 0b100_0011_111;
        int maskFreeDtoG = 0b111_0000_111;
        int maskFreeFtoJ = 0b111_1100_001;

        int count = 0;
        for (int rownum = 1; rownum <= requiredRows; rownum++) {
            if (occupiedSeat.containsKey(rownum)) {
                int occupied = occupiedSeat.get(rownum);
                int testBtoD = maskFreeBtoD | occupied;
                int testDtoG = maskFreeDtoG | occupied;
                int testFtoJ = maskFreeFtoJ | occupied;
                if (testDtoG == maskFreeDtoG && testBtoD != maskFreeBtoD &&
                    testFtoJ != maskFreeFtoJ) { // falls into continuous D-G arrangement
                    count++;
                }
                if (testBtoD == maskFreeBtoD) { // falls into 2+2 B-D arrangement
                    count++;
                }
                if (testFtoJ == maskFreeFtoJ) { // falls into 2+2 F-J arrangement
                    count++;
                }
            } else {    // all seats in the row free - max 2 group reservations
                count += 2;
            }
        }

        return count;
    }
}
