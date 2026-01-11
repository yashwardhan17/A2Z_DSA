package LinkedList;

public class OddEvenLinkedList {

    public static void main(String[] args) {

        // head = [1,2,3,4,5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = oddEvenList(head);
        display(head);
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

    static void display(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("END");
    }

    // Time Complexity: O(n) & Space Complexity: O(1)
    static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode oddN = head;
        ListNode evenN = head.next;
        ListNode evenH = head.next;

        while (evenN != null && evenN.next != null) {
            oddN.next = evenN.next;
            oddN = oddN.next;
            evenN.next = oddN.next;
            evenN = evenN.next;
        }

        oddN.next = evenH;
        return head;
    }
}
