package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Q7208 {

    static boolean[] visit;
    static int[] state;
    static int N;
    static int time;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        String [] out = new String[T];

        for (int t = 0; t < T; t++) {

            N = Integer.parseInt(br.readLine().trim());
            adj = new ArrayList[N + 1];
            state = new int[N + 1];
            visit = new boolean[N + 1];
            time = 0;

            String[] b = br.readLine().split(" ");
            for (int i = 1; i <= N; i++) {
                int value = Integer.parseInt(b[i - 1]);
                state[i] = value;

            }

            for (int i = 1; i <= N; i++) {
                String[] a = br.readLine().split(" ");
                for (int j = 1; j <= N; j++) {
                    int value = Integer.parseInt(a[j - 1]);
                    if (value == 1) {
                        if (adj[i] == null)
                            adj[i] = new ArrayList<>();
                        adj[i].add(j);
                    }
                }
            }

            for (int i = 0; i < adj.length; i++) {

                int tmpIndex = nextMax();

                if (tmpIndex == -1)
                    break;

                ArrayList<Integer> tmpList = adj[tmpIndex];
                int count[] = new int[5];
                int minValue = Integer.MAX_VALUE;
                boolean flag = false;

                for (int j = 0; j < tmpList.size(); j++) {
                    int value = state[tmpList.get(j)];
                    if (value == state[tmpIndex]) {
                        flag = true;
                    }
                    count[value]++;
                }

                if (flag) {
                    for (int j = 1; j <= 4; j++) {
                        if (minValue > count[j] ) {
                            minValue = count[j];
                        }
                    }
                    state[tmpIndex] = minValue;
                    time++;
                }
            }
            out[t] = String.format("#%d %d", t + 1, time);
        }
        for(String a : out) {
            System.out.println(a);
        }


    }

    static int nextMax() {

        int max = 0;
        int index = -1;

        for (int i = 1; i <= N; i++) {
            if (max < adj[i].size() && !visit[i]) {
                max = adj[i].size();
                index = i;
            }

        }

        if (index != -1)
            visit[index] = true;

        return index;

    }

}

