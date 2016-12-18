package Div384;

import java.util.*;

public class ProblemA {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int out = 0;
        String line1 = in.nextLine();
        String str = in.nextLine();

        int n = Integer.parseInt(line1.split(" ")[0]);
        int a = Integer.parseInt(line1.split(" ")[1]);
        int b = Integer.parseInt(line1.split(" ")[2]);

        if(str.charAt(a - 1) == str.charAt(b - 1)) {
            out = 0;
        }
        else {
            out = findNearest(str, a - 1, b - 1);
        }

        System.out.println(out);
    }

    private static int findNearest(String str, int a, int b) {
        Character c =  (str.charAt(a) == '0' ? '1' : '0');
        int left = a - 1;
        int right = a + 1;
        int result = 0;
        while(true && a < b) {
            if(left >= 0) {
                if(str.charAt(left) == c) {
                    result = left;
                    break;
                }
                else {
                    left--;
                }
            }

            if(right <= b) {
                if(str.charAt(right) == c) {
                    result = right;
                    break;
                }
                else {
                    right++;
                }
            }
        }

        while(true && a > b) {
            if(left >= b) {
                if(str.charAt(left) == c) {
                    result = left;
                    break;
                }
                else {
                    left--;
                }
            }

            if(right < str.length()) {
                if(str.charAt(right) == c) {
                    result = right;
                    break;
                }
                else {
                    right++;
                }
            }
        }

        return Math.abs(result - a);
    }
}