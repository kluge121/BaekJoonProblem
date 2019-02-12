import java.util.Scanner;

public class Q10253 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] out = new String[T];

        for (int t = 0; t < T; t++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int count = 2;

            while (true) {

                // a/b  1/count
                if (a * count > b) {
                    a = a * count - b;
                    b = b * count;
                    b = b / a;
                    a = 1;
                } else if (a * count == b) {
                    out[t] = b * count + "";
                    break;

                }
                count++;
            }

        }
        for (String a : out) {
            System.out.println(a);
        }

    }


}
