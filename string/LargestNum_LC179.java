import java.util.Arrays;

public class LargestNum_LC179 {
    // SDE
    public String largestNumber(int[] nums) {
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(asStrs, (a, b) -> {
            String o1 = a + b;
            String o2 = b + a;

            return o2.compareTo(o1);
        });
        if (asStrs[0].equals("0"))
            return "0";

        StringBuffer largest = new StringBuffer();
        for (String str : asStrs)
            largest.append(str);
        return largest.toString();
    }
}
