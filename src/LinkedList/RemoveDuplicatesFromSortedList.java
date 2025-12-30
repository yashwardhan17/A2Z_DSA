package LinkedList;

public class RemoveDuplicatesFromSortedList {
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

    public static void main(String[] args) {

        // Creating sorted linked list: 1 -> 2 -> 2 -> 3 -> 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        head = deleteDuplicates(head);
        display(head);
    }

    // LeetCode logic
    static ListNode deleteDuplicates(ListNode node) {

        if (node == null) {
            return node;
        }

        ListNode head = node;

        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next; // skip duplicate
            } else {
                node = node.next;
            }
        }
        return head;
    }

    static void display(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("END");
    }
}
