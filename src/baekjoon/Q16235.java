package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q16235 {


    static int N, M, K;
    static Point[][] map;
    static int[][] yang;
    static int[] rowD = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] colD = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] a = br.readLine().split(" ");
        N = Integer.parseInt(a[0]);
        M = Integer.parseInt(a[1]);
        K = Integer.parseInt(a[2]);
        yang = new int[N+1][N+1];
        map = new Point[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            String[] b = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                yang[i][j] = Integer.parseInt(b[j]);
                map[i][j] = new Point(5, new PriorityQueue<>());
            }
        }

        for (int i = 0; i < M; i++) {
            String[] c = br.readLine().split(" ");
            int tr = Integer.parseInt(c[0]);
            int tc = Integer.parseInt(c[1]);
            map[tr][tc].trees.add(Integer.parseInt(c[2]));
        }

        int count = 0;
        for (int i = 0; i < K; i++) {
            map = gogoYear();
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                count += map[i][j].trees.size();
            }
        }
        System.out.println(count);
    }

    static Point[][] gogoYear() {

        Point[][] tmpMap = new Point[N+1][N+1];
        int[][] deadY = new int[N+1][N+1];


        //봄 - 양분 냠냠냠
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int tmpY = 0;
                PriorityQueue<Integer> q = map[i][j].trees;
                PriorityQueue<Integer> nq = map[i][j].trees;
                for (int k = 0; k < q.size(); k++) {
                    int a = q.poll();
                    if (map[i][j].y > a) {
                        map[i][j].y -= a;
                        nq.add(a + 1);
                    } else {
                        tmpY += a / 2;
                    }
                }
                deadY[i][j] = tmpY;
                map[i][j].trees = nq;
            }
        }

        //여름 - 죽은 양분 추가
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j].y += deadY[i][j];
            }
        }


        //가을 - 세팅 번식을 위한 임시 맵
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                tmpMap[i][j] = new Point(0, new PriorityQueue<>());
            }
        }


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                PriorityQueue<Integer> q = map[i][j].trees;
                int a = 0;
                for (int k = 0; k < q.size(); k++) {
                    a = q.poll();
                    if (a % 5 == 0) {
                        for (int z = 0; z < 8; z++) {
                            int cr = i + rowD[z];
                            int cc = j + colD[z];
                            if (isRange(cr, cc)) {
                                tmpMap[i][j].trees.add(1);
                            }
                        }
                    }
                }
                tmpMap[i][j].trees.add(a);
                tmpMap[i][j].y = map[i][j].y;
            }
        }


        //겨울 - 양분 추가
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                tmpMap[i][j].y += yang[i][j];
            }
        }

        return tmpMap;
    }


    static boolean isRange(int r, int c) {
        return r > 0 && c > 0 && r <= N && c <= N;
    }

    static class Point {
        int y;
        PriorityQueue<Integer> trees;

        public Point(int y, PriorityQueue<Integer> trees) {
            this.y = y;
            this.trees = trees;
        }
    }
}
