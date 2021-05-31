public class MedianOfTwoSortArr_LC4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int half = (total + 1) / 2;
        
        int small[] = nums1.length < nums2.length ? nums1 : nums2;
        int larger[] = small == nums1 ? nums2 : nums1;
        
        int n1 = small.length, n2 = larger.length;
        int lo = 0, hi = n1;
        
        while(lo <= hi){
            int cutA = lo + (hi - lo)/2;
            int cutB = half - cutA;
        
            // Define the boundary elements, l1, l2 r1, r2
            int l1 = cutA == 0 ? Integer.MIN_VALUE : small[cutA - 1];
            int l2 = cutB == 0 ? Integer.MIN_VALUE : larger[cutB - 1];
        
            int r1 = cutA == n1 ? Integer.MAX_VALUE : small[cutA];
            int r2 = cutB == n2 ? Integer.MAX_VALUE : larger[cutB];
            
            if(l1 <= r2 && l2 <= r1){
                if(total % 2 == 1) return Math.max(l1, l2) * 1.0;
                return (Math.max(l1,l2) + Math.min(r1, r2)) / 2.0;
            }
            else if(l1 > r2) hi = cutA - 1;
            else lo = cutA + 1;
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 4, 7, 8, 12 };
        int[] nums2 = { 2, 6, 7 };
        MedianOfTwoSortArr_LC4 lc4 = new MedianOfTwoSortArr_LC4();
        double ans = lc4.findMedianSortedArrays(nums1, nums2);
        System.out.println("Ans = " + ans);
    }
}
