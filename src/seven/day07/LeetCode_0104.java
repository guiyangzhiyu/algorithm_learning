package seven.day07;

import model.TreeNode;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_0104 {

    public static void main(String[] args) {
        Integer[] arr = {3,9,20,null,null,15,7};
        System.out.println(maxDepth(TreeNode.generateTreeNode(arr)));
    }
    /**
     * 二叉树的最大深度，即为 max(左子树的深度，右子树的深度)+1.可以以此来进行递归
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        return helper(root);
    }

    /**
     * 时间复杂度：O(n) n表示节点的个数
     * 空间复杂度：O(n)再最坏的情况下，递归的调用栈可能会达到节点的个数n个
     * @param root
     * @return
     */
    public static int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(helper(root.left),helper(root.right)) + 1;
    }
}
