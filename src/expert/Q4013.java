package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Q4013 {
    static Deque<Integer> t1;
    static Deque<Integer> t2;
    static Deque<Integer> t3;
    static Deque<Integer> t4;
    static Deque<Integer>[] dList;
    static ArrayList<Integer>[] lList;

    static boolean[] check;
    static int k = 0;

    static ArrayList<Integer> l1;
    static ArrayList<Integer> l2;
    static ArrayList<Integer> l3;
    static ArrayList<Integer> l4;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        String[] out = new String[T];
        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());
            String[] a1 = br.readLine().split(" ");
            String[] a2 = br.readLine().split(" ");
            String[] a3 = br.readLine().split(" ");
            String[] a4 = br.readLine().split(" ");
            t1 = new LinkedList<>();
            t2 = new LinkedList<>();
            t3 = new LinkedList<>();
            t4 = new LinkedList<>();
            for (int i = 0; i < 8; i++) {
                t1.add(Integer.parseInt(a1[i]));
                t2.add(Integer.parseInt(a2[i]));
                t3.add(Integer.parseInt(a3[i]));
                t4.add(Integer.parseInt(a4[i]));
            }
            dList = new Deque[]{t1, t2, t3, t4};
            lList = new ArrayList[]{l1, l2, l3, l4};
            goList();
            for (int i = 0; i < k; i++) {
                check = new boolean[3];
                for (int q = 0; q <= 2; q++) {
                    if (!lList[q].get(2).equals(lList[q + 1].get(6))) {
                        check[q] = true;
                    }
                }
                String[] b = br.readLine().split(" ");
                int th = Integer.parseInt(b[0]) - 1;
                int d = Integer.parseInt(b[1]);
                rotate(dList[th], d);
                int prev = d;
                for (int j = th + 1; j <= 3; j++) {
                    if (check[j - 1]) {
                        prev *= -1;
                        rotate(dList[j], prev);
                    } else {
                        break;
                    }
                }
                prev = d;
                for (int j = th - 1; j >= 0; j--) {
                    if (check[j]) {
                        prev *= -1;
                        rotate(dList[j], prev);
                    } else {
                        break;
                    }
                }
                goList();
            }
            out[t] = String.format("#%d %d", t + 1, getPoint());
        }
        for (String a : out) {
            System.out.println(a);
        }
    }
    static void rotate(Deque<Integer> d, int rotate) {
        if (rotate == 1) {
            d.addFirst(d.pollLast());
        } else if (rotate == -1) {
            d.addLast(d.pollFirst());
        }
    }
    static void goList() {

        lList[0] = new ArrayList(t1);
        lList[1] = new ArrayList(t2);
        lList[2] = new ArrayList(t3);
        lList[3] = new ArrayList(t4);
    }
    static int getPoint() {
        int score = 0;
        score += lList[0].get(0) == 0 ? 0 : 1;
        score += lList[1].get(0) == 0 ? 0 : 2;
        score += lList[2].get(0) == 0 ? 0 : 4;
        score += lList[3].get(0) == 0 ? 0 : 8;
        return score;
    }
}
