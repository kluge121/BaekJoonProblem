import java.util.Scanner;

class Q11718 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String tmp;
        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (sc.hasNextLine()) {
            tmp = sc.nextLine();
            i++;
            if (tmp.isEmpty() && i != 99) {
                break;
            }
            sb.append(tmp).append("\n");

            if(i == 100){
                break;
            }

        }
        sb.deleteCharAt(sb.lastIndexOf("\n"));
        System.out.print(sb);
        sc.close();
    }


}