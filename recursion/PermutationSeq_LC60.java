import java.util.ArrayList;
import java.util.List;

public class PermutationSeq_LC60 {
    //SDE
    public String getPermutation(int n, int k) {
        String ans = "";
        List<Integer> nums = new ArrayList<>();

        int fact = 1;
        for (int i = 1; i <= n; i++) {
            nums.add(i);
            fact *= i;
        }
        k -= 1;
        while (true) {
            fact /= n;
            ans += nums.get(k / fact);
            nums.remove(k / fact);
            if (nums.isEmpty())
                break;
            k %= fact;
            n--;
        }
        return ans;
    }
}
