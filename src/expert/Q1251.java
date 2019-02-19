package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Q1251 {

    static String[] out;
    static int[] parent;
    static PriorityQueue<Edge> queue;
    static ArrayList<Point> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        out = new String[T];

        for (int t = 0; t < T; t++) {
            double minCost = 0.0;
            int N = Integer.parseInt(br.readLine());
            queue = new PriorityQueue<>();
            list = new ArrayList<>();
            parent = new int[N];
            String[] x = br.readLine().split(" ");
            String[] y = br.readLine().split(" ");

            double E = Double.parseDouble(br.readLine());


            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < x.length; i++) {
                list.add(new Point(Integer.parseInt(x[i]), Integer.parseInt(y[i])));
            }

            for (int i = 0; i < list.size() - 1; i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    if (i != j) {
                        double cost = getDistance(list.get(i), list.get(j)) * E;
                        queue.add(new Edge(i, j, cost));
                    }
                }
            }

            while (!queue.isEmpty()) {
                Edge edge = queue.poll();
                if (find(edge.start) != find(edge.end)) {
                    union(edge.start, edge.end);
                    minCost += edge.value;
                }
            }
            out[t] = String.format("#%d %d", t + 1, Math.round(minCost));
        }
        for (String a : out) {
            System.out.println(a);
        }
    }


    static int find(int n) {
        if (parent[n] == n)
            return n;
        return parent[n] = find(parent[n]);
    }

    static void union(int n1, int n2) {
        if (find(n1) != find(n2)) {
            parent[find(n1)] = find(n2);
        }
    }

    static double getDistance(Point p1, Point p2) {
        return Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> {
        int start, end;
        double value;

        public Edge(int start, int end, double value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            if (value > o.value) return 1;
            else return -1;
        }
    }
}
