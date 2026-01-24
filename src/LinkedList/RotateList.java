package LinkedList;

public class RotateList {

    public static void main(String[] args) {

        // head = [1,2,3,4,5], k = 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        RotateList obj = new RotateList();
        head = obj.rotateRight(head, 2);

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

    // Time: O(n), Space: O(1)
    public ListNode rotateRightWithoutDummy(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode oldTail = head;
        int length = 1;
        while (oldTail.next != null) {
            oldTail = oldTail.next;
            length++;
        }

        int rotations = k % length;  // k % length avoids unnecessary rotations.
        if (rotations == 0) return head;   // If rotations == 0, list remains unchanged.
        int skip = length - rotations - 1;  // New tail is at index (length - rotation - 1).

        ListNode newTail = head;

        for (int i = 0; i < skip; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;
        oldTail.next = head;  // Old tail is connected to old head to form rotation.

        return newHead;
    }

    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode oldTail = head;
        int length = 1;
        while (oldTail.next != null) {
            oldTail = oldTail.next;
            length++;
        }

        int rotations = k % length;       // Handle cases where k >= length.
        if (rotations == 0) return head;  // If k % length == 0, the list remains unchanged.

        int skip = length - rotations; // New head will be at position (length - k) (0 - Based indexing) . // The node before it becomes the new tail.
        ListNode newTail = dummy;

        for (int i = 0; i < skip; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;
        oldTail.next = dummy.next;
        dummy.next = newHead;

        return dummy.next;
    }
}
