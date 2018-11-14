object Test {


    var a : Int? = null;

    @JvmStatic
    fun main(args: Array<String>) {


        for (i in 1..50) {
            for (j in 1..50) {
             System.out.print("1")
            }
            System.out.println()
        }




        val YES = true
        if(YES or YES) print("지옥")
        else print("편안")
        /////////////////////////
        if(YES) print("지옥")
        /////////////////////////
        print("지옥")
    }
}
