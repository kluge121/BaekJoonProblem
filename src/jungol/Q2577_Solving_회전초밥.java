package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Q2577_Solving_회전초밥 {
    static int n;
    static int d;
    static int k;
    static int c;
    static int map[];
    static HashSet<Integer> hashSet;
    static Queue<Integer> queue1;
    static Queue<Integer> queue2;
    static int[] count;


    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] a = br.readLine().split(" ");
        n = Integer.parseInt(a[0]);
        d = Integer.parseInt(a[1]);
        k = Integer.parseInt(a[2]);
        c = Integer.parseInt(a[3]);
        map = new int[n];
        max = 0;
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
        hashSet = new HashSet<>();
        count = new int[d + 1];

        //시간복잡도 k
        for (int i = 0; i < k; i++) {
            int in = Integer.parseInt(br.readLine());
            queue1.add(in);
            count[in]++;
            if (count[in] == 1) {
                hashSet.add(in);
            }
        }

        //시간복잡도 n
        for (int i = 1; i <= n - 1; i++) {

            //시간복잡도1
            if (hashSet.contains(c)) {
                max = Math.max(max, hashSet.size());
            } else {
                max = Math.max(max, hashSet.size() + 1);
            }

            if (max == k + 1) break;

            int in = 0;

            if (i <= n - k) {
                in = Integer.parseInt(br.readLine());
            } else if (i > n - k) {
                in = queue2.poll();
            }


            //시간복잡도1
            int out = queue1.poll();
            queue1.add(in);
            if (i <= n - k) {
                queue2.add(out);
            }
            count[in]++;
            count[out]--;

            //시간복잡도1
            if (count[in] == 1) {
                hashSet.add(in);
            }

            //시간복잡도1
            if (count[out] == 0) {
                hashSet.remove(out);
            }

        }
        System.out.println(max);
    }
}
