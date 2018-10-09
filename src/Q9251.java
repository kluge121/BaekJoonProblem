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

        // 두 개의 배열에서 부분 수열을 만드려면 먼저 같은게 뭐가 있는지는 알아야 하지 않을까?
        // 탐색 시간 1000자 * 1000자 = 1,000,000, 불가능할거 같지는 않긴 한데. 좋은 생각은 아닌거 같다.
        // 두 문자열을 둘 다 입력받고 거기서부터 하나씩 비교?
        // 메모이이션을 어떻게 할 것인가?

        int result = search(0, 0);
        System.out.println(result);
    }

    static int search(int sp1, int sp2) {

        if (sp1 == s1.length) return 0;
        if (sp2 == s2.length) return 0;
        if (cache[sp1][sp2] != -1) {
            System.out.println("caching hit");
            return cache[sp1][sp2];
        }
        int value1;
        int value2;
        int value3;

        if (s1[sp1] == s2[sp2])
            value1 = 1 + search(sp1 + 1, sp2 + 1);
        else
            value1 = search(sp1 + 1, sp2 + 1);

        value2 = search(sp1, sp2 + 1);
        value3 = search(sp1 + 1, sp2);

        return cache[sp1][sp2] = Math.max(value1, Math.max(value2, value3));


    }
}