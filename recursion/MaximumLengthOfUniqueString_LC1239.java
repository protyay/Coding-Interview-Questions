import java.util.List;

public class MaximumLengthOfUniqueString_LC1239 {
    // SDE 
    private int maxLen = 0;
    public int maxLength(List<String> arr) {
        dfs(arr, 0, "", 0);
        return maxLen;
    }
    private void dfs(List<String> arr, int index, String prev, int len){
        maxLen = Math.max(len, maxLen);
        for(int i = index; i < arr.size(); i++){
            String curr = arr.get(i);
            // If both contains unique chars, then we add the curr string
            if(hasUniqueChar(curr, prev)){
                dfs(arr, i + 1, curr + prev, len + curr.length());
            }
        }
    }
    private boolean hasUniqueChar(String curr, String word){
        int[] a = new int[26];
        for(char c : curr.toCharArray()){
            if(a[c - 'a'] > 0){
                return false;
            }
            a[c - 'a']++;
        }
        for(char c : word.toCharArray()){
            if(a[c - 'a'] > 0) return false;
        }
        return true;
    }
}
