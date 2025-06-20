import org.w3c.dom.Node

fun main() {

    // LinkedList 테스트
    // linkedList_Test()

    // Stack 테스트
    stack_Test()

}

fun linkedList_Test() {
    val node1 = Node(1)
    val node2 = Node(2)
    val node3 = Node(3)

    node1.next = node2
    node2.next = node3

    println(node1.data)
    println(node1.next?.data)
    println(node1.next?.next?.data)

    println("========== Insert List =========")

    val list = LinkedList<Int>()
    list.insertAt(0, 10)
    list.insertAt(1, 20)
    list.insertAt(2, 30)
    list.insertAt(3, 40)
    list.printAll()

    println("========== Insert List ==========")

    list.insertAt(2, 25)
    list.printAll()

    println("========== Insert Last ==========")

    list.insertLast(50)
    list.printAll()

    println("========== Delete List ==========")

    list.deleteAt(2)
    list.printAll()
}

fun stack_Test() {

    var stack = Stack<Int>()

    println("========== 첫 번째 출력 ==========")
    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.push(4)
    println(stack.pop()?.data)
    println(stack.pop()?.data)
    println(stack.pop()?.data)
    println(stack.pop()?.data)

    println("========== 두 번째 출력 ==========")
    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.push(4)
    println(stack.peek()?.data)
    stack.pop()
    println(stack.peek()?.data)
    println("isEmpty : ${stack.isEmpty()}")
    stack.pop()
    stack.pop()
    stack.pop()
    println("isEmpty : ${stack.isEmpty()}")
    // test
}