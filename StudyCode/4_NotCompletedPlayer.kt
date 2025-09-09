//    문제 2. 완주하지 못한 선수
//
//    마라톤에 참여한 선수들의 이름 배열과 완주한 선수들의 배열이 주어집니다.
//    완주하지 못한 선수의 이름을 구하세요.

fun main() {
    println(solution(arrayOf("marina", "josipa", "nikola", "vinko", "filipa"), arrayOf("josipa", "filipa", "marina", "nikola")))

}

fun solution(participant: Array<String>, completion: Array<String>): String =
    participant.groupingBy { it }.eachCount().toMutableMap().apply {
        completion.forEach { it ->
            this[it] = (this[it] ?: 0) - 1
        }
    }.entries.first { it.value > 0 }.key

//fun solution(participant: Array<String>, completion: Array<String>): String {
//    val a = mutableMapOf<String, Int>()
//    for (i in participant) {
//        a[i] = 1
//    }
//
//    for (i in completion) {
//        a[i] = 0
//    }
//
//    for (i in a) {
//        if (i.value > 0) return i.key
//    }
//
//    return ""
//}
//
//fun solution(participant: Array<String>, completion: Array<String>): String {
//    val a = participant.groupingBy { it }.eachCount()
//    val b = completion.groupingBy { it }.eachCount()
//
//    return a.entries.first { (name, count) ->
//        count > (b[name] ?: 0)
//    }.key
//}
