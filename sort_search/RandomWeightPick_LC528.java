import java.util.Random;

public class RandomWeightPick_LC528 {
    private int[] input;
    private final Random rand;
    private final int max;

    public RandomWeightPick_LC528(int[] w) {
        input = new int[w.length];
        this.rand = new Random();
        input[0] = w[0];
        for(int i = 1 ; i < w.length; i++){
            input[i] = input[i-1] + w[i];
        }
        this.max = input[input.length - 1];
    }

    public int pickIndex() {
        int randomIdx = 1 + this.rand.nextInt(this.max);
        int low = 0, high = this.input.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (this.input[mid] == randomIdx)
                return mid;
            else if (this.input[mid] < randomIdx)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }
}
/**
 * The primary idea is to generate index based on the weight of the index.
 * For that, we would need to generate the prefix sum and apply binary search.
 * One of the best interview problems.
 */