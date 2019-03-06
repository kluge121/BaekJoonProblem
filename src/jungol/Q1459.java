package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Q1459 {

    static int[] discover;
    static int[] map;
    static boolean visit[];
    static boolean check[];
    static HashSet<Integer> hashSet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N + 1];
        visit = new boolean[N + 1];
        check = new boolean[N + 1];
        discover = new int[N + 1];
        hashSet = new HashSet<>();

        for (int i = 1; i <= N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            map[i] = tmp;
        }
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) dfs(i);
        }
        System.out.println(hashSet.size());
        ArrayList<Integer> arrayList = new ArrayList(hashSet);
        Collections.sort(arrayList);

        for (int i : arrayList) {
            System.out.println(i);
        }
    }

    static void dfs(int index) {
        if (index == 0) {
            System.out.println(hashSet.toString());
        }
        if (visit[index]) {
            int tmpIndex = map[index];
            check[index] = true;
            hashSet.add(index);
            while (true) {
                if (!check[tmpIndex]) {
                    check[tmpIndex] = true;
                    hashSet.add(tmpIndex);
                }
                tmpIndex = map[tmpIndex];
                if (tmpIndex == index) {
                    return;
                }
            }
        } else {
            visit[index] = true;
            dfs(map[index]);
            visit[index] = false;
        }

    }
}
