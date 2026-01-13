package LinkedList;

public class ReorderList {

    public static void main(String[] args) {

        // head = [1,2,3,4,5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReorderList obj = new ReorderList();
        obj.reorderList(head);

        display(head);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static void display(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("END");
    }

    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode mid = middleNode(head);

        /*
           (Avoid self loops (temporary cycles))
           ListNode second = mid.next;
           mid.next = null;
           ListNode sH = reverseList(second);
        */

        ListNode sH = reverseList(mid);
        ListNode fH = head;

        while (fH != null && sH != null) {
            ListNode temp = fH.next;
            fH.next = sH;
            fH = temp;

            temp = sH.next;
            sH.next = fH;
            sH = temp;
        }

        // this check is not necessary if we split the list correctly
        // this is needed when we don't split, to handle the self loops

        if (fH != null) {
            fH.next = null;
        }
    }

    static ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}
