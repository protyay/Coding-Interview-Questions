import java.util.ArrayList;
import java.util.List;

/**
 * Kahn's Algorithm for Top Sorting
 */
public class CourseSchedule_LC207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 1)
            return true;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 1; i <= numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            int from = edge[0], to = edge[1];
            adjList.get(from).add(to);
        }
        boolean[] dfsPath = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (visited[i])
                continue;
            if (hasCycle(i, visited, dfsPath, adjList))
                return false;
        }
        return true;
    }

    private boolean hasCycle(int currNode, boolean[] visited, boolean[] dfsPath, List<List<Integer>> adjList) {
        visited[currNode] = true;
        List<Integer> neighbours = adjList.get(currNode);
        dfsPath[currNode] = true;
        for (int n : neighbours) {
            if (dfsPath[n])
                return true;

            if (!visited[n] && hasCycle(n, visited, dfsPath, adjList))
                return true;
        }
        dfsPath[currNode] = false;
        return false;
    }
}
