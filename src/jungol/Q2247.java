package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2247 {


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] times = new int[24];
        int N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            String[] a = br.readLine().split(" ");
            int tmp1 = Integer.parseInt(a[0]);
            int tmp2 = Integer.parseInt(a[1]);


            if (tmp1 != tmp2) {
                for (int j = tmp1; j < tmp2; j++) {
                    times[j]++;
                }
            }


        }

        int lastIndex = 0;

        for (int i = times.length - 1; i >= 0; i--) {

            if (times[i] != 0) {
                lastIndex = i;
                break;
            }
        }


        int count1Max = 0;
        int count0Max = 0;

        int count1 = 0;
        int count0 = 0;

        int prev = -1;

        for (int j = 1; j <= lastIndex; j++) {


            if ((times[j] == 0 && (prev == 0 || prev == -1)) || (times[j] == 0 && prev == 1)) {
                count0++;
                count1 = 0;
                prev = 0;


            } else if ((times[j] >= 1 && (prev == 1 || prev == -1)) || (times[j] >= 1 && prev == 0)) {
                count1++;
                count0 = 0;
                prev = 1;

            }
            count0Max = Math.max(count0Max, count0);
            count1Max = Math.max(count1Max, count1);



        }
        System.out.println(count1Max + " " + count0Max);
    }


}
