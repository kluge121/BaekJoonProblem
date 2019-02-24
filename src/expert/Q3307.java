package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3307 {


    static int[] array;
    static int[] save;
    static boolean[] visit;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] out = new String[T];


        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            array = new int[N];
            save = new int[N];
            visit = new boolean[N];

            String[] a = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                array[i] = Integer.parseInt(a[i]);
            }
            int v = 0;
            for (int i = 0; i < N; i++) {
                int tmp = search(i);
                v = Math.max(tmp, v);
            }

            out[t] = String.format("#%d %d", t + 1, v);
        }

        for (String a : out) {
            System.out.println(a);
        }

    }

    static int search(int index) {
        if (visit[index]) {
            return save[index];
        }
        visit[index] = true;
        for (int i = index + 1; i < N; i++) {
            if (array[index] <= array[i]) {
                save[index] = Math.max(save[index], search(i));
            }
        }
        save[index]++;
        return save[index];
    }


}
