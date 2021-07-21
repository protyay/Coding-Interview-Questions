public class MinTapstoWaterGarden_LC1326 {
    // SDE 
    public int minTaps(int n, int[] ranges) {
        if (n == 1)
            return 1;
        int[] jumps = new int[n + 1];
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i] == 0)
                continue;

            int left = Math.max(0, i - ranges[i]);
            jumps[left] = Math.max(jumps[left], i + ranges[i]);
        }

        // jump game II
        int jump = 0, maxReach = 0, currEnd = 0;
        for (int i = 0; i < jumps.length; i++) {
            maxReach = Math.max(jumps[i], maxReach);
            if (maxReach >= n)
                break;

            if (i == maxReach)
                return -1; // Jump Game 1 concept
            if (i == currEnd) {
                ++jump;
                currEnd = maxReach;
            }
        }
        return jump + 1;
    }
}
/**
ranges = [3,4,1,1,0,0]
jumps =  [5,3,4,0,4,5]
Intervals

For index 0 ---> [0,3]
For index 1 ---> [0,5]
For index 2 ---> [1,3]
For index 3 ---> [2,4]
For index 4 ---> [4,4]
For index 5 ---> [5,5]

2nd example -
ranges - [0,0,0,0]
jumps - [0,0,0,0,0]

3rd example - 
ranges - [1,2,1,0,2,1,0,1]
jumps -  [3,3,6,0,6,0,7,0,0]
         [0,0,0,0,0,0,0,0,0]

interval - 
[0, 1], [0, 3], [1, 3], [2, 6], [4, 6], [6,7]
*/
