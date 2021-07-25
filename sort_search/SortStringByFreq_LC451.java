import java.util.LinkedList;

public class SortStringByFreq_LC451 {

    @SuppressWarnings("unchecked")
    public String frequencySort(String s) {
        int[] freqArr = new int[128];
        for (char c : s.toCharArray()) {
            freqArr[c]++;
        }
        LinkedList<Integer>[] freq = new LinkedList[s.length() + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new LinkedList<>();
        }

        for (int i = 0; i < freqArr.length; i++) {
            if (freqArr[i] == 0)
                continue;
            freq[freqArr[i]].addLast(i);
        }
        StringBuilder str = new StringBuilder();
        for (int i = freq.length - 1; i >= 0; i--) {
            while (!freq[i].isEmpty()) {
                String element = Character.toString((char) freq[i].removeLast().intValue());
                int k = i;
                while (k-- > 0) {
                    str.append(element);
                }
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String input = "tree";
        SortStringByFreq_LC451 lc451 = new SortStringByFreq_LC451();
        String ans = lc451.frequencySort(input);
        System.out.println("Sorted Str =" + ans);
    }

}
