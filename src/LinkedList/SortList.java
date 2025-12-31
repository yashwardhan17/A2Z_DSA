package LinkedList;

public class SortList {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        ListNode ans = sortList(head);
        display(ans);

    }

    static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = middleNode(head);
        ListNode right = mid.next;
        mid.next = null;
        ListNode left = sortList(head);
        right = sortList(right);

        return merge(left, right);
    }



    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Merge function
    static ListNode merge(ListNode f, ListNode s) {

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (f != null && s != null) {
            if (f.val < s.val) {
                tail.next = f;
                f = f.next;
            } else {
                tail.next = s;
                s = s.next;
            }
            tail = tail.next;
        }

        if (f != null) tail.next = f;
        if (s != null) tail.next = s;

        return dummy.next;
    }

    static ListNode middleNode(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // Display function
    static void display(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("END");
    }
}
