package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1753 {


    static Queue<Adj> queue;
    static ArrayList<Adj>[] adjList;
    static int start;
    static int[] dist;
    static boolean[] visit;
    static int V;

    static final int INF=99999;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");
        String c = br.readLine();
        V = Integer.parseInt(a[0]); // 정점개수
        int E = Integer.parseInt(a[1]); // 간선개수

        start = Integer.parseInt(c);
        visit = new boolean[V + 1];
        adjList = new ArrayList[V + 1];
        queue = new LinkedList<>();
        dist = new int[V + 1];

        Arrays.fill(dist, INF);


        for (int i = 0; i < E; i++) {
            String[] b = br.readLine().split(" ");
            int s = Integer.parseInt(b[0]);
            int e = Integer.parseInt(b[1]);
            int w = Integer.parseInt(b[2]);
            if (adjList[s] == null) {
                adjList[s] = new ArrayList<>();
            }
            Adj tmp = new Adj(s, e, w);
            if (adjList[s].contains(new Adj(s, e, w))) {
                if (adjList[s].get(adjList[s].indexOf(tmp)).value > w) {
                    adjList[s].get(adjList[s].indexOf(tmp)).value = w;
                }
            } else {
                adjList[s].add(new Adj(s, e, w));
            }
        }
        Dijkstra(start);
        System.out.println(Arrays.toString(dist));
        System.out.println(Arrays.toString(visit));
    }


    static void Dijkstra(int start) {
        dist[start] = 0;
        visit[start] = true;
        for (Adj a : adjList[start]) {
            dist[a.end] = a.value;
        }
        int i = 1;
        while (i<V) {

            int minIndex = findMinNode();
            if (minIndex == INF) break;
            visit[minIndex] = true;

            for (Adj a : adjList[minIndex]) {
                if (!visit[a.end]) {
                    if (dist[a.start] + a.value < dist[a.end])
                        dist[a.end] = dist[a.start] + a.value;
                }
            }
            i++;
        }


    }

    static int findMinNode() {
        int min = INF;
        for (int i = 1; i <= V; i++) {
            if (!visit[i])
                min = Math.min(min, dist[i]);

        }
        return min;
    }


    static class Adj implements Comparable<Adj> {
        int start, end, value;

        public Adj(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Adj adj = (Adj) o;
            return start == adj.start &&
                    end == adj.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }

        @Override
        public int compareTo(Adj o) {
            if (value > o.value) return -1;
            else return 1;
        }
    }
}
