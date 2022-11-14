package one;

/**
 * @author huanghaoxing
 */
public class buildTree105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int ps, int pe, int is, int ie) {
        if (ps > pe) {
            return null;
        }

        int rootVal = preorder[ps];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = 0;
        for (int i = is; i <= ie; i++) {
            if (rootVal == inorder[i]) {
                rootIndex = i;
                break;
            }
        }

        TreeNode left = buildTree(preorder, inorder, ps + 1, rootIndex - is + ps, is, rootIndex - 1);
        TreeNode right = buildTree(preorder, inorder, rootIndex - is + ps + 1, pe, rootIndex + 1, ie);
        root.left = left;
        root.right = right;
        return root;
    }
}
