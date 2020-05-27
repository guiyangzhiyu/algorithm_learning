package seven.day05;

import seven.module.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 * 返回其前序遍历: [1,3,5,6,2,4]。
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_0589 {

    static  List<Integer> list = new LinkedList<>();
    public static void main(String[] args) {

//        System.out.println(preorder_1(root));
//        System.out.println(preorder(root));
    }

    /**
     * 迭代的方式
     *
     * 时间复杂度O(n) n表示节点的个数
     * 空间复杂度O(n) n表示节点的个数 使用一个栈存储节点，最坏的情况下，栈中可能会有n-1个元素
     * @param root
     * @return
     */
    public static List<Integer> preorder_1(Node root) {
        if (root == null) return list;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()) {
            Node temp = stack.pop();
            list.add(temp.val);
            //倒叙插入到栈中
            for (int i = temp.children.size() - 1; i >= 0; i--) {
                if (temp.children.get(i) != null) {
                    stack.push(temp.children.get(i));
                }
            }
        }
        return list;
    }


    /**递归的方式
     * @param root
     * @return
     */
    public static List<Integer> preorder(Node root) {
        helper1(root);
        return list;
    }

    /**
     * 递归的方式
     * 时间复杂度 O(k*n)
     * 空间复杂度 O(1)
     * @param root
     */
    public static void helper1(Node root) {
        if (root != null){
            list.add(root.val);
            for (int i = 0; i < root.children.size(); i++) {
                helper1(root.children.get(i));
            }
        }
    }
}
