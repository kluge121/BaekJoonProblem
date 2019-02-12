package baekjoon;

import java.util.Scanner;

public class Q2839 {


    public static void main(String args[]) {

        int sugarWeight;
        Scanner sc = new Scanner(System.in);
        sugarWeight = sc.nextInt();
        if (sugarWeight < 3 || sugarWeight > 5000) {
            System.out.print("-1");
            return;
        }

        //최대수가 킬로수가 5000 따라서 봉지의 숫자는 1000개를 초과할 수 없다.
        //3보다 크기 떄문에 봉지의 최소수는 무조건
        //봉지의 범위 수 1 <= 봉지수 <= 1000
        //생각해보니 이건 별로 중요치 않는듯 but 무게는 최대 5000임 1~5000으로 무언가 반복문 돌리는건 매우매우 충분함
        //그렇다는건 이전 값들을 캐시해나가면서 하면 원하는 값 (5000이하의) 까지 봉지 구성을 찾아나간다.
        //답에서 원하는건 봉지의 숫자지 각각의 숫자가 얼마가 필요한지는 원하지 않는다.

        //+ 동전의 개수는 최대 1000개라는것을 쉽게 유추할 수 있다. = 배열 초기화 할때 유용
        int[] list = new int[sugarWeight + 1];
        //min 비교를 쉽게하기 위해 나올 수 없는 수인 1001로 초기
        for (int i = 0; i < list.length; i++) {
            list[i] = 1001;
        }

        list[3] = 1;


        //봉지수를 가장 적게 가져가는 경우는 가장 큰 봉지인 5Kg에 담을 수 있는 만큼 담아야한다. -> 기저조건으로 쓸 수 있을까?

        if (sugarWeight % 5 == 0) {
            // 5kg 봉지로 가능할 때는 가장 좋은 조건임으로 굳이 다른 작업 없이 한 번에 출력한다.
            System.out.print((sugarWeight / 5) + "");
            return;
        }

        //5kg만으로 담을 수 없을때 3,5kg를 섞는다.
        for (int i = 3; i <= sugarWeight; i++) {
            if(i-3>=0){
                list[i] = Math.min(list[i - 3] + 1, list[i]);
            }
            if(i-5>=0){
                list[i] = Math.min(list[i - 5] + 1, list[i]);
            }
        }


//        for (int i = 3; i <= sugarWeight; i++) {
//            //TODO 개선의 여지 있을거 같음 , 내부 반복문에서 굳이 모든 배열 리스트를 순환할 필요가 있을까
//            for (int j = 3; j <= i - 1; j++) {
//
//                if ((j + 3) == i) {
//                    list[i] = Math.min(list[i], list[j] + 1);
//                }
//                if ((j + 5) == i) {
//                    list[i] = Math.min(list[i], list[j] + 1);
//                }
//            }
//        }

        if (list[sugarWeight] == 1001) {
            System.out.print("-1");
        } else {
            System.out.print(list[sugarWeight]);
        }


    }


}
