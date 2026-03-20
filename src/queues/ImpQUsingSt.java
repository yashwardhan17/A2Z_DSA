package queues;

import java.util.Stack;

// Costly deQueue and O(1)  enQueue
public class ImpQUsingSt {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public ImpQUsingSt() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void enQueue(int x) {
        s1.push(x);
    }

    public int deQueue() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        if (s2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return s2.pop();
    }

    public int peek() {
        // Shift input to output if output is empty
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        if (s2.isEmpty()) {
            System.out.println("Queue is empty, cannot peek.");
            return -1;
        }
        return s2.peek();
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

class Main {
    public static void main(String[] args) {
        ImpQUsingSt q = new ImpQUsingSt();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        System.out.println(q.deQueue()); // Output: 1
        System.out.println(q.deQueue()); // Output: 2
        q.enQueue(4);
        System.out.println(q.deQueue()); // Output: 3
        System.out.println(q.deQueue()); // Output: 4
    }
}

