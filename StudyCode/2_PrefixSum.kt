//    2) 배열의 합
//    설명: 정수 배열의 모든 원소 합을 반환하세요. 함수:
//
//    fun solution(arr: IntArray): Int
//    예시 입력: [1,2,3,4] → 출력: 10

fun main(){
    println(solution(intArrayOf(1,2,3,4)))
    println(solution2(intArrayOf(1,2,3,4)))
}

fun solution(arr: IntArray): Int = arr.sum()
fun solution2(arr: IntArray): Int {
    var s = 0
    for (i in arr) {
        s += i
    }
    return s
}
