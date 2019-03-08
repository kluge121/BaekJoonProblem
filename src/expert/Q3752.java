package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Q3752 {

    static int[] map;
    static int N;
    static boolean[] scoreCheck;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] out = new String[T];
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N];
            int sum = 0;
            String[] a = br.readLine().split(" ");
            for (int i = 0; i < a.length; i++) {
                map[i] = Integer.parseInt(a[i]);
                sum += map[i];
            }
            scoreCheck = new boolean[sum+1];

            scoreCheck[0] = true;
            for (int i = 0; i < map.length; i++) {
                for (int j = sum; j >= 0; j--) {
                    if(scoreCheck[j]){
                        scoreCheck[map[i]+j] = true;
                    }

                }
            }
            int count=0;
            for(int i = 0 ; i< scoreCheck.length; i++){
                if(scoreCheck[i])
                    count++;
            }
            out[t] = String.format("#%d %d",t+1,count);


        }

        for (String a : out) {
            System.out.println(a);
        }

    }


}
