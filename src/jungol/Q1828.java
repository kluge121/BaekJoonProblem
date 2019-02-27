package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Q1828 {

    public static void main(String[] args) throws IOException {

        ArrayList<Point> list = new ArrayList<>();


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            String[] a = br.readLine().split(" ");
            int n1 = Integer.parseInt(a[0]) + 270;
            int n2 = Integer.parseInt(a[1]) + 270;
            list.add(new Point(n1, n2));
        }
        Collections.sort(list);

        int count = 0;

        Point current = list.get(0);
        count++;
        for (int i = 1; i < list.size(); i++) {
            Point tmp = list.get(i);
            if (!(current.end >= tmp.start)) {
                count++;
                current = tmp;
            }
        }
        System.out.println(count);
    }

    static class Point implements Comparable<Point> {
        int start;
        int end;

        Point(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(end, o.end);
        }
    }

}
