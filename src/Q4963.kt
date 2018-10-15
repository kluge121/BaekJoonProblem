import java.util.*
import kotlin.collections.ArrayList

object Q4963 {


    val IMPOSSIBLE = -1
    val POSSIBLE = 1
    val NONE = 0;


    var cache = Array(50) { IntArray(50) }
    var mX = 0;
    var mY = 0;


    @JvmStatic
    fun main(args: Array<String>) {
        val caseList = ArrayList<Case>()
        val sc = Scanner(System.`in`)

        while (true) {
            val tmpCase = Case()
            tmpCase.x = sc.nextInt()
            tmpCase.y = sc.nextInt()
            tmpCase.map = Array(tmpCase.x) { IntArray(tmpCase.y) }
            if (tmpCase.x == 0 && tmpCase.y == 0)
                break
            for (i in 0 until tmpCase.y) {
                for (j in 0 until tmpCase.x) {
                    tmpCase.map!![i][j] = sc.nextInt()
                }
            }
        }

        for (case in caseList) {
            mX = case.x
            mY = case.y
        }


    }


    fun search(x: Int, y: Int) {

        // 움직일 수 있는 8가지 방향!
        // x+1 y
        // x-1 y

        // x y+1
        // x y-1

        // x+1 y+1
        // x+1 y-1

        // x-1 y+1
        // x-1 y-1

        if (cache[x][y] != NONE)
            return
        //시작은 각 경로를 탐색하자

        if (isMove(x + 1, y)) {
            cache[x + 1][y] = 1
            search(x + 1, y)
        } else {
            cache[x + 1][y] = 0;
        }
        if (isMove(x - 1, y)) search(x - 1, y)
        if (isMove(x, y + 1)) search(x, y + 1)
        if (isMove(x, y - 1)) search(x, y - 1)
        if (isMove(x + 1, y + 1)) search(x + 1, y + 1)
        if (isMove(x + 1, y - 1)) search(x + 1, y - 1)
        if (isMove(x - 1, y + 1)) search(x - 1, y + 1)
        if (isMove(x - 1, y - 1)) search(x - 1, y - 1)


    }


    fun isMove(x: Int, y: Int): Boolean {
        return (x <= mX && y <= mY)
    }

}


data class Case(
        var map: Array<IntArray>? = null,
        var x: Int = 0,
        var y: Int = 0

) {}
