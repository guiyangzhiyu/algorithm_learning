import model.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
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
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_0145 {
    static List<Integer> list = new LinkedList<>();
    public static void main(String[] args) {
        Integer[] arr = {1,null,2,3};
        iteratorPostTraverasl(TreeNode.generateTreeNode(arr));
        System.out.println(list);
    }
    /**
     * 不使用逆序输出
     */
    public static void iteratorPostTraverasl(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.empty() || cur != null) {
            while (!isLeaf(cur)) {
                stack.push(cur);
                cur = cur.left;
            }
            //表示cur是非空的叶子节点
            if (cur != null) {
                list.add(cur.val);
            }

            //TODO 没完全懂
            // cur==null,并且stack栈顶的右节点也为null
            while (!stack.empty() && cur == stack.peek().right) {
                cur = stack.pop();
                list.add(cur.val);
            }
            if (stack.empty()) {
                cur = null;
            }
            else {
                cur = stack.peek().right;
            }
        }

    }

    /**
     * 是否是叶子节点
     * @param node 节点
     */
    public static boolean isLeaf(TreeNode node) {
        if (node == null) {
            return true;
        }
        return node.left == null && node.right == null;
    }


    /**
     * 使用迭代的方式+逆序
     * @param root
     */
    public static void postOrderTraversalStack(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode temp = stack.pop();
            //以根-右-左的顺序插入链表的第一个元素。输出的时候顺序就是左-右-跟
            list.add(0,temp.val);

            if (temp.left != null) {
                stack.push(temp.left);
            }
            if (temp.right != null){
                stack.push(temp.right);
            }
        }

    }
    /**
     * 使用递归
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param root
     * @return
     */
    public static void postorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
    }
}
