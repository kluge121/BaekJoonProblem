package solve;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

public class Q7662Re {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] out = new String[T];
        for (int t = 0; t < T; t++) {

            int n = sc.nextInt();
            boolean[] visited = new boolean[n];
            sc.nextLine();
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();

            for (int i = 0; i < n; i++) {
                String type = sc.next();
                int value = sc.nextInt();
                sc.nextLine();
                if (type.equals("I")) {
                    treeMap.put(value, value);
                } else if (!treeMap.isEmpty()) {
                    if (value == 1) {
                        treeMap.remove(treeMap.lastKey());
                    } else if (value == -1) {
                        treeMap.remove(treeMap.firstKey());
                    }
                }
            }

            if (treeMap.isEmpty()) {
                out[t] = "EMPTY";
            } else {
                int max = treeMap.lastKey();
                int min = treeMap.firstKey();
                out[t] = max + " " + min;
            }
        }
        for (String a : out) {
            System.out.println(a);
        }


    }
}
