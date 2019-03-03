package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11066 {
    static int N;
    static int map[];
    static boolean visit[];
    static int cache[];


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] out = new String[T];

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N];
            visit = new boolean[N];
            cache = new int[N];

            String[] a = br.readLine().split(" ");
            for (int i = 0; i < a.length; i++) {
                map[i] = Integer.parseInt(a[i]);
            }


        }

    }

    static int search(int index, int d) {

        visit[index] = true;
        for (int i = 0; i < N; i++) {

            visit[i] = true;

            if(index - 1 >= 0){

            }


            visit[i] = false;

            //경우의 수
            //1. 바로 인접한 애랑 더한다.
            //2. 임시파일이랑 더한다.



        }

        visit[index] = false;
        return 1;
    }
}
