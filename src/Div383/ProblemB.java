package Div383;

import java.util.*;

public class ProblemB {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();
        String line2 = in.nextLine();

        int n = Integer.parseInt(line1.split(" ")[0]);
        int x = Integer.parseInt(line1.split(" ")[1]);

        String[] numbers = line2.split(" ");

        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i < numbers.length; i++) {
            arr.add(Integer.parseInt(numbers[i]));
        }

        int count = 0;
        int number = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.size(); i++) {
            if(map.get(arr.get(i)) == null) {
                map.put(arr.get(i), 1);
            }
            else {
                map.put(arr.get(i), map.get(arr.get(i)) + 1);
            }
        }

        for (int i = 0; i < arr.size(); i++) {
            number = arr.get(i) ^ x;
            count += map.get(number) == null ? 0 : map.get(number);
            if(number == arr.get(i)) {
                count--;
            }
        }
        System.out.println(count / 2);
    }
}
