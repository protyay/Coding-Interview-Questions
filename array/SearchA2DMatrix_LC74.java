public class SearchA2DMatrix_LC74 {
    // SDE problem Repeat
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length, c = matrix[0].length;
        // [0,0,1,2],[3,4,5,6],[1,2,4,9]
        // 0 1 2 3 4 5 6 7 8 9 10 11
        int lo = 0, hi = (r * c) - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            // we need to find the i and j from the mid
            int i = mid / c;
            int j = mid % c;
            int pivot = matrix[i][j];
            if (pivot == target)
                return true;
            else if (pivot < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return false;
    }
}
