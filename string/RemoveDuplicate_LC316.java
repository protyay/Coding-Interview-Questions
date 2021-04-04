import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveDuplicate_LC316 {
    public String removeDuplicateLetters(String s) {

        char[] ch = s.toCharArray();
        int[] freq = new int[26];
        boolean[] visited = new boolean[26];

        for (int i = 0; i < ch.length; i++) {
            freq[ch[i] - 'a']++;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < ch.length; i++) {
            if(visited[ch[i] - 'a']) continue;
            freq[ch[i] - 'a']--;
            if (!stack.isEmpty()) {
                if (stack.getFirst() < ch[i] && !visited[ch[i] - 'a']) {
                    stack.addFirst(ch[i]);
                    visited[ch[i] - 'a'] = true;
                } else {
                    while (!stack.isEmpty() && stack.getFirst() > ch[i] && freq[stack.getFirst() - 'a'] > 0) {
                        char removed = stack.removeFirst();
                        visited[removed - 'a'] = false;
                    }
                    stack.addFirst(ch[i]);
                    visited[ch[i] - 'a'] = true;
                }
            } else {
                stack.addFirst(ch[i]);
                visited[ch[i] - 'a'] = true;
            }
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicate_LC316 lc316 = new RemoveDuplicate_LC316();
        String ans = lc316.removeDuplicateLetters("cbacdcbc");
        System.out.println("Final str = "+ ans);
    }
}
