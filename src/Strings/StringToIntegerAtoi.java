package Strings;

public class StringToIntegerAtoi {
    public static void main(String[] args) {
        String s = " -042";
        System.out.println(atoi(s));
    }
    static int atoi(String s){
        int i = 0;
        int n = s.length();

        //skip whitespaces
        while(i < n && s.charAt(i) == ' '){
            i++;
        }

        //handle sign
        int sign = 1;
        if(i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')){
            if(s.charAt(i) == '-')  sign = -1;
            i++;
        }

        //convert digits
        int num = 0;
        while (i < n && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';

            //handling overflow
            if((num > Integer.MAX_VALUE / 10) || (num == Integer.MAX_VALUE / 10 && digit > 7)){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + digit;
            i++;
        }
        //apply sign
        return num*sign;
    }
}
