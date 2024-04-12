package lc.linkedlist.e;

public class PalindromeLinkedList {
    // O(n) O(1)
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode sec_half = reverseList(slow);
        while (head != null && sec_half != null) {
            if (head.val != sec_half.val) {
                return false;
            }
            head = head.next;
            sec_half = sec_half.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode cur=head;
        ListNode next=null;
        while(cur!=null){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        PalindromeLinkedList solution = new PalindromeLinkedList();
        System.out.println(solution.isPalindrome(head));
    }
}
