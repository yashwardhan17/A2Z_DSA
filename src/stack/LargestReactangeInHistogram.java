package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestReactangeInHistogram {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }

    static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> st = new ArrayDeque<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int currHeight;

            if (i == n) {
                currHeight = 0;
            } else {
                currHeight = heights[i];
            }

            while (!st.isEmpty() && heights[st.peekLast()] > currHeight) {
                int h = heights[st.removeLast()];
                int right = i;
                int left;
                if (st.isEmpty()) {
                    left = -1;
                } else {
                    left = st.peekLast();
                }
                int width = right - left - 1;
                maxArea = Math.max(maxArea, h * width);
            }
            st.addLast(i);
        }
        return maxArea;
    }
}
