import java.util.*

object Q1009Kotlin {
    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val caseCount = sc.nextInt()
        val caseList = Array(caseCount) { IntArray(2) }
        for (i in 0 until caseCount) {
            caseList[i][0] = sc.nextInt()
            caseList[i][1] = sc.nextInt()
        }
        for(i in 0 until caseCount){
            search(caseList[i][0], caseList[i][1])
        }
    }
    fun search(a: Int, b: Int) {
        val cb = b % 10;
        val count = Math.pow(a.toDouble(), cb.toDouble());
        System.out.println((count.toInt() % 10))
    }
}

