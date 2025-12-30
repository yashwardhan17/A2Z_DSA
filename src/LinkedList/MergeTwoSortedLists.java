package LinkedList;

public class MergeTwoSortedLists {

    public static void main(String[] args) {

        // First sorted list: 1 -> 3 -> 5
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        // Second sorted list: 1 -> 2 -> 9 -> 14
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(14);

        ListNode ans = merge(l1, l2);
        display(ans);
    }

    // Definition of ListNode
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

    // Display function
    static void display(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("END");
    }
}
