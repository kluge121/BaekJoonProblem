package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q14501 {


    static Point[] map;
    static int[] cache;
    static int N;
    static int max;

    public static void main(String[] args) throws IOException {

        max = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new Point[N + 1];
        cache = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            String[] a = br.readLine().split(" ");
            int day = Integer.parseInt(a[0]);
            int pay = Integer.parseInt(a[1]);
            map[i] = new Point(day, pay);
        }
        bfs(1, 0);

        System.out.println(max);
    }

    static void bfs(int day, int paySum) {

        if (day >= N + 1) {
            max = Math.max(max, paySum);
            return;
        }

        //일을 할 수도 안 할 수도 있음


        //이번 일을 한다.
        Point p = map[day];
        if (p.day + day <= N + 1) {
            bfs(day + p.day, paySum + p.pay);
        }

        //몇 일째의 최대값을 기준으로
        //=

        //이번일 안하고 패스
        bfs(day + 1, paySum);

    }

    static class Point {

        int day, pay;

        public Point(int day, int pay) {
            this.day = day;
            this.pay = pay;
        }
    }
}
