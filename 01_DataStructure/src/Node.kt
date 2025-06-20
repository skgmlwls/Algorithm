class Node<T> (
    val data : T,
    var next : Node<T>? = null,
    var prev : Node<T>? = null  // 이중 연결리스트를 위해 추가
)