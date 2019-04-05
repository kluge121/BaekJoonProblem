package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Q4366 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        String[] out = new String[T];
        for (int t = 0; t < T; t++) {
            ArrayList<Integer> list2 = new ArrayList<>();
            ArrayList<Integer> list3 = new ArrayList<>();
            int a = goDec(br.readLine(), 2);
            String b = br.readLine();
            int aCount = getDigit(a);
            int bCount = b.length();
            for (int i = 0; i < aCount-1; i++) {
                int value1 = bitToggle(a, i);
                list2.add(value1);
            }
            for (int j = 0; j < bCount; j++) {
                for (int k = 0; k < 3; k++) {
                    if (j == 0 && k == 0) continue;
                    String tmp = "";
                    tmp += b.substring(0, j);
                    tmp += k;
                    tmp += b.substring(j + 1);

                    int value2 = goDec(tmp, 3);
                    list3.add(value2);
                }
            }
            boolean flag = false;
            for (int v1 : list2) {
                for(int v2 : list3){
                    if(v1==v2){
                        out[t]=String.format("#%d %d",t+1,v1);
                        flag= true;
                        break;
                    }
                }
                if(flag)break;
            }
        }
        for (String a : out) {
            System.out.println(a);
        }
    }


    static int bitToggle(int value, int i) {
        int shift = 1 << i;
        return value ^ shift;
    }

    static int goDec(String strValue, int n) {

        int tmp = 1;
        int sum = 0;
        for (int i = strValue.length() - 1; i >= 0; i--) {
            int value = Integer.parseInt(strValue.charAt(i) + "");
            sum += (tmp * value);
            tmp *= n;
        }
        return sum;
    }

    static int getDigit(int value) {
        int count = 0;
        int tmp = value;
        while (true) {
            tmp /= 2;
            if (tmp > 0) count++;
            else break;
        }
        return count + 1;
    }


}
