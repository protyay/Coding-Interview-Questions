public class CountAndSay_LC38 {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            String res = countAndSay(n - 1);
            if (res.equals("1"))
                return "11";
            StringBuilder str = new StringBuilder();
            res += "#";
            char[] ch = res.toCharArray();
            int count = 1;
            char currCh = ch[0];
            for (int i = 1; i < ch.length; i++) {
                if (ch[i] != ch[i - 1]) {
                    str.append(count);
                    str.append(currCh);
                    currCh = ch[i];
                    count = 1;
                } else {
                    ++count;
                }
            }
            return str.toString();
        }
    }

    public static void main(String[] args) {
        CountAndSay_LC38 lc = new CountAndSay_LC38();
        int n = 4;
        String res = lc.countAndSay(n);
        System.out.println(res);

    }
}