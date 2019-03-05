package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Q2634 {

    static ArrayList<Integer> mList;
    static ArrayList<Point> nList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");

        int M = Integer.parseInt(a[0]);
        int N = Integer.parseInt(a[1]);
        int L = Integer.parseInt(a[2]);

        int count = 0;
        mList = new ArrayList<>();
        nList = new ArrayList<>();

        String[] b = br.readLine().split(" ");
        for (int i = 0; i < b.length; i++) {
            int mx = Integer.parseInt(b[i]);
            mList.add(mx);
        }
        Collections.sort(mList);

        for (int i = 0; i < N; i++) {
            String[] c = br.readLine().split(" ");
            int y = Integer.parseInt(c[1]);
            int x = Integer.parseInt(c[0]);
            if (y <= L) {
                nList.add(new Point(x, y));
            }
        }

        for (Point p : nList) {
            int coreIndex = findIndex(p.column);
            for (int i = coreIndex - 1; i <= coreIndex + 1; i++) {

                if (i > -1 && mList.size() > i && distance(mList.get(i), p.column, p.row) <= L) {
                    count++;
                    break;
                }
            }

        }

        System.out.println(count);

    }

    static int findIndex(int nx) {

        int start = 0;
        int end = mList.size() - 1;
        int mid = (start + end) / 2;

        while (start <= end) {

            mid = (start + end) / 2;

            if (mList.get(mid) > nx) {
                end = mid - 1;
            } else if (mList.get(mid) < nx) {
                start = mid + 1;
            } else {
                return mid;
            }

        }
        return mid;
    }


    static class Point {
        int row, column;

        public Point(int column, int row) {
            this.row = row;
            this.column = column;
        }
    }

    static int distance(int x, int column, int row) {
        return Math.abs(x - column) + row;
    }


}
