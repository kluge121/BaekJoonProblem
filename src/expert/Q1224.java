package expert;

import java.util.Scanner;
import java.util.Stack;

public class Q1224 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] out = new String[10];

        for (int t = 0; t < 10; t++) {

            int n = sc.nextInt();
            sc.nextLine();
            char[] input = sc.nextLine().toCharArray();

            Stack<Character> stack = new Stack<>();
            Stack<Integer> cal_stack = new Stack<>();
            String post = "";

            for (char a : input) {
                switch (a) {
                    case '+':
                        while (!stack.isEmpty() && get_weight(stack.peek()) >= get_weight(a)) {
                            post += stack.pop();
                        }
                        stack.push(a);
                        break;
                    case '*':
                        while (!stack.isEmpty() && get_weight(stack.peek()) >= get_weight(a)) {
                            post += stack.pop();
                        }
                        stack.push(a);
                        break;
                    case '(':
                        stack.push(a);
                        break;
                    case ')':
                        while (stack.peek() != '(') {
                            post += stack.pop();
                        }
                        stack.pop();
                        break;
                    default:
                        post += a;
                        break;
                }
            }

            char[] cal = post.toCharArray();
            for (char a : cal) {
                if (a >= 49 && a <= 57) {
                    cal_stack.push(a - '0');
                } else if (a == '*') {
                    int tmp = cal_stack.pop() * cal_stack.pop();
                    cal_stack.push(tmp);
                } else if (a == '+') {
                    int tmp = cal_stack.pop() + cal_stack.pop();
                    cal_stack.push(tmp);
                }

            }

            out[t] = String.format("#%d %d", t + 1, cal_stack.pop());
        }
        for (String a : out) {
            System.out.println(a);
        }

    }

    static int get_weight(char a) {
        if (a == '*') return 5;
        if (a == '+') return 3;
        if (a == '(') return 1;

        return 0;
    }
}
