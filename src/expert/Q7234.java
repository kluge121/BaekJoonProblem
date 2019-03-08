package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q7234 {

    public static void main(String args[]) throws IOException {

        int [] rowD = {-2,-1,1,2,0,0,0,0};
        int [] columnD = {0,0,0,0,-2,-1,1,2};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = br.readLine().charAt(0)-'0';
        String[] out = new String[T];

        for (int t = 0; t < T; t++) {

            String[] a = br.readLine().split(" ");
            int N = Integer.parseInt(a[0]);
            int B = Integer.parseInt(a[1]);
            int [][] map = new int[N+1][N+1];
            int max = 0;

            for (int i = 0; i < B; i++) {
                String [] b = br.readLine().split(" ");
                int row = Integer.parseInt(b[0]);
                int column = Integer.parseInt(b[1]);

                map[row][column]++;
                max = Math.max(max, map[row][column]);

                for(int j = 0 ; j < 8 ; j++) {

                    int tmpR = row + rowD[j];
                    int tmpC = column + columnD[j];

                    if(tmpR>0 && tmpC>0 && tmpR<=N && tmpC<=N) {
                        map[tmpR][tmpC]++;
                        max = Math.max(max,map[tmpR][tmpC]);
                    }
                }
            }

            out[t] = String.format("#%d %d", t+1, max);
        }

        for(String a : out) {
            System.out.println(a);
        }

    }

}
