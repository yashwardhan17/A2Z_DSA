package Math;

public class HappyNumber {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(isHappy(n));
    }
    //cycle detection (fast and slow pointer)
    static boolean isHappy(int n){
        int slow = n;
        int fast = n;

        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));

        } while (slow != fast);

        if (slow == 1) return true;

        return false;
    }

    //this approach uses the (Every unhappy number eventually falls into a cycle that includes 4)
    static boolean isHappyUsingMaths(int n){
        while (n != 1 && n != 4) {
            n = findSquare(n);
        }
        return n == 1;
    }

    //using While loop (Just for study purpose)
    static boolean isHappyUsingWhile(int n){
        int slow = findSquare(n);
        int fast = findSquare(findSquare(n));

        while (slow != fast) {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        }

        return slow == 1;
    }

    static int findSquare(int number){
        int ans = 0;
        while  (number > 0){
            int rem = number % 10;
            ans += rem * rem;
            number /= 10;
        }
        return ans;
    }
}
