package solve;

import java.util.ArrayList;
import java.util.Scanner;

public class Q1021 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        for (int i = 0; i < m; i++) {
            int goal = sc.nextInt();
            int index = list.indexOf(goal);

            if (list.size() - index >= index) {
                for (int j = 0; j < index; j++) {
                    count++;
                    int tmp = list.get(0);
                    list.remove(0);
                    list.add(tmp);
                }
            } else {
                for (int j = 0; j < list.size() - index; j++) {
                    count++;
                    int tmp = list.get(list.size() - 1);
                    list.add(0, tmp);
                    list.remove(list.size() - 1);
                }
            }
            list.remove(0);
        }
        System.out.println(count);
    }


}