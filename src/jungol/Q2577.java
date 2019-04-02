package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Q2577 {
    static int n;
    static int d;
    static int k;
    static int c;
    static int map[];
    static int adj[];
    static ArrayList<Integer> cIndexList;
    static HashSet<Integer> hashSet;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        hashSet = new HashSet<>();
        String[] a = br.readLine().split(" ");
        n = Integer.parseInt(a[0]);
        d = Integer.parseInt(a[1]);
        k = Integer.parseInt(a[2]);
        c = Integer.parseInt(a[3]);
        map = new int[n];
        adj = new int[n];
        max = 0;
        hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int cu = Integer.parseInt(br.readLine());

            if (hashSet.size() < k) {
                if (hashSet.contains(cu)) {
                    max = Math.max(max, hashSet.size());
                    hashSet = new HashSet<>();

                }
                hashSet.add(cu);
            } else if (hashSet.size() == k) {
                if (hashSet.contains(cu)) {
                    max = Math.max(max, hashSet.size());
                    hashSet = new HashSet<>();
                } else {
                    max = Math.max(max, hashSet.size() + 1);
                    return;
                }
            }

        }
        System.out.println(max);
    }
}
