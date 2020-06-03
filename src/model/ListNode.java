package model;

/**
 * 链表结构
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    /**
     * 通过输入数组，生成链表
     * @param arr
     * @return
     */
    public static ListNode generateLinkedList(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    /**
     * 打印链表结构
     * @param head
     */
    public static void printLinkedList(ListNode head){
        ListNode current =  head;
        while (current!=null){
            System.out.printf("%d -> ",current.val);
            current = current.next;
        }
        System.out.println("NULL");
    }
}
