public class CountAndSay_LC38 {

    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        String res = countAndSay(n - 1);
        StringBuilder digitStr = new StringBuilder();
        int count = 1;
        char prev = res.charAt(0);
        for (int i = 1; i < res.length(); i++) {
            char currCh = res.charAt(i);
            if (currCh == prev) {
                ++count;
                continue;
            }
            digitStr.append(count);
            digitStr.append(prev);

            prev = currCh;
            count = 1;
        }
        digitStr.append(count);
        digitStr.append(prev);

        return digitStr.toString();
    }

    public static void main(String[] args) {
        CountAndSay_LC38 lc = new CountAndSay_LC38();
        int n = 4;
        String res = lc.countAndSay(n);
        System.out.println(res);

    }
}