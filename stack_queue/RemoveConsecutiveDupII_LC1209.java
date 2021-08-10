public class RemoveConsecutiveDupII_LC1209 {
    // SDE Repeat
    public String removeDuplicates(String s, int k) {
        int i = 0, n = s.length();
        char[] stack = s.toCharArray();
        int[] count = new int[n];
        // Re-writing a char array
        for (int j = 0; j < n; j++, i++) {
            stack[i] = stack[j];
            count[i] = i > 0 && stack[i - 1] == stack[j] ? count[i - 1] + 1 : 1;
            if (count[i] == k)
                i -= k;
        }

        return new String(stack, 0, i);
    }
    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        int k = 3;
        RemoveConsecutiveDupII_LC1209 lc1209 = new RemoveConsecutiveDupII_LC1209();
        String ans = lc1209.removeDuplicates(s, k);
        System.out.println("ans  ="+ans);
    }
}
/**
 * deeedbbcccbdaa", k = 3
 * deee
 * 1123
 */
