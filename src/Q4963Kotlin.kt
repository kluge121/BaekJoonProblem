import java.util.*
import kotlin.collections.ArrayList

object Q4963Kotlin {

    val VISIT = 1
    val NONE = 0;
    val ISLAND = 1;

    var cache = Array(51) { IntArray(51) }
    var mX = 0;//너비
    var mY = 0;//높이
    lateinit var mMap: Array<IntArray>

    @JvmStatic
    fun main(args: Array<String>) {
        val caseList = ArrayList<Case>()
        val sc = Scanner(System.`in`)

        while (true) {
            val tmpCase = Case()
            tmpCase.x = sc.nextInt()
            tmpCase.y = sc.nextInt()
            tmpCase.map = Array(tmpCase.x + 1) { IntArray(tmpCase.y + 1) }
            if (tmpCase.x == 0 && tmpCase.y == 0)
                break

            //지도 입력순서는 x축 먼저 입력되고 y축 이동
            for (i in 1..tmpCase.y) {
                for (j in 1..tmpCase.x) {
                    tmpCase.map!![j][i] = sc.nextInt()
                }
            }
            caseList.add(tmpCase)
        }

        //테스트 케이스 하나씩 가져와서 실행
        for (case in caseList) {

            //방문기록 초기화
            mMapInit()
            var count = 0;

            //전역변수 초기화
            mX = case.x
            mY = case.y
            mMap = case.map!!

            // 육지만 탐색 시작
            for (i in 1..mX) {
                for (j in 1..mY) {
                    if (cache[i][j] == NONE && case.map!![i][j] == ISLAND) {
                        search(i, j)
                        count++
                    }
                }
            }
            System.out.println(count)
        }

    }

    fun search(x: Int, y: Int) {

        if (cache[x][y] == VISIT) return

        //8방향 탐색
        for (i in -1..1) {
            for (j in -1..1) {
                if (i == 0 && j == 0) continue
                if (isMove(x + i, y + j) && mMap[x + i][y + j] == ISLAND) {
                    cache[x][y] = VISIT
                    search(x + i, y + j)
                }
            }
        }
        return
    }

    private fun isMove(x: Int, y: Int): Boolean {
        return (x >= 0 && y >= 0 && x <= mX && y <= mY)
    }

    fun mMapInit() {
        for (i in 0..50) {
            Arrays.fill(cache[i], NONE)
        }

    }
}

data class Case(
        var map: Array<IntArray>? = null,
        var x: Int = 0,
        var y: Int = 0

)
