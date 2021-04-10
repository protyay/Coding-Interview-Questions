public class MinDistanceOfTwoWords_BS {
    public int solve(String text, String word0, String word1) {

        if (text == null || text.isEmpty())
            return -1;
        int dist = Integer.MAX_VALUE;

        int idxA = -1, idxB = -1;

        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word0)) {
                if (idxB > -1)
                    dist = Math.min(dist, Math.abs(i - idxB) - 1);
                idxA = i;
            } else if (words[i].equals(word1)) {
                if (idxA > -1)
                    dist = Math.min(dist, Math.abs(i - idxA) - 1);
                idxB = i;
            }
        }
        if (idxA == -1 || idxB == -1)
            return -1;
        return dist;
    }
}
/**
 * 
 */
