import java.util.Arrays;
import java.util.Scanner;

public class Q5015RE {


    static int[][] cache = new int[101][101];
    static final int TRUE = 1;
    static final int FALSE = 0;
    static final int NONE = -1;

    static char[] w;
    static char[] s;
    static int wLength;
    static int sLength;


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int fileCount;
        w = sc.next().toCharArray();
        wLength = w.length;
        fileCount = sc.nextInt();
        String[] fileList = new String[fileCount];

        //파일리스트받음
        for (int i = 0; i < fileCount; i++) {
            fileList[i] = sc.next();
        }
        //각 파일과 와일드카드문 비교
        for (String fileName : fileList) {
            initCache();
            s = fileName.toCharArray();
            sLength = s.length;
            if (isFileNameMatching(0, 0) == TRUE) System.out.println(fileName);
        }

    }

    static int isFileNameMatching(int wp, int sp) {

        return FALSE;
    }

    static void initCache() {
        for (int i = 0; i <= 100; i++) {
            Arrays.fill(cache[i], NONE);
        }
    }
}