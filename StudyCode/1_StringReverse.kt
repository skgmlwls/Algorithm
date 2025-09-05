import java.util.Scanner

fun main(){
    val scanner = Scanner(System.`in`)

    // 1) 문자열 뒤집기
    println("문자열 입력 : ")
    val text = scanner.nextLine()
    println(solution1(text))
    println(solution2(text))

}

fun solution1(s: String): String {
    val strList = mutableListOf<String>()

    for(i in s.length-1 downTo 0) {
        strList.add(s[i].toString())
    }

    return strList.joinToString("")
}
fun solution2(s: String): String = s.reversed()
