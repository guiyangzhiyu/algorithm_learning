import javafx.util.Pair;
import model.TreeNode;

import java.util.LinkedList;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_0111 {
    public static void main(String[] args) {
        Integer[] nums = {3,9,20,null,null,15,7};
        TreeNode root = TreeNode.generateTreeNode(nums);
        System.out.print(minDepth(root));
    }

    /**
     * 可以通过广度优先搜索来记录，
     * 得到的第一个左右子树都为空的节点所在的层级就是最小深度
     * 时间复杂度和空间复杂度都是O(n)
     * @param root 根节点
     * @return 最小深度
     */
    public static int minDepth(TreeNode root) {
        // 节点以及其对应的深度
        LinkedList<Pair<TreeNode,Integer>> list = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        list.add(new Pair<>(root,1));
        TreeNode tempNode;
        Integer tempDepth = 0;
        while (!list.isEmpty()) {
            Pair<TreeNode,Integer> pair = list.poll();
            tempNode = pair.getKey();
            tempDepth = pair.getValue();
            if (tempNode.left == null && tempNode.right == null) {
                return tempDepth;
            }
            if (tempNode.left != null) {
                list.add(new Pair<>(tempNode.left, tempDepth + 1));
            }
            if (tempNode.right != null) {
                list.add(new Pair<>(tempNode.right, tempDepth + 1));
            }
        }
        return tempDepth;
    }
}
