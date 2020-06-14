//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表

package leetcode.editor.cn;


import model.ListNode;

public class P25ReverseNodesInKGroup {

    public static void main(String[] args) {
        Solution solution = new P25ReverseNodesInKGroup().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode result = new ListNode(0);
            result.next = head;
            // pre是待逆序的链表的前驱，end是待逆序链表的尾结点
            ListNode pre = result, end = result;
            while (end.next != null) {
                //获得end
                for (int i = 0; i < k && end != null; i++) {
                    end = end.next;
                }
                if (end == null) {
                    break;
                }
                ListNode start = pre.next;
                ListNode next = end.next;
                end.next = null;
                //逆序后的链表与前面逆序完成的连接
                pre.next = reverse(start);

                //重置pre 和 end
                start.next = next;
                pre = start;
                end = start;
            }
            return result.next;
        }

        /**
         * 逆序链表head
         *
         * @param head
         */
        private ListNode reverse(ListNode head) {
            ListNode pre = null;
            ListNode temp;
            while (head != null) {
                temp = head.next;
                head.next = pre;
                pre = head;
                head = temp;
            }
            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

