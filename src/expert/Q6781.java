package expert;

import java.util.Scanner;

public class Q6781 {


    static int red[];
    static int green[];
    static int blue[];
    static String[] out;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        out = new String[T];

        for (int t = 1; t <= T; t++) {
            red = new int[10];
            green = new int[10];
            blue = new int[10];

            String nums = sc.next();
            String colors = sc.next();

            for (int i = 1; i <= 9; i++) {
                char color = colors.charAt(i - 1);
                if (color == 'R') {
                    red[nums.charAt(i - 1) - '0']++;
                } else if (color == 'G') {
                    green[nums.charAt(i - 1) - '0']++;
                } else if (color == 'B') {
                    blue[nums.charAt(i - 1) - '0']++;
                }
            }
            if (findCombo(red) && findCombo(green) && findCombo(blue)) {
                out[t - 1] = "#" + t + " Win";
            } else {
                out[t - 1] = "#" + t + " Continue";
            }

        }

        for (String a : out) {
            System.out.println(a);
        }
    }
    static boolean findCombo(int[] arr) {

        for (int i = 1; i <= 9; i++) {
            if (arr[i] >= 3) {
                arr[i] -= 3;
            }
        }
        for (int i = 1; i <= 7; i++) {
            while (arr[i] > 0 && arr[i + 1] > 0 && arr[i + 2] > 0) {
                arr[i]--;
                arr[i + 1]--;
                arr[i + 2]--;
            }
        }
        for (int i : arr) {
            if (i > 0) return false;
        }
        return true;

    }


}
