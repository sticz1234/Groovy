class Listy {

    static void main(String[] args) {
        list listunia = new list()
        for (int i in 3..13) {
            listunia.insertEnd(i)
        }
        listunia.insertAt(4, -4)
        listunia.print()
        listunia.insertStart(13)
        listunia.print()
        listunia.insertStart(-16)
        listunia.print()
        listunia.DelStart()
        listunia.print()
        listunia.DelEnd()
        listunia.DelEnd()
        listunia.print()
        listunia.DelAt(3)
        listunia.print()
        listunia.print()
        listunia.changeToCyclic()
    }

}
class element {

    int value
    element next
    element before

    element(int val) {
        this.value = val
        this.before = null
        this.next = null
    }

    void print() {
        print('V: ' + value)
    }

}
class list {

    element first = null
    element last = null
    void DelStart() {
        if (this.first != null) {
            this.first = this.first.next
        }
    }
    void DelEnd() {
        if (this.last != null) {
            element currentEl = this.last
            this.last = currentEl.before
            currentEl.before.next = null
        }
    }
    void DelAt(int index) {
        try {
            int i = 0
            element currentEl = this.first
            while (i < index)
            {
                currentEl = currentEl.next
                i++
            }
            element next = currentEl.next
            element before = currentEl.before
            currentEl.before.next = next
            currentEl.next.before = before
        }
        catch (Exception e) {
            println(e)
        }
    }
    void insertStart(int val) {
        element newEl = new element(val)
        newEl.next = this.first
        if (this.first != null) {
            this.first.before = newEl
        }
        this.first = newEl
    }

    void insertAt(int index, int val) {
        int i = 0
        try {
            element currentEl = this.first
            while (i < index)
            {
                currentEl = currentEl.next
                i++
            }
            element newEl = new element(val)
            newEl.next = currentEl.next
            currentEl.next.before = newEl
            currentEl.next = newEl
            newEl.before = currentEl
        }
        catch (Exception ex) {
            println(ex)
        }
    }
    void insertEnd(int val) {
        if (this.first != null) {
            element currentEl = this.first
            while (currentEl.next != null)
            {
                currentEl = currentEl.next
            }
            element newEl = new element(val)
            currentEl.next = newEl
            newEl.before = currentEl
            this.last = newEl
        }
        else
        {
            element el = new element(val)
            this.first = el
            this.last = this.first
        }
    }

    void print() {
        println()
        if (this.first != null) {
            element currentEl = this.first
            while (currentEl.next != null)
            {
                currentEl.print()
                print("\t")
                currentEl = currentEl.next
            }
            currentEl.print()
            print("\t")
        }
    }

    void changeToCyclic() {
        this.first.before = this.last
        this.last.next = this.first
    }

}