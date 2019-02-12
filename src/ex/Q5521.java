package ex;

import java.util.ArrayList;
import java.util.Scanner;

public class Q5521 {

    static int n;
    static int m;
    static int map[][];
    static ArrayList<Integer> rootFriend;
    static int invited[];
    static String[] out;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        out = new String[T];
        for (int t = 1; t <= T; t++) {
            n = sc.nextInt();
            m = sc.nextInt();
            map = new int[n + 1][n + 1];
            rootFriend = new ArrayList<>();
            invited = new int[n + 1];
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                map[a][b] = 1;
                map[b][a] = 1;
            }

            for (int i = 2; i <= n; i++) {
                if (map[1][i] == 1) {
                    rootFriend.add(i);
                }
            }
            for (int friend : rootFriend) {
                search(friend);
            }

            int count = 0;
            for (int i = 2; i <= n; i++) {
                if (invited[i] == 1)
                    count++;
            }
            out[t - 1] = String.format("#%d %d", t, count);
        }
        for (String a : out) {
            System.out.println(a);
        }
    }
    static void search(int friend) {
        invited[friend] = 1;
        for (int i = 2; i <= n; i++) {
            if (map[friend][i] == 1)
                invited[i] = 1;
        }
    }


}
