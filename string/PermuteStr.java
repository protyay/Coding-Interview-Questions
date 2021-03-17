import java.util.*;

public class PermuteStr {
    int timesExecuted;
    // Take care of the space as well as the time complextiy TC - O(N! * N);
    // Space complexity - O(N)

    public List<String> find_permutation(String S) {
        // Code here
        if (S.isEmpty() || S == null)
            return List.of();
        List<String> permutations = new ArrayList<>();
        char[] ip = S.toCharArray();
        boolean[] visited = new boolean[ip.length];
        recurse(ip, permutations, visited, new StringBuilder());
        System.out.println("Max calls to recurse = " + timesExecuted);
        return permutations;
    }

    private void recurse(char[] ch, List<String> permutation, boolean[] visited, StringBuilder str) {
        ++timesExecuted;
        if (ch.length == str.length()) {
            permutation.add(str.toString());
            return;
        }
        for (int i = 0; i < ch.length; i++) {
            if (visited[i])
                continue;
            str.append(ch[i]);
            visited[i] = true;
            recurse(ch, permutation, visited, str);
            str.deleteCharAt(str.length() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        PermuteStr p = new PermuteStr();
        List<String> perms = p.find_permutation("AB");
        System.out.println(perms);

    }

}
