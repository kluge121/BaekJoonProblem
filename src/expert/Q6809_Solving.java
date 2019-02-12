package expert;

import java.util.Scanner;

public class Q6809_Solving {

    static int map[];
    static String out[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        out = new String[T];

        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            int sum = 0;
            map = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                map[i] = sc.nextInt();
                sum += map[i];
            }
            if (sum == 0) {
                out[t - 1] = String.format("#%d %d", t, sum);
            }else if(sum == map[n]){
                out[t - 1] = String.format("#%d %d", t, map[n]);
            }



            if (map[n - 1] > 0) {

            } else if (map[n - 1] == 0) {

            }
        }

        //가장 마지막 축전기에 모아라
        //가장 마지막 축전기 전전이 제일커야함

    }

    void search(int eat, int value){

    }
}
