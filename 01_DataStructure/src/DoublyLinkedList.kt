class DoublyLinkedList<T> {
    var head : Node<T>? = null
    var tail : Node<T>? = null
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
            newNode.next = this.head
            if(this.head != null) {
                this.head?.prev = newNode
            }
            head = newNode
        }
        else if (index == this.count) {
            newNode.next = null
            newNode.prev = this.tail
            this.tail?.next = newNode
        }
        else {
            var currentNode = head

            for (i in 0 until index - 1) {
                currentNode = currentNode?.next
            }

            newNode.next = currentNode?.next
            newNode.prev = currentNode
            currentNode?.next = newNode
            newNode.next?.prev = newNode

        }
        if (newNode.next == null) {
            this.tail = newNode
        }
        this.count++
    }

    fun insertLast(data:T) {
        this.insertAt(this.count, data)
    }

    fun deleteAt(index:Int) : Node<T>? {
        if (index < 0 || count < index)
            throw Error("제거할 수 없습니다")

        var deleteNode : Node<T>?

        if (index == 0) {
            deleteNode = this.head
            
            // 데이터가 하나만 들어있는 경우
            if(head?.next == null) {
                this.head?.next = null
                this.tail = null
            }
            // 여러개의 데이터가 들어있는 경우
            else {
                this.head = this.head?.next
                this.head?.prev = null
                // 이러면 더이상 원래 head 였던 데이터에 접근할 수 없기 때문에 가비지컬렉터에 의해서 메모리에서 삭제됨
            }
            
            this.head = this.head?.next
        }
        else if (index == this.count - 1) {
            deleteNode = this.tail
            this.tail?.prev?.next = null
            this.tail = this.tail?.prev
        }
        else {
            var currentNode = head

            for (i in 0 until index - 1) {
                currentNode = currentNode?.next
            }

            deleteNode = currentNode?.next
            currentNode?.next = currentNode?.next?.next
            currentNode?.next?.prev = currentNode
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