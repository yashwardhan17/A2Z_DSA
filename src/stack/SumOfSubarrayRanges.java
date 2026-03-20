package stack;

import java.util.Stack;

public class SumOfSubarrayRanges {
    public static void main(String[] args) {
        int[] arr = {4, -2, -3, 4, 1};
        System.out.println(subArrayRanges2(arr));
    }

    static long subArrayRanges(int[] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            long largest = arr[i];
            long smallest = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                largest = Math.max(largest, arr[j]);
                smallest = Math.min(smallest, arr[j]);
                sum += largest - smallest;
            }
        }
        return sum;
    }

    static long subArrayRanges2(int[] arr) {
        return sumSubarrayMaxs(arr) - sumSubarrayMins(arr);
    }

    static int sumSubarrayMins(int[] arr) {
        int MOD = 1000000007;
        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();

        // Calculate left
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                left[i] = i + 1;
            } else {
                left[i] = i - st.peek();
            }

            st.push(i);
        }

        st.clear();

        // Calculate right
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                right[i] = n - i;
            } else {
                right[i] = st.peek() - i;
            }

            st.push(i);
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {
            ans = (ans + (long) arr[i] * left[i] * right[i]) % MOD;
        }

        return (int) ans;
    }
    
    static int sumSubarrayMaxs(int[] arr) {
        int MOD = 1000000007;
        int n = arr.length;
        
        int[] left = new int[n];
        int[] right = new int[n];   
        
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            
            if (st.isEmpty()) {
                left[i] = i + 1;
            } else {
                left[i] = i - st.peek();
            }
            st.push(i);
        }
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                right[i] = n - i;
            } else {
                right[i] = st.peek() - i;
            }
            st.push(i);
        }
        
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + (long) arr[i] * left[i] * right[i]) % MOD;
        }
        return (int) ans;
    }
}
