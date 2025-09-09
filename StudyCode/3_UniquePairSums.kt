//    문제) 두 개 뽑아서 더하기
//    
//    정수 배열 numbers가 주어집니다.
//    서로 다른 인덱스의 두 수를 뽑아 더해서 만들 수 있는 모든 수를 오름차순으로 return하세요.

fun main() {
    println(solution(intArrayOf(2,1,3,4,1)).toList())
    // [2+1,2+3,2+4,2+1,1+3,1+4,1+1,3+4,3+1,4+1]
    // => Set 중복 제거 후 정렬 -> [2, 3, 4, 5, 6, 7]

    println(solution(intArrayOf(5,0,2,7)).toList())
    // => [2, 5, 7, 9, 12]
}

fun solution(numbers: IntArray): IntArray =
    numbers.indices.flatMap { i ->
        (i + 1 until numbers.size).map { j ->
            numbers[i] + numbers[j]
        }
    }.toSet()
        .sorted()
        .toIntArray()
