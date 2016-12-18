package Div383;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input =  in.nextInt();
        int output = 0;

        switch (input % 4) {
            case 0:
                output = 6;
                break;
            case 1:
                output = 8;
                break;
            case 2:
                output = 4;
                break;
            case 3:
                output = 2;
                break;
        }

        if(input == 0) {
            output = 1;
        }
        System.out.println(output);

    }
}