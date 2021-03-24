import java.util.*;

public class KnightMovesToTarget_BS597 {

    public int knight(int A, int B, int C, int D, int E, int F) {
        // Code here
        int[][] moves = { { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 }, { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 } };
        Deque<Location> locations = new ArrayDeque<>();
        Location locStart = new Location(C, D);
        boolean[][] visited = new boolean[A + 1][B + 1];
        visited[C][D] = true;
        locations.addLast(locStart);
        int re = E;
        int ce = F;

        int steps = 0;
        while (!locations.isEmpty()) {
            int size = locations.size();
            while (size-- > 0) {
                Location loc = locations.removeFirst();
                int r = loc.r, c = loc.c;
                if (r == re && c == ce)
                    return steps;

                // Generate next possible move locations
                for (int i = 0; i < moves.length; i++) {
                    int rn = r + moves[i][0];
                    int cn = c + moves[i][1];

                    if (rn > A || cn > B || rn < 0 || cn < 0 || visited[rn][cn])
                        continue;
                    visited[rn][cn] = true;
                    locations.addLast(new Location(rn, cn));
                }
            }
            ++steps;
        }
        return -1;
    }

    public static void main(String[] args) {
        KnightMovesToTarget_BS597 bs597 = new KnightMovesToTarget_BS597();
        // int ans = bs597.solve(-5, 2);
        // System.out.println(ans);
        int A = 2, B = 20, C = 1, D = 18, E = 1, F = 5;
        int ans = bs597.knight(A, B, C, D, E, F);
        System.out.println(ans);
    }

}

class Location {
    int r;
    int c;

    Location(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
