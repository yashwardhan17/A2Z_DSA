package Math;

public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        int n = 30;
        System.out.println(trailingZeroes(n));
    }

    // T.C = O(log₅ n) and S.C = O(1)
    // n/5  +  n/25  +  n/125  + ...
    static int trailingZeroes(int n) {
        int cnt = 0;

        while (n != 0) {
            n = n / 5;
            cnt += n;
        }
        return cnt;
    }
}
