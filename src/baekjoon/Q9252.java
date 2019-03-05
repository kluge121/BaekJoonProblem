package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Q9252 {

    static int[][] cache;

    static String a;
    static String b;
    static int max = 0;
    static int maxX = 0;
    static int maxY = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        a = br.readLine();
        b = br.readLine();
        cache = new int[b.length() + 1][a.length() + 1];

        for (int i = 1; i <= b.length(); i++) {
            for (int j = 1; j <= a.length(); j++) {

                if (b.charAt(i - 1) == a.charAt(j - 1)) {
                    cache[i][j] = cache[i - 1][j - 1] + 1;
                    if (cache[i][j] > max) {
                        max = cache[i][j];
                        maxX = i;
                        maxY = j;
                    }
                } else {
                    if (cache[i][j - 1] > cache[i - 1][j]) {
                        cache[i][j] = cache[i][j - 1];
                    } else {
                        cache[i][j] = cache[i - 1][j];
                    }
                }
            }
        }

        Stack<Character> stack = new Stack<>();
        System.out.println(max);
        stack.push(b.charAt(maxX - 1));
        maxX--;
        maxY--;
        max--;

        for (int row = maxX; row > 0; row--) {
            for (int column = 1; column <= maxY; column++) {
                if (cache[row][column] == max && cache[row-1][column] != max) {
                    stack.push(b.charAt(row - 1));
                    maxX = row - 1;
                    maxY = column - 1;
                    max--;
                    break;
                }
            }
            if (max == 0) break;
        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }


}


