class DoublyLinkedList_Test<T> {
    var head : Node<T>? = null
    var count = 0

    fun printAll() {
        var currentNode = head

        var text = "["

        while (currentNode != null) {
            text += currentNode.data
            currentNode = currentNode.next

            if (currentNode != null) {
                text += ", "
            }
        }

        text += "]"

        println(text)
    }

    fun insertAt(index : Int, data : T) {
        if (index < 0  || count < index) {
            throw IndexOutOfBoundsException("범위 넘어감")
        }

        var newNode = Node(data)

        if (index == 0) {
            newNode.next = head
            head = newNode
        }
        else {
            var currentNode = head

            for (i in 0 until index - 1) {
                currentNode = currentNode?.next
            }

            newNode.next = currentNode?.next
            currentNode?.next = newNode

        }
        count++
    }

    fun insertLast(data:T) {
        this.insertAt(this.count, data)
    }

    fun deleteAt(index:Int) : Node<T>? {
        if (index < 0 || count < index)
            throw Error("제거할 수 없습니다")

        var deleteNode : Node<T>?

        if (index == 0) {
            deleteNode = head
            head = head?.next
        }
        else {
            var currentNode = head

            for (i in 0 until index - 1) {
                currentNode = currentNode?.next
            }

            deleteNode = currentNode?.next
            currentNode?.next = currentNode?.next?.next
        }

        count--

        return deleteNode

    }


    fun deleteLast() {
        this.deleteAt(this.count - 1)
    }

    fun getNodeAt(index : Int) : Node<T>? {
        if(index < 0 || this.count < index) {
            throw Error("범위를 넘어감")
        }

        var currentNode = head

        for (i in 0 until index) {
            currentNode = currentNode?.next
        }

        return currentNode

    }



}