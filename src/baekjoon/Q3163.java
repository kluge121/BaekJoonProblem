
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q3163 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String[] a = br.readLine().split(" ");
            int N = Integer.parseInt(a[0]);
            int L = Integer.parseInt(a[1]);
            int K = Integer.parseInt(a[2]);

            Point[] sortList = new Point[N];
            Point[] orderList = new Point[N];
            ResultO[] resultList = new ResultO[N];

            for (int i = 0; i < N; i++) {
                String[] b = br.readLine().split(" ");
                int position = Integer.parseInt(b[0]);
                int id = Integer.parseInt(b[1]);
                int time;
                if (id > 0) {
                    time = L - position;
                } else {
                    time = position;
                }
                Point p = new Point(id, time);
                sortList[i] = p;
                orderList[i] = p;
            }
            Arrays.sort(sortList);

            int start = 0;
            int end = N - 1;
            int preValue = 999999;
            for (int i = 0; i < N; i++) {
                int index = i;
                if (preValue == sortList[i].outTime) {
                    index = i - 1;
                }
                if (sortList[i].id > 0) {
                    resultList[i] = new ResultO(index, orderList[end--].id, sortList[i].outTime);
                } else {
                    resultList[i] = new ResultO(index, orderList[start++].id, sortList[i].outTime);
                }
                preValue = sortList[i].outTime;
            }
            Arrays.sort(resultList);
            System.out.println(resultList[K - 1].id);

        }

    }

    static class Point implements Comparable<Point> {
        int id;
        int outTime;

        public Point(int id, int outTime) {
            this.id = id;
            this.outTime = outTime;
        }

        @Override
        public int compareTo(Point o) {
            if (outTime > o.outTime) {
                return 1;
            } else if (outTime < o.outTime) {
                return -1;
            } else {
                if (id > o.id) {
                    return 1;
                } else if (id < o.id) {
                    return -1;
                }
            }
            return 0;
        }
    }

    static class ResultO implements Comparable<ResultO> {
        int index;
        int id;
        int time;

        public ResultO(int index, int id, int time) {
            this.index = index;
            this.id = id;
            this.time = time;
        }

        @Override
        public int compareTo(ResultO o) {
            if (index > o.index) {
                return 1;
            } else if (index < o.index) {
                return -1;
            } else {
                if (id > o.id) {
                    return 1;
                } else if (id < o.id) {
                    return -1;
                }
            }
            return 0;
        }

        @Override
        public String toString() {
            return "ResultO{" +
                    "index=" + index +
                    ", id=" + id +
                    ", time=" + time +
                    '}';
        }
    }


}
