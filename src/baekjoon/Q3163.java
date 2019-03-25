
package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q3163 {

    static PriorityQueue<Point> queue;
    static ArrayList<Point> list;
    static Point[] outList;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        Deque d = new LinkedList();


        // - 개미 왼쪽
        // + 개미 오른쪽
        // 을 바라보고 있다요.

        for (int t = 0; t < T; t++) {

            String[] a = br.readLine().split(" ");

            int N = Integer.parseInt(a[0]);
            int L = Integer.parseInt(a[1]);
            int k = Integer.parseInt(a[2]);
            int outN = 0;
            queue = new PriorityQueue<>();
            list = new ArrayList<>();
            outList = new Point[N];

            for (int i = 0; i < N; i++) {
                String[] b = br.readLine().split(" ");
                int position = Integer.parseInt(b[0]);
                int id = Integer.parseInt(b[1]);

                if (id > 0)
                    queue.add(new Point(id, L - position));
                else if (id < 0)
                    queue.add(new Point(id, position));

                list.add(new Point(id, position));
            }


            for (int i = 0; i < N; i++) {
                Point p = queue.poll();
                if (p.index > 0) {
                    Point tmp = list.remove(list.size() - 1);
                    outList[outN++] = (new Point(tmp.index, p.time));
                } else if (p.index < 0) {
                    Point tmp = list.remove(0);
                    outList[outN++] = (new Point(tmp.index, p.time));
                }
            }



            for(Point p : outList){
                System.out.println(p.toString());
            }
            System.out.println(outList[k - 1].index);
        }

    }


    static class Point implements Comparable<Point> {

        int index, time;

        public Point(int index, int time) {
            this.index = index;
            this.time = time;
        }

        @Override
        public int compareTo(Point o) {
            if (time > o.time) {
                return 1;
            } else if (time < o.time) {
                return -1;
            } else {
                if (index > o.index) {
                    return 1;
                } else if (index < o.index) {
                    return -1;
                }
            }
            return 0;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "index=" + index +
                    ", time=" + time +
                    '}';
        }
    }

}
