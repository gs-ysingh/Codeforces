package Div384;

import java.util.*;

public class ProblemB {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();

        int n = Integer.parseInt(line1.split(" ")[0]);
        int k = Integer.parseInt(line1.split(" ")[1]);

        int out = find(n, k - 1);

        System.out.println(out);
    }

    private static int find(int n, int k) {
        int total = ((int)Math.pow(2, n) - 1);
        int index = total / 2;

        if(k == 0 || k == 2) {
            return 1;
        }
        if(k == 1) {
            return 2;
        }

        if(k == index) {
            return n;
        }
        else if(k < index) {
            return find(n - 1, k);
        }
        else {
            return find(n - 1, k - index - 1);
        }
    }
}
