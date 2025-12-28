package Math;

public class ReverseInteger {
    public static void main(String[] args) {
        int x = 123;
        System.out.println(reverse(x));
    }
    static int reverse(int x){
        if(x == Integer.MIN_VALUE) return 0;

        int rev = 0;
        int sign = x < 0 ? -1 : 1;
        int num = Math.abs(x);

        while(num != 0){
            int digit = num % 10;

            if((rev > Integer.MAX_VALUE / 10) || (rev == Integer.MAX_VALUE / 10 && digit > 7)){
                return 0;
            }

            rev = rev * 10 + digit;
            num = num / 10;
        }
        return rev * sign;
    }
}
