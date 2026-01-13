package LinkedList;

public class PalindromeLinkedList {

    public static void main(String[] args) {

        // head = [1,2,2,1]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(isPalindrome1(head));
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

    /*
     * Time Complexity: O(n)
     * Space Complexity: O(n)   // due to recursive reverse
     * Space Complexity: O(1)   // if we use iterative reverse fn
     */
    static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }

        ListNode fH = head;
        ListNode sH = reverseList(slow);

        while (sH != null) {
            if (fH.val != sH.val) {
                return false;
            }
            fH = fH.next;
            sH = sH.next;
        }
        return true;
    }

    static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    static ListNode reverseListIterative(ListNode head) {
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

    static boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode mid = middleNode(head);
        ListNode secondHead = reverseList(mid);
        ListNode reversedHead = secondHead;

        while (head != null && secondHead != null) {
            if (head.val != secondHead.val) {
                break;
            }
            head = head.next;
            secondHead = secondHead.next;
        }
        reverseList(reversedHead);

        return head == null || secondHead == null;
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
}
