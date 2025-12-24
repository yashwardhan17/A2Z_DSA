package Strings;

public class RotateString {
    public static void main(String[] args) {
        String s = "abcde";
        String goal = "abced";
        System.out.println(isRotatedString(s, goal));
    }
    static boolean isRotated(String s, String goal){
        if(s.length() != goal.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            String rotated = s.substring(i) + s.substring(0, i);
            if(rotated.equals(goal)){
                return true;
            }
        }
        return false;
    }

    static boolean isRotatedString(String s, String goal){
        if(s.length() != goal.length()) return false;
        s = s + s;
        return s.contains(goal);
    }
}
