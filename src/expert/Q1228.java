package expert;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q1228 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] out = new String[10];

        for (int t = 1; t <= 10; t++) {

            int length = sc.nextInt();
            sc.nextLine();
            String origin = sc.nextLine();
            ArrayList<String> arrayList = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(origin, " ");
            while (st.hasMoreTokens()) {
                arrayList.add(st.nextToken());
            }
            int count = sc.nextInt();
            for (int i = 0; i < count; i++) {
                sc.next();
                int insertIndex = sc.nextInt();
                int range = sc.nextInt();
                for (int k = insertIndex; k < insertIndex + range; k++) {
                    arrayList.add(k, sc.next());
                }

            }
            String result = "";
            for (int i = 0; i < 10; i++) {
                result += arrayList.get(i)+" ";
            }
            out[t - 1] = String.format("#%d " + result, t);
        }
        for (String a : out) {
            System.out.println(a);
        }

    }
}
