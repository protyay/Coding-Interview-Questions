import java.util.*;

public class KClosesetPoints2Origin_LC973 {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        // We are using a MAX-HEAP because at every point , we would want to remove the
        // POINT that is FARTHEST from the
        // ORIGIN
        Queue<Point> q = new PriorityQueue<>((a, b) -> Integer.compare(b.originDist, a.originDist));
        for (int i = 0; i < points.length; i++) {
            int[] xy = points[i];
            Point p = new Point(xy, calcDist(xy));
            if (q.size() == k) {
                // This is the the CRUX of the problem.
                // If the current co-ordinate IS CLOSER to ORIGIN, it IS a better candidate for
                // the result.
                if (q.peek().originDist > p.originDist) {
                    q.poll();
                    q.add(p);
                }
            } else
                q.add(p);
        }
        // Forming the result
        for (int i = 0; i < k; i++) {
            res[i] = q.poll().xy;
        }
        return res;
    }

    private int calcDist(int[] point) {
        int x = point[0], y = point[1];
        return x * x + y * y;
    }
}

class Point {
    int[] xy;
    int originDist;

    Point(int[] xy, int originDist) {
        this.xy = xy;
        this.originDist = originDist;
    }

}

class ShorterVersion {
    public int[][] kClosest(int[][] points, int k) {
        // We can use a PQ to store K points that are closest to origin
        Queue<int[]> pq = new PriorityQueue<>(k, (a, b) -> Integer.compare(dist(a), dist(b)));
        for (int[] p : points) {
            pq.add(p);
        }
        int[][] res = new int[k][2];
        while (!pq.isEmpty() && k > 0) {
            res[--k] = pq.remove();
        }
        return res;
    }

    private int dist(int[] point) {
        return (point[0] * point[0]) + (point[1] * point[1]);
    }
}
