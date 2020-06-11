import model.ListNode;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @version 2020/6/11
 * @auther weixiang
 */
public class LeetCode_0206 {
    public static void main(String[] args) {
        ListNode head = ListNode.generateLinkedList(new int[]{1,2,3,4,5,6,7});
        ListNode.printLinkedList(reverseList(head));
    }
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null,next = head;
        while(next != null) {
            //保存下一个节点
            ListNode tempNode = next.next;
            //next节点连接pre，并且更新pre指针
            next.next = pre;
            pre = next;
            //更新下一个节点
            next = tempNode;
        }
        return pre;
    }
}
