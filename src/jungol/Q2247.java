package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Q2247 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int maxTime = 0;
        int notTime = 0;

        ArrayList<Point> list = new ArrayList<>();
        ArrayList<Point> resultList = new ArrayList<>();
        for (int i = 0; i < N; i++) {

            String[] a = br.readLine().split(" ");
            int start = Integer.parseInt(a[0]);
            int end = Integer.parseInt(a[1]);
            if (start != end)
                list.add(new Point(start, end));
        }
        Collections.sort(list);
        Point main = list.get(0);
        if (main.start != 1) {
            notTime = main.start - 1;
        }

        for (int i = 1; i < list.size(); i++) {
            Point tmp1 = list.get(i);

            if (tmp1.start <= main.end && main.end < tmp1.end) {
                main.end = tmp1.end;
            } else if(tmp1.start > main.end) {
                resultList.add(main);
                maxTime = Math.max(maxTime, main.end - main.start);
                main = new Point(tmp1.start, tmp1.end);

                if(resultList.size()>1){
                    Point p1 = resultList.get(resultList.size()-1);
                    Point p2 = resultList.get(resultList.size()-2);
                    notTime = Math.max(notTime, p1.start - p2.end);
                }
            }
        }

        resultList.add(main);
        maxTime = Math.max(maxTime, main.end - main.start);
        if(resultList.size()>1){
            Point p1 = resultList.get(resultList.size()-1);
            Point p2 = resultList.get(resultList.size()-2);
            notTime = Math.max(notTime, p1.start - p2.end);
        }
        System.out.println(maxTime + " " + notTime);

    }
    static class Point implements Comparable<Point> {
        int start;
        int end;

        public Point(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Point o) {
            if (start > o.start)
                return 1;
            else if (start < o.start)
                return -1;
            else {
                if (end < o.end)
                    return -1;
                else return 1;
            }
        }
    }
}
