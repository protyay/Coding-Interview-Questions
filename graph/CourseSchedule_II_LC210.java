import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule_II_LC210 {
    public int[] findOrder(int numCourses, int[][] edges) {
        // We find the in-degree of all the edges
        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        int[] inDeg = new int[numCourses];
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            inDeg[to]++;
            edgeMap.computeIfAbsent(from, k -> new ArrayList<Integer>());
            edgeMap.get(from).add(to);
        }

        Deque<Integer> courseQ = new ArrayDeque<>();
        for (int i = 0; i < inDeg.length; i++) {
            if (inDeg[i] == 0) {
                courseQ.addLast(i);
            }
        }
        int index = numCourses - 1;
        int[] order = new int[numCourses];
        while (!courseQ.isEmpty()) {
            // Fetch a course
            int v = courseQ.removeFirst();
            order[index--] = v; // We add this to the topological order
            List<Integer> dependent = edgeMap.getOrDefault(v, new ArrayList<>());
            // We repeatedly remove the nodes from the graph which has NO dependency and
            // process them/ complete them.
            for (int nextCourse : dependent) {
                inDeg[nextCourse]--;
                if (inDeg[nextCourse] == 0)
                    courseQ.addLast(nextCourse);
            }
        }
        // We might encounter a cycle , in that case we retun an empty array
        if (index > 0)
            return new int[] {};
        return order;
    }
}
/**
 * The common mistakes in graph problems is NOT handling the edgeMap fetch
 * scenario wherein a vertex might have no OUTGOING edges. 
 * For returning
 * topological sort, we would start adding the edge with no dependency from the
 * last of the array.
 * 
 * We add to the last of the array because NO course is DEPENDENT on this course.
 * Order is very important. If the prerequisite attempt is EMPTY, then 
 */
