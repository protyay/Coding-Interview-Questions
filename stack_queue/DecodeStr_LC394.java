import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeStr_LC394 {
    public String decodeString(String s) {
        if (s.length() < 3)
            return "";
        char[] ch = s.toCharArray();

        // Initialize Auxiliary Data structures
        Deque<StringBuilder> strStack = new ArrayDeque<>();
        Deque<Integer> intStack = new ArrayDeque<>();

        // Intialize state variables.
        StringBuilder curr = new StringBuilder();
        int repeat = 0;

        for (int i = 0; i < ch.length; i++) {

            if (ch[i] == '[') {
                strStack.addFirst(curr);
                intStack.addFirst(repeat);

                repeat = 0;
                curr = new StringBuilder();
            } else if (Character.isDigit(ch[i])) {
                repeat = (repeat * 10) + (ch[i] - '0');
            } else if (ch[i] == ']') {
                // Assuming the stack won't be empty for a well-formed string
                strStack.getFirst().append(curr.toString().repeat(intStack.removeFirst()));
                curr = strStack.removeFirst();
            } else {
                curr.append(ch[i]);
            }
        }
        return curr.toString();
    }

    public static void main(String[] args) {
        DecodeStr_LC394 lc394 = new DecodeStr_LC394();
        String ans = lc394.decodeString("31[at]2[ct]");
        System.out.println("Answer =" + ans);
    }
}
/**
 * Trick Build a stack with StringBuilder type. Push to Both Count and
 * StringBuilder when [ is encountered For ] bracket, we append to the top of
 * the string the repeated current element Then make the top StringBuilder
 * object as the current object.
 */
/*
 * public String decodeString(String s) { if(s.length() < 3) return ""; char[]
 * ch = s.toCharArray();
 * 
 * // Initialize Auxiliary Data structures Deque<StringBuilder> strStack = new
 * ArrayDeque<>(); Deque<Integer> intStack = new ArrayDeque<>();
 * 
 * // Intialize state variables. StringBuilder curr = new StringBuilder(); int
 * repeat = 0;
 * 
 * for(int i = 0 ; i < ch.length; i++){
 * 
 * if(ch[i] == '['){ strStack.addFirst(curr); intStack.addFirst(repeat);
 * 
 * repeat = 0; curr.delete(0, curr.length()); } else
 * if(Character.isDigit(ch[i])){ repeat = (repeat * 10) + (ch[i] - '0'); } else
 * if(ch[i] == ']') { // Assuming the stack won't be empty for a well-formed
 * string
 * strStack.getFirst().append(curr.toString().repeat(intStack.removeFirst()));
 * curr = strStack.removeFirst(); } else{ curr.append(ch[i]); } } return
 * curr.toString(); }
 */