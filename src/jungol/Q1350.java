package jungol;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Q1350 {


    static ArrayList<Adj> list;
    static int[] root;
    static int sum;


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");
        int N = Integer.parseInt(a[0]);
        int M = Integer.parseInt(a[1]);
        root = new int[N + 1];
        sum = 0;
        list = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            root[i] = i;
        }
        for (int i = 0; i < M; i++) {
            String[] c = br.readLine().split(" ");
            int s = Integer.parseInt(c[0]);
            int e = Integer.parseInt(c[1]);
            int cost = Integer.parseInt(c[2]);

            if (list.contains(new Adj(s, e, 0))) {
                int index = list.indexOf(new Adj(s, e, 0));
                if (list.get(index).c < cost)
                    list.get(index).c = cost;
            } else {
                list.add(new Adj(s, e, cost));
            }
        }


        Collections.sort(list);

        for (Adj adj : list) {
            int s = adj.s;
            int e = adj.e;
            if (find(s) != find(e))
                sum += adj.c;
            union(adj.s, adj.e);
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
            root[n2] = r_n1;

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Adj adj = (Adj) o;
            return s == adj.s &&
                    e == adj.e;
        }

        @Override
        public int hashCode() {
            return Objects.hash(s, e);
        }
    }
}
