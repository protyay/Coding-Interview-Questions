import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BuildBSTFromSortedArray_IB {
    public TreeNode sortedArrayToBST(final int[] A) {
        if (A.length == 1)
            return new TreeNode(A[0]);
        List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
        TreeNode root = buildBST(list);
        return root;
    }

    private TreeNode buildBST(List<Integer> A) {
        int N = A.size();
        if (N == 1)
            return new TreeNode(A.get(0));
        if (N == 0)
            return null;

        int mid = N / 2;

        TreeNode root = new TreeNode(A.get(mid));
        root.left = buildBST(A.subList(0, mid));
        root.right = buildBST(A.subList(mid + 1, A.size()));

        return root;
    }

    public static void main(String[] args) {
        BuildBSTFromSortedArray_IB bArray_IB = new BuildBSTFromSortedArray_IB();
        int[] input = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        TreeNode res = bArray_IB.sortedArrayToBST(input);
        System.out.println("Resultant tree " + res);
    }
}
/**
 * This is a simple yet very important concept.
 * Please make sure, that the index to copy for the right subtree would
 * start from mid + 1.
 * 
 */
class ConvertSortedArrtoBST_LC108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;

        int mid = nums.length / 2;
        int rootVal = nums[mid];
        TreeNode currNode = new TreeNode(rootVal);

        currNode.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        currNode.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));
        return currNode;
    }
}
