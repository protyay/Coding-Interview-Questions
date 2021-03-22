import java.util.*;

public class KnightMovesToTarget_BS597 {

    int[][] moves = { { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 }, { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 } };

    public int solve(int r, int c) {
        LocPoint start = new LocPoint(0, 0);
        Set<LocPoint> visited = new HashSet<>();
        Deque<LocPoint> locations = new ArrayDeque<>();
        locations.addLast(start);
        int steps = 0;
        while (!locations.isEmpty()) {
            int size = locations.size();
            while (size-- > 0) {
                LocPoint p = locations.removeFirst();
                visited.add(p);
                if (p.x == r && p.y == c)
                    return steps;
                genNextLocations(locations, p, visited);
            }
            ++steps;
        }
        return steps;
    }

    private void genNextLocations(Deque<LocPoint> locations, LocPoint p, Set<LocPoint> visitedLocs) {
        for (int i = 0; i < moves.length; i++) {
            int[] loc = moves[i];
            LocPoint nextLoc = new LocPoint(p.x + loc[0], p.y + loc[1]);
            if (!visitedLocs.contains(nextLoc) && inRange(nextLoc))
                locations.addLast(nextLoc);
        }
    }

    private boolean inRange(LocPoint a) {
        // return a.x >= 0 && a.y >= 0;
        return true;
    }

    public static void main(String[] args) {
        KnightMovesToTarget_BS597 bs597 = new KnightMovesToTarget_BS597();
        //int ans = bs597.solve(-5, 2);
        //System.out.println(ans);
        LocPoint a = new LocPoint(4, -5);
        LocPoint b = new LocPoint(4, -5);
        System.out.println(a.equals(b));
    }

}

class LocPoint {
    int x;
    int y;

    LocPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(LocPoint rhs) {
        return this.x == rhs.x && this.y == rhs.y;
    }
}