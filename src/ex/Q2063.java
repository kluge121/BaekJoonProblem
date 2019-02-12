package ex;

import java.util.ArrayList;
import java.util.Scanner;

public class Q2063 {

    private static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            arrayList.add(sc.nextInt());
        }
        arrayList.sort(Integer::compareTo);
        int mid = (N - 1) / 2;
        System.out.println(arrayList.get(mid));

    }
}
