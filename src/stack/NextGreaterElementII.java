package stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        System.out.println(java.util.Arrays.toString(nextGreaterElements(arr)));

//        NextGreaterElementII nge = new NextGreaterElementII();
//        System.out.println(nge.nextGreaterElements(arr));
    }

    static int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> st = new java.util.Stack<>();

        for (int i = 0; i < 2 * n; i++) {
            int num = arr[i % n];
            while (!st.isEmpty() && num > arr[st.peek()]) {
                res[st.pop()] = num;
            }
            if (i < n) {
                st.push(i);
            }
        }
        return res;
    }
}
