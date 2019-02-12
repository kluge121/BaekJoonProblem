package expert;

import java.util.Scanner;

public class Q1240 {

    static String[] password = {"0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011", "0110111", "0001011"};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] out = new String[T];

        for (int t = 0; t < T; t++) {
            int[] code = new int[8];
            int codeIndex = 7;
            int row = sc.nextInt();
            sc.nextInt();
            sc.nextLine();
            String[] str = new String[row];
            int startRow = 0;
            boolean flag = false;
            for (int j = 0; j < row; j++) {
                String tmp = sc.nextLine();
                str[j] = tmp;
                if (tmp.contains("1") && !flag) {
                    startRow = j;
                    flag = true;
                }
            }
            int index = 0;
            String a = str[startRow];
            for (int i = a.length() - 1; i >= 0; i--) {
                if (a.charAt(i) == '1') {
                    index = i;
                    break;
                }
            }
            while (index - 6 >= 0) {
                String tmp = a.substring(index - 6, index + 1);
                boolean flag2 = false;
                for (int i = 0; i < password.length; i++) {
                    if (tmp.equals(password[i])) {
                        code[codeIndex--] = i;
                        flag2 = true;
                        break;
                    }
                }
                if (flag2) {
                    index -= 7;
                } else {
                    index--;
                }
            }
            int e = code[1] + code[3] + code[5] + code[7];
            int o = (code[0] + code[2] + code[4] + code[6]) * 3;

            if ((e + o) % 10 == 0) {
                int sum = 0;
                for (int i : code) {
                    sum += i;
                }
                out[t] = String.format("#%d %d", t + 1, sum);
            } else {
                out[t] = String.format("#%d %d", t + 1, 0);
            }
        }

        for (String a : out) {
            System.out.println(a);
        }
    }
}
