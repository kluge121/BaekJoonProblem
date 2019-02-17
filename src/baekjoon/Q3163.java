package baekjoon;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q3163 {


    static Point[] info;
    static PriorityQueue<Point> queue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {

            queue = new PriorityQueue<>();
            int N = sc.nextInt();
            int L = sc.nextInt(); // 막대 길이
            int K = sc.nextInt(); // 몇 번째로 떨어질 것 인가?

            info = new Point[N];
            //문제의 요점 -> 시간은 상관없고 떨어지는 순서만 알면 1된다.
            //다만 개미끼리 충돌하면 방향을 바꾼다!
            // 벗! 무조건 사이드에 있는 개미가 먼저 떨어진다.
            // 개미의 전체 인덱스는 절대로 변하지가 않는다./


            for (int i = 0; i < N; i++) {
                int position = sc.nextInt();
                int id = sc.nextInt();
                int time;
                if (id > 0) {
                    time = L - position;
                } else {
                    time = position;
                }
                info[i] = new Point(position, id, id, time);
                queue.add(info[i]);
            }

            //낙하 방향 탐색
            for (int i = 1; i < N - 1; i++) {
                if (info[i - 1].id > 0 && info[i].id < 0) {
                    info[i - 1].id *= -1;
                    info[i].id *= -1;
                    for (int j = i - 2; j >= 0; j--) {
                        if (info[j].id > 0) {
                            info[j].id *= -1;
                        } else break;
                    }
                    for (int j = i + 1; j < N; j++) {
                        if (info[j].id < 0) {
                            info[j].id *= -1;
                        } else break;
                    }
                }
            }

//            for (Point p : info) {
//                System.out.print(p.id + " ");
//            }
            int start = 0;
            int end = N - 1;
            int lastIndex = 0;
            for (int i = 0; i < K - 1; i++) {
                Point p = queue.poll();
                if (p.id == p.originId && p.id > 0) {
                    lastIndex = end;
                    end--;

                } else if (p.id == p.originId && p.id < 0) {
                    lastIndex = start;
                    start++;

                } else if (p.id != p.originId && p.originId < 0) {
                    lastIndex = end;
                    start--;

                } else if (p.id != p.originId && p.originId > 0) {
                    lastIndex = start;
                    start++;

                }
            }
//            //떨어질 순서 탐색 스타트
//            int start = 0;
//            int end = N - 1;
//            int lastIndex = 0;
//            for (int i = 0; i < K - 1; i++) {
//                if ((info[start].outTime > info[end].outTime) && info[end].originId == info[end].id) {
//                    end--;
//                    lastIndex = end;
//                } else if ((info[start].outTime > info[end].outTime) && info[end].originId != info[end].id) {
//                    start++;
//                    lastIndex = start;
//                } else if ((info[start].outTime < info[end].outTime) && info[start].originId == info[start].id) {
//                    start++;
//                    lastIndex = start;
//                } else if ((info[start].outTime < info[end].outTime) && info[start].originId != info[start].id) {
//                    end--;
//                    lastIndex = end;
//
//                } else if ((info[start].outTime == info[end].outTime) && info[start].originId == info[start].id) {
//                    if (info[start].id > info[end].id) {
//                        end--;
//                        lastIndex = end;
//                    } else {
//                        start++;
//                        lastIndex = start;
//                    }
//                } else {
//                    if (info[start].id > info[end].id) {
//                        start++;
//                        lastIndex = start;
//                    } else {
//                        end--;
//                        lastIndex = end;
//                    }
//                }
//
//
//            }
            System.out.println(info[lastIndex].originId);

        }


    }

    static class Point implements Comparable<Point> {
        int position;
        int originId;
        int id;
        int outTime;

        public Point(int position, int originId, int id, int outTime) {
            this.position = position;
            this.originId = originId;
            this.id = id;
            this.outTime = outTime;
        }

        @Override
        public int compareTo(@NotNull Point o) {
            if (outTime > o.outTime) {
                return 1;
            } else if (outTime < o.outTime) {
                return -1;
            } else {
                if (originId > o.originId)
                    return 1;
                else if (originId < o.originId) {
                    return -1;
                }
            }
            return 0;
        }
    }


}
