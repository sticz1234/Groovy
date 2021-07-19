class Stack {

    static def stack

    static def del() {  def deletedValue = stack.get(0)
        stack.remove(0)
        return deletedValue}

    static def add(value) {
        return stack.add(0,value)
    }

    static void main (String[] args) {
        stack = []
        add(5)
        add(7)
        add(3)
        println(stack)
        println(del())
        println(stack)
    }
}