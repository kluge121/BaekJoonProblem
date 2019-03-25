package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SuppressWarnings("Duplicates")
public class Q14890 {


    static int N;
    static int L;
    static int[][] map;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] a = br.readLine().split(" ");
        N = Integer.parseInt(a[0]);
        L = Integer.parseInt(a[1]);
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] b = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(b[j]);
            }
        }

        //행 검사
        for (int i = 0; i < N; i++) {

            int check = map[i][0] * N;
            int sum = 0;

            for (int j = 0; j < N; j++) {
                sum += map[i][j];
            }
            if (sum == check) {
                count++;
                System.out.println("행" + i);
                continue;
            }
            boolean flag = false;
            boolean[] visit = new boolean[N + 1];
            for (int j = 0; j < N - 1; j++) {
                int cValue = map[i][j];

                if(cValue == map[i][j+1])continue;
                //현재값보다 다음값이 1 낮을 때
                if (cValue == map[i][j + 1] - 1 && j + L < N && !visit[j + 1]) {
                    for (int k = j + 1; k <= j + L; k++) {
                        if (map[i][k] != map[i][j + 1] || !visit[k]) {
                            flag = true;
                            break;
                        }
                        for (int z = j + 1; z <= j + L; z++) {
                            visit[z] = true;
                        }
                    }

                    //현재값 보다 다음값이 1 높을 떄
                } else if (cValue == map[i][j + 1] + 1 && j - L > 0 && visit[j]) {
                    for (int k = j - 1; k >= j - L; k--) {
                        if (map[i][k] != map[i][j] || !visit[k]) {
                            flag = true;
                            break;
                        }
                        for (int z = j; z >= j - L; z--) {
                            visit[z] = true;
                        }
                    }

                } else if (cValue == map[i][j + 1] - 1 && j + L >= N) {
                    continue;
                } else if (cValue == map[i][j + 1] + 1 && j - L < 0 && visit[j]) {
                    continue;
                }


                if (flag) break;

            }

            if (flag) continue;

            System.out.println("행" + i);
            count++;


        }


        //열 검사
        for (int i = 0; i < N; i++) {

            int check = map[0][i] * N;
            int sum = 0;

            for (int j = 0; j < N; j++) {
                sum += map[j][i];
            }
            if (sum == check) {
                System.out.println("열" + i);
                count++;
                continue;
            }
            boolean flag = false;
            boolean[] visit = new boolean[N + 1];
            for (int j = 0; j < N - 1; j++) {
                int cValue = map[j][i];
                if (cValue == map[j + 1][i]) continue;
                //현재값보다 다음값이 1 낮을 때
                if (cValue == map[j + 1][i] - 1 && j + L < N && !visit[j + 1]) {
                    for (int k = j + 1; k <= j + L; k++) {
                        if (map[k][i] != map[j + 1][i] || !visit[k]) {
                            flag = true;
                            break;
                        }
                        for (int z = j + 1; z <= j + L; z++) {
                            visit[z] = true;
                        }
                    }

                    //현재값 보다 다음값이 1 높을 떄
                } else if (cValue == map[j + 1][i] + 1 && j - L > 0 && visit[j]) {
                    for (int k = j - 1; k >= j - L; k--) {
                        if (map[k][i] != map[j][i] || !visit[k]) {
                            flag = true;
                            break;
                        }
                        for (int z = j; z >= j - L; z--) {
                            visit[z] = true;
                        }
                    }

                } else if (cValue == map[j + 1][i] - 1 && j + L >= N) {
                    continue;
                } else if (cValue == map[j + 1][i] + 1 && j - L < 0 && visit[j]) {
                    continue;
                }


                if (flag) break;

            }

            if (flag) continue;
            System.out.println("열" + i);
            count++;

        }

        System.out.println(count);
    }

}
