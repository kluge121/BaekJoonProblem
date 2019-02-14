package baekjoon;


import java.util.Scanner;

public class Q1107_bruteforce {
    static boolean[] unables = new boolean[11];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int goalInt = sc.nextInt();
        String goalStr = String.valueOf(goalInt);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            unables[sc.nextInt()] = true;
        }
        int min = 0;
        int current = 100;

        //1. +-로만 이동
        min = Math.abs(goalInt - current);

        //2. 번호로만 이동 (가능할 시에)
        if (isCheck(goalStr))
            min = Math.min(min, goalStr.length());

        //3. 번호와 +-로 이동
        // 갈 수 있는 채널의 범위
        // 0 ~ 500,000
        for (int i = 0; i <= 888888; i++) {
            if (!isCheck(String.valueOf(i))) continue;
            int btnCount = String.valueOf(i).length();
            int sCount = Math.abs(i - goalInt);
            min = Math.min(min, btnCount + sCount);
        }
        System.out.println(min);

    }
    static boolean isCheck(String nStr) {
        boolean flag = true;
        for (int i = 0; i < nStr.length(); i++) {
            if (unables[nStr.charAt(i) - '0']) {
                flag = false;
                break;
            }
        }
        return flag;
    }

}
