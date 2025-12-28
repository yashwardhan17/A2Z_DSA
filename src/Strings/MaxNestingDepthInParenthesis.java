package Strings;

public class MaxNestingDepthInParenthesis {
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println(maxDepth1(s));
    }

    static int maxDepth(String s) {
        int maxCnt = 0;
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                count++;
                maxCnt = Math.max(maxCnt, count);
            } else if(s.charAt(i) == ')'){
                count--;
            }
        }
        return maxCnt;
    }

    //Research on this
    static int maxDepth1(String s) {
        int maxCnt = 0;
        int count = 0;
        int[] suii = new int[256];
        for(int i : s.toCharArray()){
            if(suii[i] == '('){
                count++;
                maxCnt = Math.max(maxCnt, count);
            } else if(suii[i] == ')'){
                count--;
            }
        }
        return maxCnt;
    }
}
