import java.util.Arrays;

public class Test {


    public static void main(String[] args) {

        int [] array = {0,1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(array));
        System.arraycopy(array, 1, array, 0, 7);
        System.out.println(Arrays.toString(array));

    }
}
