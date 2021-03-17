import java.util.*;

public class PrintStatementFromWord {
    public static void main(String[] args) {
        PrintStatementFromWord p = new PrintStatementFromWord();
        List<List<String>> ip = Arrays.asList(List.of("you", "we"), List.of("have", "are"),
                List.of("sleep", "eat", "drink"));
        List<String> res = p.findStatement(ip);
        System.out.println(res);
    }

    public List<String> findStatement(List<List<String>> words) {
        List<String> ans = new ArrayList<>();
        if (words.size() == 1)
            return words.get(0);
        recurse(ans, words, 0, new ArrayList<>());
        return ans;
    }

    private void recurse(List<String> res, List<List<String>> words, int start, List<String> temp) {
        if (temp.size() == words.size()) {
            res.add(String.join(" ", temp));
            return;
        }
        List<String> currGroup = words.get(start);
        for (String w : currGroup) {
            temp.add(w);
            recurse(res, words, start + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }

}
