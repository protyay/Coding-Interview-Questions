import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget_LC797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        int N = graph.length;
        dfs(paths, new ArrayList<>(), 0, N, graph);
        return paths;
    }

    private void dfs(List<List<Integer>> res, List<Integer> temp, int start, int N, int[][] graph) {
        temp.add(start);
        if (start == N - 1) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int next : graph[start]) {
            dfs(res, temp, next, N, graph);
            temp.remove(temp.size() - 1);
        }
    }
}
