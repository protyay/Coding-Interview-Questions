import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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

class CourseSchedule_LC207 {
    // This method employs NAIVE DFS - For each node, we would check if there's a
    // cycle.
    // If there's a cycle, then effectively we won't be able to complete this.
    // Detecting a cycle in a Directed Graph
    // This results in O(E) - which are my prerequisites and O(V^2) where V is my
    // num of courses
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // If we are using a DFS traversal of the graph, we need to
        // check for cycle for all possible start courses

        // let's build the graph
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int[] c : prerequisites) {
            int from = c[0];
            int to = c[1];

            adjList.get(from).add(to);
        }
        // We need to verify if there's a cycle in a DAG starting from
        // every course.
        boolean[] visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (this.hasCycle(i, adjList, visited))
                return false;
        }
        return true;
    }

    private boolean hasCycle(int startV, List<List<Integer>> adjList, boolean[] visited) {
        if (visited[startV])
            return true;
        visited[startV] = true;

        List<Integer> neighbours = adjList.get(startV);
        for (int n : neighbours) {
            if (hasCycle(n, adjList, visited))
                return true;
        }
        visited[startV] = false;
        return false;
    }
}

class CourseSchedule_LC207_OptimizedDFS {
    // This is OPTIMISED DFS - Cycle in DIRECTED graph can be checked in linear time
    // once we maintain a DFS of curr Path

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // If we are using a DFS traversal of the graph, we need to
        // check for cycle for all possible start courses

        // let's build the graph
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int[] c : prerequisites) {
            int from = c[0];
            int to = c[1];

            adjList.get(from).add(to);
        }
        // We need to verify if there's a cycle in a DAG starting from
        // every course.
        boolean[] visited = new boolean[numCourses];
        boolean[] currPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (visited[i])
                continue;
            if (this.hasCycle(i, adjList, visited, currPath))
                return false;
        }
        return true;
    }

    private boolean hasCycle(int startV, List<List<Integer>> adjList, boolean[] visited, boolean[] currPath) {

        visited[startV] = true;
        currPath[startV] = true;

        List<Integer> neighbours = adjList.get(startV);
        for (int n : neighbours) {
            if (!visited[n]) {
                if (hasCycle(n, adjList, visited, currPath))
                    return true;
            } else if (currPath[n])
                return true;
        }
        currPath[startV] = false;
        return false;
    }
}
