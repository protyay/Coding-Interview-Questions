public class AddBinary_LC67 {
    public String addBinary(String a, String b) {
        if (a.isEmpty())
            return b;
        if (b.isEmpty())
            return a;

        StringBuilder res = new StringBuilder();
        int lenA = a.length(), lenB = b.length(), sum = 0;
        while (lenA > 0 || lenB > 0) {
            sum = sum / 2;
            if (lenA > 0) {
                sum += a.charAt(--lenA) - '0';
            }
            if (lenB > 0) {
                sum += b.charAt(--lenB) - '0';
            }
            res.append(sum % 2);
        }
        if ((sum / 2) == 1)
            res.append(1);
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary_LC67 lc67 = new AddBinary_LC67();
        String a = "11", b = "1";
        String ans = lc67.addBinary(a, b);
        System.out.println(ans);
    }
}
