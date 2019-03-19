package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1239 {


    static int[] array = {0, 15, 19, 28, 38, 41, 53, 58};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String code = br.readLine();
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= N; i++) {

            String a = code.substring((i - 1) * 6, (i - 1) * 6 + 6);
            int cNum = changeNum(a);
            int tmp = -1;

            for (int v : array) {
                int d = diffCount(cNum, v);
                if (d == 0) {
                    result.append(getChar(v));
                    tmp = -2;
                    break;
                } else if (d == 1) {
                    tmp = v;
                }
            }
            if (tmp >= 0) {
                result.append(getChar(tmp));
            }else if(tmp==-1){
                System.out.println(i);
                return;
            }
        }
        System.out.println(result.toString());


    }

    static int diffCount(int a, int b) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            int aa = 1 << i & ((1 << i) & a);
            int bb = 1 << i & ((1 << i) & b);
            if(aa!=bb)count++;
        }
        return count;
    }

    static int changeNum(String a) {
        String[] b = a.split("");
        int c = 1;
        int value = 0;
        for (int i = 5; i >= 0; i--) {
            if (Integer.parseInt(b[i]) == 1) {
                value = value + c;
            }
            c = c * 2;
        }
        return value;
    }

    static String getChar(int i) {
        switch (i) {
            case 0:
                return "A";
            case 15:
                return "B";
            case 19:
                return "C";
            case 28:
                return "D";
            case 38:
                return "E";
            case 41:
                return "F";
            case 53:
                return "G";
            case 58:
                return "H";
        }
        return "z";
    }


}
