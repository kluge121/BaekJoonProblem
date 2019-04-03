package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q3378 {

    static MinStack stack1;
    static MinStack stack2;
    static MinStack stack3;

    static int R1, C2, S3;
    static int myLineLength;
    static int masterLineLength;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] out = new String[T];


        for (int t = 0; t < T; t++) {
            StringBuilder answer = new StringBuilder(String.format("#%d ", +t + 1));
            String[] b = br.readLine().split(" ");
            masterLineLength = Integer.parseInt(b[0]);
            myLineLength = Integer.parseInt(b[1]);

            stack1 = new MinStack();
            stack2 = new MinStack();
            stack3 = new MinStack();

            R1 = -1;
            C2 = -1;
            S3 = -1;
            for (int i = 0; i < masterLineLength; i++) {
                int count = 0;
                boolean flag = true;
                char[] a = br.readLine().toCharArray();

                Queue<Character> q1 = new LinkedList<>();
                Queue<Character> q2 = new LinkedList<>();
                Queue<Character> q3 = new LinkedList<>();

                for (char c : a) {
                    if (flag && c == '.') {
                        count++;
                    } else {
                        if (c == '(' || c == ')') {
                            q1.offer(c);
                        } else if (c == '{' || c == '}') {
                            q2.offer(c);
                        } else if (c == '[' || c == ']') {
                            q3.offer(c);
                        }
                        flag = false;
                    }
                }
                if (count > 0) {
                    //괄호가 한줄에 1개만 있고 2개 비었을 때
                    if (R1 == -1 && stack1.size() > 0 && stack2.isEmpty() && stack3.isEmpty()) {
                        R1 = count / stack1.size();
                    }
                    if (C2 == -1 && stack2.size() > 0 && stack1.isEmpty() && stack3.isEmpty()) {
                        C2 = count / stack2.size();
                    }
                    if (S3 == -1 && stack3.size() > 0 && stack1.isEmpty() && stack2.isEmpty()) {
                        S3 = count / stack3.size();
                    }

                    //1개의 괄호의 정체를 알았고  1개는 모르고 한줄에 한개의 괄호가 있을 때
                    if (C2 == -1 && R1 > -1 && stack3.isEmpty() && stack2.size() > 0) {
                        C2 = (count - (stack1.size() * R1)) / stack2.size();
                    }
                    if (S3 == -1 && R1 > -1 && stack2.isEmpty() && stack3.size() > 0) {
                        S3 = (count - (stack1.size() * R1)) / stack3.size();
                    }
                    if (S3 == -1 && C2 > -1 && stack1.isEmpty() && stack3.size() > 0) {
                        S3 = (count - (stack2.size() * C2)) / stack3.size();
                    }
                    if (R1 == -1 && C2 > -1 && stack3.isEmpty() && stack1.size() > 0) {
                        R1 = (count - (stack2.size() * C2)) / stack1.size();
                    }
                    if (C2 == -1 && S3 > -1 && stack1.isEmpty() && stack2.size() > 0) {
                        C2 = (count - (stack3.size() * C2)) / stack2.size();
                    }
                    if (R1 == -1 && S3 > -1 && stack2.isEmpty() && stack1.size() > 0) {
                        R1 = (count - (stack3.size() * C2)) / stack1.size();
                    }
                    //2개를 알고 나머지 1개를 모를 때
                    if (S3 == -1 && R1 > -1 && C2 > -1 && stack3.size() > 0) {
                        S3 = (count - ((R1 / stack1.size()) + (C2 / stack2.size()))) / stack3.size();
                    }
                    if (C2 == -1 && R1 > -1 && S3 > -1 && stack2.size() > 0) {
                        C2 = (count - ((R1 / stack1.size()) + (S3 / stack3.size()))) / stack2.size();
                    }
                    if (R1 == -1 && C2 > -1 && S3 > -1 && stack1.size() > 0) {
                        R1 = (count - ((C2 / stack2.size()) + (S3 / stack3.size()))) / stack1.size();
                    }

                }
                while (!q1.isEmpty()) stack1.push(q1.poll());
                while (!q2.isEmpty()) stack2.push(q2.poll());
                while (!q3.isEmpty()) stack3.push(q3.poll());

            }


            stack1 = new MinStack();
            stack2 = new MinStack();
            stack3 = new MinStack();


            for (int i = 0; i < myLineLength; i++) {
                char[] a = br.readLine().toCharArray();
                Queue<Character> q1 = new LinkedList<>();
                Queue<Character> q2 = new LinkedList<>();
                Queue<Character> q3 = new LinkedList<>();

                for (char c : a) {
                    if (c == '(' || c == ')') {
                        q1.offer(c);
                    } else if (c == '{' || c == '}') {
                        q2.offer(c);
                    } else if (c == '[' || c == ']') {
                        q3.offer(c);
                    }
                }

                int count = 0;

                if (R1 != -1 && stack1.size() > 0) {
                    count += (R1 * stack1.size());
                } else if (R1 == -1) {
                    answer.append("-1 ");
                    continue;
                }

                if (C2 != -1 && stack2.size() > 0) {
                    count += (C2 * stack2.size());
                } else if (C2 == -1) {
                    answer.append("-1 ");
                    continue;
                }

                if (S3 != -1 && stack3.size() > 0) {
                    count += (S3 * stack3.size());
                } else if (S3 == -1) {
                    answer.append("-1 ");
                }
                answer.append(count + " ");
                while (!q1.isEmpty()) stack1.push(q1.poll());
                while (!q2.isEmpty()) stack2.push(q2.poll());
                while (!q3.isEmpty()) stack3.push(q3.poll());
            }
            out[t] = answer.toString();
        }

        for (String a : out) {
            System.out.println(a);
        }

    }


    static class MinStack {
        private Stack<Character> stack;

        public MinStack() {
            stack = new Stack<>();
        }

        void push(char a) {
            if (a == '}' || a == ']' || a == ')') {
                stack.pop();
            } else {
                stack.push(a);
            }
        }

        int size() {
            return stack.size();
        }

        boolean isEmpty() {
            return stack.size() == 0;
        }
    }
}
