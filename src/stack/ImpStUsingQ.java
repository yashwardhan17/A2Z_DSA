package stack;

import java.util.Queue;

// Costly push and O(1) pop
public class ImpStUsingQ {
    Queue<Integer> q;

    public ImpStUsingQ() {
        q = new java.util.LinkedList<>();
    }

    public void push(int x) {
        int s = q.size();
        q.add(x);
        for (int i = 0; i < s; i++) {
            q.add(q.poll());
        }
    }

    public int pop() {
        int n = q.peek();
        q.poll();
        return n;
    }

    public int top() {
        return q.peek();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }
}

class Main {
     public static void main(String[] args) {
        ImpStUsingQ st = new ImpStUsingQ();
        st.push(1);
        st.push(2);
        st.push(3);
        System.out.println(st.top());
        System.out.println(st.pop());
        System.out.println(st.top());
    }
}
