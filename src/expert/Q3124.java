package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q3124 {

    static int[] parent;
    static PriorityQueue<Edge> queue;
    static String[] out;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        out = new String[T];

        for (int t = 0; t < T; t++) {
            long minValue = 0;
            queue = new PriorityQueue<>();
            String[] a = br.readLine().split(" ");
            int v = Integer.parseInt(a[0]);
            int e = Integer.parseInt(a[1]);
            parent = new int[v + 1];

            for (int i = 1; i <= v; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < e; i++) {
                String[] b = br.readLine().split(" ");
                int v1 = Integer.parseInt(b[0]);
                int v2 = Integer.parseInt(b[1]);
                int c = Integer.parseInt(b[2]);
                queue.offer(new Edge(v1, v2, c));
            }

            for (int i = 0; i < e; i++) {
                Edge edge = queue.poll();
                if (find(edge.start) != find(edge.end)) {
                    minValue += edge.value;
                    union(edge.start, edge.end);
                }
            }
            out[t] = String.format("#%d %d", t + 1, minValue);
        }

        for (String a : out) {
            System.out.println(a);
        }


    }


    static int find(int n) {
        if (parent[n] == n) {
            return n;
        }
        return parent[n] = find(parent[n]);
    }

    static void union(int n1, int n2) {

        int parent1 = find(n1);
        int parent2 = find(n2);
        if (parent1 != parent2) {
            parent[parent1] = parent2;
        }
    }

    static class Edge implements Comparable<Edge> {
        int start, end, value;

        Edge(int s, int e, int v) {
            start = s;
            end = e;
            value = v;
        }

        public int compareTo(Edge o) {
            if (value > o.value)
                return 1;
            else if (value < o.value)
                return -1;

            return 0;
        }

    }
}
