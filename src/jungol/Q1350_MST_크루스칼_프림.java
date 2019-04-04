package jungol;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q1350_MST_크루스칼_프림 {

    static int[][] cost;
    static Queue<Edge> queue;
    static int V;
    static int E;
    static int sum;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] a = br.readLine().split(" ");
        V = Integer.parseInt(a[0]);
        E = Integer.parseInt(a[1]);
        queue = new PriorityQueue<>();
        cost = new int[V + 1][V + 1];
        visit = new boolean[V + 1];
        sum = 0;


        for (int i = 0; i < E; i++) {
            String[] b = br.readLine().split(" ");
            int v1 = Integer.parseInt(b[0]);
            int v2 = Integer.parseInt(b[1]);
            int c = Integer.parseInt(b[2]);
            if (cost[v1][v2] <= c) {
                cost[v1][v2] = c;
                cost[v2][v1] = c;
            }
        }

        dijkstra(1);
        System.out.println(sum);

    }

    static void dijkstra(int v) {

        visit[v] = true;
        for (int i = 1; i <= V; i++) {
            if (v != i) {
                queue.add(new Edge(v, i, cost[v][i]));
            }
        }

        while (true) {
            if (queue.isEmpty()) break;
            Edge edge = queue.poll();
            if (!visit[edge.v1]) {
                sum += edge.cost;
                visit[edge.v1] = true;
                dijkstra(edge.v1);
                break;
            } else if (!visit[edge.v2]) {
                sum += edge.cost;
                visit[edge.v2] = true;
                dijkstra(edge.v2);
                break;
            }
        }
    }


    static class Edge implements Comparable<Edge> {
        int v1, v2, cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            if (cost < o.cost) return 1;
            return -1;
        }
    }

}



/* 크루스칼 코드
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

//문제는 최소가 아닌 최대 신장 찾기 ㅎ;
public class Q1350_MST_크루스칼_프림 {

    static ArrayList<Adj> queue;
    static int[] root;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");
        int N = Integer.parseInt(a[0]);
        int M = Integer.parseInt(a[1]);
        root = new int[N + 1];
        sum = 0;
        queue = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            root[i] = i;
        }

        for (int i = 0; i < M; i++) {
            String[] c = br.readLine().split(" ");
            int s = Integer.parseInt(c[0]);
            int e = Integer.parseInt(c[1]);
            int cost = Integer.parseInt(c[2]);
            queue.add(new Adj(s, e, cost));

        }
        Collections.sort(queue);

        for (Adj adj : queue) {
            int s = adj.s;
            int e = adj.e;
            if (find(s) != find(e)) {
                sum += adj.c;
                union(adj.s, adj.e);
            }

        }
        System.out.println(sum);

    }

    static int find(int n) {
        if (root[n] == n) return n;
        root[n] = find(root[n]);
        return root[n];
    }

    static void union(int n1, int n2) {
        int r_n1 = find(n1);
        int r_n2 = find(n2);
        if (r_n1 != r_n2)
            root[r_n2] = r_n1;

    }


    static class Adj implements Comparable<Adj> {
        int s, e, c;

        public Adj(int s, int e, int c) {
            this.s = s;
            this.e = e;
            this.c = c;
        }

        @Override
        public int compareTo(Adj o) {
            if (c < o.c) return 1;
            else return -1;

        }
    }
}

 */

