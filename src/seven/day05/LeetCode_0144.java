package seven.day05;

import seven.module.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 前序遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_0144 {
    static List<Integer> list = new LinkedList<>();

    /**
     * 使用迭代的方式。使用一个栈的结构
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);
        while(!stack.empty()){
            TreeNode tempNode = stack.pop();
            list.add(tempNode.val);
            if (tempNode.right != null)
                stack.push(tempNode.right);
            if (tempNode.left != null)
                stack.push(tempNode.left);
        }
        return list;
    }



    public static List<Integer> preorderTraversal(TreeNode root) {
        helper(root);
        return list;
    }

    /**
     * 使用递归的方式
     * 时间复杂度O(n)
     * 因为是递归的结构，方法执行的时候，会有入栈和出栈的操作，使用栈帧进行记录，空间复杂度也是O(n)
     * @param root
     */
    public static void helper(TreeNode root){
        if (root == null) return;
        list.add(root.val);
        helper(root.left);
        helper(root.right);
    }
}
