package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q1005 {
    static ArrayList<Integer>[] list;
    static boolean visit[];
    static int[] time;
    static int[] cache;
    static int goalNum;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String[] a = br.readLine().split(" ");
            int N = Integer.parseInt(a[0]);
            int K = Integer.parseInt(a[1]);
            list = (ArrayList<Integer>[]) new ArrayList[N + 1];
            time = new int[N + 1];
            visit = new boolean[N + 1];
            cache = new int[N + 1];

            String [] ta = br.readLine().split(" ");
            for (int i = 1; i <= N; i++) {
                time[i] = Integer.parseInt(ta[i-1]);
            }
            for (int i = 0; i < K; i++) {
                String[] b = br.readLine().split(" ");
                int p = Integer.parseInt(b[0]);
                int n = Integer.parseInt(b[1]);
                if (list[n] == null) {
                    list[n] = new ArrayList<>();
                }
                list[n].add(p);
            }
            goalNum = Integer.parseInt(br.readLine());
            sb.append(dfs(goalNum)).append("\n");
        }
        System.out.println(sb.toString());
    }

    static int dfs(int index) {
        //시작점 노드 도착
        if (list[index] == null)
            return time[index];
        if (visit[index])
            return cache[index];
        visit[index] = true;

        int maxTime = 0;
        for (int pre : list[index]) {
            maxTime = Math.max(maxTime, dfs(pre) + time[index]);
        }
        return cache[index] = maxTime;
    }
}
