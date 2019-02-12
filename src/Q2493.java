import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q2493 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input, " ");

        int i = 1;
        int[] map = new int[n + 1];
        Stack<Value> stack = new Stack<>();
        while (st.hasMoreTokens()) {
            int value = Integer.parseInt(st.nextToken());
            if (stack.isEmpty()) {
                System.out.print(0 + " ");
            } else if (stack.peek().value > value) {
                System.out.print(stack.peek().index + " ");
            } else if (stack.peek().value < value) {
                while (!stack.isEmpty() && stack.peek().value < value) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    System.out.print(0 + " ");
                } else if (stack.peek().value == value) {
                    System.out.print(stack.pop().index + " ");
                } else if (stack.peek().value > value) {
                    System.out.print(stack.peek().index + " ");
                }

            }
            stack.push(new Value(value, i));
            i++;
        }


    }

    static class Value {
        int value;
        int index;

        public Value(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
