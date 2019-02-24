package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10451 {

    static int[] adj;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int count = 0;
            int length = Integer.parseInt(br.readLine());

            adj = new int[length + 1];
            visit = new boolean[length + 1];

            String[] adjList = br.readLine().split(" ");
            for (int i = 1; i <= length; i++) {
                adj[i] = Integer.parseInt(adjList[i-1]);
            }

            for (int i = 1; i <= length; i++) {
                if (!visit[i]) {
                    dfs(i);
                    count++;
                }
            }
            System.out.println(count);


        }


    }

    static void dfs(int index) {
        if (visit[index]) return;
        visit[index] = true;
        dfs(adj[index]);
    }


}
