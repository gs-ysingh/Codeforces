package Div383;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by YSingh on 24/12/16.
 */
public class ProblemC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String line2 = sc.nextLine();
        String[] numbers = line2.split(" ");
        int[] arr = new int[n + 1];

        for (int i = 0; i < numbers.length; i++) {
            arr[i + 1] = Integer.parseInt(numbers[i]);
        }

        int condition = getIndegree(arr, n + 1);
        long out = -1;
        if(condition == 1) {
            int len = 0;
            long [] lengths = new long[n];
            boolean [] visited = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                Arrays.fill(visited, false);
                len = getCycleLen(i, arr, visited);

                if(len % 2 == 0) {
                    lengths[i - 1] = len / 2;
                }
                else {
                    lengths[i - 1] = len;
                }
            }

            out = getLCM(lengths);
        }

        System.out.println(out);
    }

    private static int getCycleLen(int i, int[] arr, boolean [] visited) {
        if(visited[i]) {
            return 0;
        }
        visited[i] = true;
        return 1 + getCycleLen(arr[i], arr, visited);
    }

    private static long getLCM(long[] numbers) {
        long res = 1;
        for (int i = 0; i < numbers.length; i++) {
            res = (res * numbers[i]) / gcd(res, numbers[i]);
        }

        return res;
    }

    private static long gcd(long a, long b) {
        if(a % b == 0) {
            return b;
        }

        return gcd(b, a % b);
    }

    private static int getIndegree(int[] arr, int n) {
        boolean [] visited = new boolean[n];
        Arrays.fill(visited, false);

        for (int i = 1; i < n; i++) {
            visited[arr[i]] = true;
        }

        int out = 1;

        for (int i = 1; i < n; i++) {
            if(!visited[i]) {
                out = 0;
                break;
            }
        }
        return out;
    }

}
