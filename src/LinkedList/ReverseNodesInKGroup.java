package LinkedList;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {

        // head = [1,2,3,4,5], k = 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = reverseKGroup(head, 2);
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

    // groupPrev = node before (segment / each group)
    // kth defines (segment end / each group's end)
    // Reverse between [groupPrev.next, kth]
    static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode grpPrev = dummy;

        while (true) {
            ListNode kth = getKthNode(grpPrev, k);
            if (kth == null) break;  // Stop when nodes < k

            ListNode grpNext = kth.next;

            ListNode prev = grpNext;
            ListNode curr = grpPrev.next;

            while (curr != grpNext) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            ListNode temp = grpPrev.next;
            grpPrev.next = kth;
            grpPrev = temp;
        }
        return dummy.next;
    }

    static ListNode getKthNode(ListNode start, int k) {
        while (start != null && k > 0) {
            start = start.next;
            k--;
        }
        return start;
    }
}
