import java.util.Map;

public class IntToStr_LC273 {
    String[] mapA = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
            "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };

    Map<Integer, String> mapB = Map.of(20, "Twenty", 30, "Thirty", 40, "Fourty", 50, "Fifty", 60, "Sixty", 70,
            "Seventy", 80, "Eighty", 90, "Ninety");

    public String numberToWords(int num) {
        final int BILLION = 1_000_000_000;
        final int MILLION = 1_000_000;
        final int THOUSAND = 1_000;

        // divide by 10^9, 10^6, 10^3, 10^2, 10
        if (num == 0)
            return "Zero";
        StringBuilder res = new StringBuilder();
        if (num / BILLION > 0) {
            res.append(getNumeric(num / BILLION));
            res.append(" Billion");
            num %= BILLION;
        }
        if (num / MILLION > 0) {
            res.append(getNumeric(num / MILLION));
            res.append(" Million");
            num %= MILLION;
        }
        if (num / THOUSAND > 0) {
            res.append(getNumeric(num / THOUSAND));
            res.append(" Thousand");
            num %= THOUSAND;
        }
        res.append(decodeHundred(num));
        return res.toString().trim();
    }

    private String getNumeric(int value) {
        if (value < 20)
            return " " + this.mapA[value];
        if (this.mapB.containsKey(value))
            return " " + this.mapB.get(value);
        return decodeHundred(value);
    }

    private String decodeHundred(int num) {
        final int HUNDRED = 100;
        StringBuilder res = new StringBuilder();
        while (num >= HUNDRED) {
            res.append(" " + this.mapA[num / HUNDRED]);
            res.append(" Hundred");
            num %= HUNDRED;
        }
        while (num > 0) {
            if (num < 20) {
                res.append(" " + this.mapA[num]);
                break;
            } else if (this.mapB.containsKey(num)) {
                res.append(" " + this.mapB.get(num));
                break;
            } else {
                res.append(decodeHundred(num - (num % 10)));
                num %= 10;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        IntToStr_LC273 lc273 = new IntToStr_LC273();
        String ans = lc273.numberToWords(123);
        System.out.println("Ans = " + ans);
    }
}
