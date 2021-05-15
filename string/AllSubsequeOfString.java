import java.util.*;

// Also called the power set problem
// SDE
public class AllSubsequeOfString {
    public List<String> findSubsequence(String input) {
        Set<String> sseq = new HashSet<>();
        recurse(sseq, input, "");
        return new ArrayList<>(sseq);
    }

    private void recurse(Set<String> allSeq, String input, String output) {
        if (input.length() == 0) {
            allSeq.add(output);
            return;
        }
        // Pick and don't pick concept. So at each step we recurse using smaller inputs
        // and two branch - one will contain the input and the other will not
        recurse(allSeq, input.substring(1), output + input.charAt(0));
        recurse(allSeq, input.substring(1), output);
    }

    public static void main(String[] args) {
        AllSubsequeOfString sub = new AllSubsequeOfString();
        List<String> subseq = sub.findSubsequence("ABC");
        System.out.println(subseq);
    }

}
