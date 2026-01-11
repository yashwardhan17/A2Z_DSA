package Math;

public class NumberOfDigit1 {
    public static void main(String[] args) {
        int n = 130;
        System.out.println(countDigit(n));
    }

    //we will count digit 1 on every place (i.e ones, tens, ...) rather than counting 1 in all numbers
    //Patterns repeat every 10 × factor (factor 1 = ones place , factor 10 = tens place and so on)

    static int countDigit (int n) {
        int factor = 1;
        int cnt = 0;

        while (factor <= n) {
            int lower = n % factor;
            int curr = (n / factor) % 10;
            int higher = n / (factor * 10);

            if (curr < 1) {
                cnt += higher * factor;
            } else if (curr == 1) {
                cnt += higher * factor + (lower + 1);
            } else {
                cnt += (higher + 1) * factor;
            }
            factor *= 10;
        }
        return cnt;
    }
}
