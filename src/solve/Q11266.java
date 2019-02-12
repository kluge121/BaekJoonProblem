package solve;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q11266 {

    static Queue<Integer> queue;
    static int[][] map;
    static int[] visit;
    static int[] bfs;
    static int v;
    static int e;
    static int bfsIndex;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        queue = new LinkedList<>();
        v = sc.nextInt();
        e = sc.nextInt();
        bfsIndex = 1;
        bfs = new int[v + 1];
        map = new int[v + 1][v + 1];
        visit = new int[v + 1];
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a][b] = 1;
            map[b][a] = 1;
        }

        queue.add(1);
        while (!queue.isEmpty()) {
            bfsSpanning(queue.poll());
        }

        System.out.println(Arrays.toString(bfs));

    }

    static void bfsSpanning(int count) {
        if (visit[count] == 1) return;
        visit[count] = 1;
        bfs[bfsIndex++] = count;
        for (int i = 1; i <= v; i++) {
            if (map[count][i] == 1 && visit[i] == 0) {
                queue.add(i);
            }
        }


    }

}
