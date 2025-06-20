class Stack<T> {
    var list = LinkedList<T>()

    fun push(data: T) {
        list.insertAt(0, data)
    }

    fun pop(): Node<T>? {
        return try {
            list.deleteAt(0)
        } catch (e: Exception) {
            null
        }
    }

    fun peek(): Node<T>? {
        return list.getNodeAt(0)
    }

    fun isEmpty(): Boolean {
        return list.count == 0
    }

}
