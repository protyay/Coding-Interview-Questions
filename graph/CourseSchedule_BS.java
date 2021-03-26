import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Kahn's Algorithm for Top Sorting
 */
public class CourseSchedule_BS {
    public boolean solve(int[][] courses) {
        // Find the start Node, zero in-degree node
        int V = courses.length;
        if (courses.length == 1)
            return true;
        int[] inDegree = new int[V];
        for (int[] course : courses) {
            for (int to : course) {
                inDegree[to]++;
            }
        }
        // You would want to essentially start with the course
        // that has not prerequisite
        Deque<Integer> vertices = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                vertices.addLast(i);
            }
        }
        int index = 0;
        int[] topOrder = new int[V];
        while (!vertices.isEmpty()) {
            int size = vertices.size();
            while (size-- > 0) {
                int vertex = vertices.removeFirst();
                topOrder[index++] = vertex;
                int[] neighbours = courses[vertex];
                for (int course : neighbours) {
                    inDegree[course]--;
                    if (inDegree[course] == 0)
                        vertices.addLast(course);
                }
            }
        }
        if (index == V)
            return true;
        return false;
    }
}
