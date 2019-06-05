package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q13458 {


    static int N;
    static int B, C;
    static int[] count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long answer = 0;
        N = Integer.parseInt(br.readLine());
        count = new int[N + 1];

        String[] sCount = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            count[i] = Integer.parseInt(sCount[i - 1]);
        }
        String[] a = br.readLine().split(" ");
        B = Integer.parseInt(a[0]);
        C = Integer.parseInt(a[1]);

        for (int i = 1; i <= N; i++) {
            answer += findCount(count[i]);
        }
        System.out.println(answer);


    }

    private static long findCount(int student) {
        int count = 1;
        student = student - B;
        if (student > 0) {
            count += student / C;
            if (student % C > 0)
                count++;
        }
        return count;
    }
}
