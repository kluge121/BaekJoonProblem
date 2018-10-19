package solve;

import java.util.Arrays;
import java.util.Scanner;

public class Q9251 {
    static char[] s1, s2;
    static int[][] cache;

    public static void main(String args[]) {
        //알파벳 대문자로만 이루어짐.
        //문자는 최대 1000자
        Scanner sc = new Scanner(System.in);
        s1 = sc.next().toCharArray();
        s2 = sc.next().toCharArray();
        cache = new int[s1.length][s2.length];

        for (int i = 0; i < s1.length; i++) {
            Arrays.fill(cache[i], -1);
        }

        //재귀 첫 호출
        int result = search(0, 0);
        System.out.println(result);
    }

    static int search(int sp1, int sp2) {

        // 재귀의 종료조건을 맨 처음 기술
        // 각 문자열의 끝인지 확인
        if (sp1 == s1.length) return 0;
        if (sp2 == s2.length) return 0;

        //메모이제이션 체크
        if (cache[sp1][sp2] != -1) {
            //System.out.println("caching hit");
            return cache[sp1][sp2];
        }

        int value1;
        int value2;
        int value3;

        //문자열이 같을 때
        if (s1[sp1] == s2[sp2])
            value1 = 1 + search(sp1 + 1, sp2 + 1);
        else
            value1 = -1;

        //그 외의 경우
        value2 = search(sp1, sp2 + 1);
        value3 = search(sp1 + 1, sp2);

        // 최대 값을 리턴
        return cache[sp1][sp2] = Math.max(value1, Math.max(value2, value3));


    }
}