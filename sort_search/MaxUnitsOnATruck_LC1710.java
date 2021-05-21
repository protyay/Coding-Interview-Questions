import java.util.Arrays;

public class MaxUnitsOnATruck_LC1710 {
    // SDE repeat
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // GREEDY should work here.
        // At every iteration, we select the box with max unit
        // [5,10],[3,9],[4,7],[2,5]
        // It's absolutely greedy solution, because we can pick fractional
        // number of boxes from the given boxes
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        int units = 0;
        for (int[] box : boxTypes) {
            int taken = Math.min(box[0], truckSize);
            units += (taken * box[1]);
            truckSize -= taken;
            if (truckSize == 0)
                break;
        }
        return units;
    }
}
