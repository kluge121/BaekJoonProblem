package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q1238 {

    static int N;
    static int startNum;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static boolean[] check;
    static Queue<Point> queue;
    static int max;
    static int prevLevel;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] out = new String[10];

        for (int t = 0; t <= 9; t++) {
            String[] a = br.readLine().split(" ");
            N = Integer.parseInt(a[0]);
            startNum = Integer.parseInt(a[1]);
            adj = new ArrayList[N + 1];
            visit = new boolean[N + 1];
            max = 0;
            prevLevel = 0;
            queue = new LinkedList<>();
            queue.add(new Point(startNum, 1));
            visit[startNum] = true;
            String[] b = br.readLine().split(" ");
            for (int i = 1; i <= N / 2; i++) {
                int from = Integer.parseInt(b[i * 2 - 2]);
                int to = Integer.parseInt(b[i * 2 - 1]);
                if (adj[from] == null) {
                    adj[from] = new ArrayList<>();
                }
                adj[from].add(to);
            }
            while (!queue.isEmpty()) {
                Point p = queue.poll();
                if (prevLevel != p.level) {
                    prevLevel = p.level;
                    max = p.num;
                }else{
                    max = Math.max(p.num,max);
                }
                if (adj[p.num] != null) {
                    for (int go : adj[p.num]) {
                        if (!visit[go]) {
                            visit[go] = true;
                            queue.add(new Point(go, p.level + 1));
                        }
                    }
                }
            }
            out[t] = String.format("#%d %d", t + 1, max);
        }
        for (String a : out) {
            System.out.println(a);
        }
    }
    static class Point {
        int num, level;

        public Point(int num, int level) {
            this.num = num;
            this.level = level;
        }
    }
}
