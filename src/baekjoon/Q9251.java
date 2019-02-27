package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9251 {

    static int[][] cache;
    static boolean[][] visit;

    static String a;
    static String b;

    static int max = 0 ;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         a = br.readLine();
         b = br.readLine();

        cache = new int[a.length()][b.length()];
        visit = new boolean[a.length()][b.length()];
        search(0, 0);
        System.out.println(max);
    }

    static int search(int aa, int bb) {
        if (aa > a.length() - 1 || bb > b.length() - 1) return 0;
        if (visit[aa][bb]) return cache[aa][bb];
        visit[aa][bb] = true;
        int count = 0;
        if (a.charAt(aa) == b.charAt(bb)) {
            count = Math.max(count, search(aa + 1, bb + 1)) + 1 ;
        } else {
            count = Math.max(count, search(aa, bb + 1));
            count = Math.max(count, search(aa + 1, bb));

        }

        max = Math.max(count,max);
        return cache[aa][bb] = count;
    }


}


