import java.util.Arrays;

public class CompareVersionNums_LC164 {
    public int compareVersion(String version1, String version2) {
        // 1.0.8 // 1.0.7
        if (version1 == null || version1.isBlank() || version2 == null || version2.isBlank())
            return 0;

        int[] v1 = Arrays.stream(version1.split("\\.")).mapToInt(Integer::parseInt).toArray();
        int[] v2 = Arrays.stream(version2.split("\\.")).mapToInt(Integer::parseInt).toArray();

        int i = 0, j = 0, compare = 0;
        while (i < v1.length || j < v2.length) {
            int va = i < v1.length ? v1[i] : 0;
            int vb = j < v2.length ? v2[j] : 0;

            compare = Integer.compare(va, vb);
            if (compare != 0)
                break;
            i++;
            j++;
        }
        return compare;
    }

    public static void main(String[] args) {
        CompareVersionNums_LC164 lc164 = new CompareVersionNums_LC164();
        String version1 = "7.5.2.4", version2 = "7.5.8";
        int compareVersion = lc164.compareVersion(version1, version2);
        System.out.println(compareVersion);
    }
}
