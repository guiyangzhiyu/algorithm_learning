import model.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_0094 {
    static List<Integer> list = new LinkedList<>();
    public static void main(String[] args){
        Integer[] arr = {1,null,2,3};
        System.out.println(inorderTraversal(TreeNode.generateTreeNode(arr)));
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * 迭代的方式。使用一个栈来记录节点
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            //中序遍历，再此处赋值
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    /**
     * 采用递归遍历的方式
     * 时间复杂度O(n) n表示数的节点数
     * 空间复杂度O(1)
     * @param root
     */
    public static void minOrder(TreeNode root) {
        if (root == null)
            return;
        minOrder(root.left);
        list.add(root.val);
        minOrder(root.right);
    }
}
