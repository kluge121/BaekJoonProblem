package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1107_solve {

    public static void main(String[] args) throws IOException {

        boolean[] unables = new boolean[11];
        unables[10] = true;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String goalStr = br.readLine();
        int goalInt = Integer.parseInt(goalStr);
        char[] goalArr = goalStr.toCharArray();
        int n = Integer.parseInt(br.readLine());
        if (n > 0) {
            String[] line = br.readLine().split(" ");
            for (String a : line) {
                unables[Integer.parseInt(a)] = true;
            }
        }
        int current = 100;
        //목표채널이 시작채널과 같을 시
        if (Integer.parseInt(goalStr) == current) {
            System.out.println(0);
            return;
        }
        //모든 숫자버튼을 사용할 수 없을 시
        if (n == 10) {
            System.out.println(Math.abs(goalInt - 100));
            return;
        }


        //목표채널 가는데 숫자버튼보다  + / - 로 가는게 더 빠를 때 97~103 채널 범위
        if (Math.abs(goalInt - current) <= 3) {
            System.out.println(goalInt - current);
            return;
        }
        //목표채널을 가는데 사용할 수 있는 버튼이 전부 동작할 때
        for (int i = 0; i < goalArr.length; i++) {
            if (unables[goalArr[i] - '0']) {
                break;
            } else if (i == goalArr.length - 1) {
                System.out.println(i + 1);
                return;
            }
        }
        //몇몇 버튼이 동작하지 않을 때 목표와 가장 가까운 채널-번호를 찾는다.
        //sideFlag  가장 처음만나는 사용할 수 없는 번호 일시 , 0=아직못찾음  , 1=0과 가까움 , 2=9와 가까움
        String tmpGoal = "";
        int sideFlag = 0;
        //일부 버튼을 사용할 수 없을 시
        for (char a : goalArr) {
            int num = a - '0';

            //해당 자리의 수 버튼이 동작할 때
            if (!unables[num]) {
                tmpGoal = tmpGoal + num;
                continue;
            }
            //해당 자리의 수 버튼이 동작하지 않을 때
            for (int i = 1; ; i++) {
                if ((num - i) >= 0 && !unables[num - i]) {
                    if (sideFlag == 0) {
                        tmpGoal = tmpGoal + (num - i);
                        sideFlag = 1;
                        break;
                    } else if (sideFlag == 2) {
                        tmpGoal = tmpGoal + (num - i);
                        break;
                    }
                }
                if ((num + i) <= 9 && !unables[num + i]) {
                    if (sideFlag == 0) {
                        tmpGoal = tmpGoal + (num + i);
                        sideFlag = 2;
                        break;
                    } else if (sideFlag == 1) {
                        tmpGoal = tmpGoal + (num + i);
                        break;
                    }

                }
                if (sideFlag == 1 && ((num - i) >= 0 && !unables[num - i])) {
                    tmpGoal = tmpGoal + (num - i);
                    break;
                }
                if (sideFlag == 2 && ((num + i) <= 9 && !unables[num + i])) {
                    tmpGoal = tmpGoal + (num + i);
                    break;
                }


            }


        }

        //tmpGoal 완성
        System.out.println(tmpGoal.length() + Math.abs(goalInt - Integer.parseInt(tmpGoal)));

    }
}
