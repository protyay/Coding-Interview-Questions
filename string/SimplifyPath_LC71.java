import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath_LC71 {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        for (String dir : path.split("/")) {
            if (dir.isEmpty() || dir.equals("."))
                continue;
            if (dir.equals("..")) {
                if (!stack.isEmpty())
                    stack.removeFirst();
                continue;
            }
            stack.addFirst(dir);
        }
        StringBuilder res = new StringBuilder("/");
        while (!stack.isEmpty()) {
            res.append(stack.removeLast());
            if (stack.size() > 0)
                res.append("/");
        }
        return res.toString();
    }
}
