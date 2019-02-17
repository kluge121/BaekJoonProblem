package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3307 {

    static Element[] originArray;
    static Element[] sortArray;
    static long max;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] out = new String[T];


        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            originArray = new Element[N];
            sortArray = new Element[N];
            String[] a = br.readLine().split(" ");

            for (int i = 0; i < N; i++) {
                originArray[i] = new Element(Integer.parseInt(a[i]), i);
                sortArray[i] = new Element(Integer.parseInt(a[i]), i);
            }

            for (int i = 0; i < N; i++) {
                long currentValue = originArray[i].value;
                long currentIndex = originArray[i].index;
                int count = 1;

                for (int j = i + 1; j < N; j++) {
                    if (currentValue <= originArray[j].value) {
                        currentValue = originArray[j].value;
                        currentIndex = originArray[j].index;
                        count++;
                    }
                    max = Math.max(max, count);
                }
            }
            out[t] = String.format("#%d %d", t + 1, max);
        }

        for (String a : out) {
            System.out.println(a);
        }
    }

    static class Element implements Comparable<Element> {
        long value;
        long index;

        public Element(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int compareTo(Element o) {

            if (value > o.value) {
                return 1;
            } else if (value < o.value) {
                return -1;
            } else {

                if (index > o.index) {
                    return -1;
                } else {
                    return 1;
                }

            }


        }
    }
}
