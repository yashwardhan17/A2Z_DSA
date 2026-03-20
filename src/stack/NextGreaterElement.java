package stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElements(nums1, nums2)));
    }

    static int[] nextGreaterElements(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> nextGreater = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for (int i : nums2) {
                while (!st.isEmpty() && i > st.peek()) {
                nextGreater.put(st.pop(), i);
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            nextGreater.put(st.pop(), -1);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = nextGreater.get(nums1[i]);
        }
        return res;
    }
}
