package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Q1325 {

    static boolean visit[];
    static ArrayList<Integer>[] adjList;
    static int save[];

    static int N;
    static int M;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] a = br.readLine().split(" ");
        N = Integer.parseInt(a[0]);
        M = Integer.parseInt(a[1]);
        adjList = (ArrayList<Integer>[]) new ArrayList[N + 1];


        for (int i = 1; i <= M; i++) {
            String[] b = br.readLine().split(" ");
            int n1 = Integer.parseInt(b[0]);
            int n2 = Integer.parseInt(b[1]);

            if (adjList[n1] == null) {
                adjList[n1] = new ArrayList<>();
            }
            adjList[n1].add(n2);


        }
        save = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            visit = new boolean[N + 1];
            dfs(i);
        }

        int max = 0;
        for (int i = 1; i < save.length; i++) {
            max = Math.max(max, save[i]);

        }

        for (int i = 1; i < save.length; i++) {
            if (max == save[i])
                System.out.print(i + " ");
        }
    }

    static void dfs(int index) {
        visit[index]= true;
        if (adjList[index] != null) {
            for (int i : adjList[index]) {
                if (!visit[i]) {
                    visit[i] = true;
                    save[i]++;
                    dfs(i);
                }
            }


        }

    }


}



















