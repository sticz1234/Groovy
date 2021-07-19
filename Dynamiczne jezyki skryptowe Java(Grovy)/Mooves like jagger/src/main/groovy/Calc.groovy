class Calc {

    private def dispLarge
    private def dispMem

    private def ans = null
    private def buff = ""
    private def userInput = false
    private def rVal = null
    private def op = null
    private def dot = false

    private def memory

    Calc(dispLarge, dispMem) {
        this.dispLarge = dispLarge
        this.dispMem = dispMem
        this.memory = new Memory()
    }

    def getAns() {
        if (this.ans != null) {
            return ans
        } else {
            return 0
        }
    }

    def getBuff() {
        if (!buff.empty) {
            return buff
        } else {
            return "0"
        }
    }

    def updateDisplay(def val) {
        dispLarge.setText(val)
        dispMem.setText(getDispMem())
    }

    def display() {
        if (userInput) {
            updateDisplay(getBuff())
        } else {
            updateDisplay(String.valueOf(getAns()))
        }
    }

    def resetRVal() {
        op = null
        rVal = null
    }

    def nextInput(c) {
        if (rVal != null) {
            resetRVal()
        }

        userInput = true

        if (c == ".") {
            if (!dot) {
                dot = true
            } else {
                display()
                return
            }
        } else if (c == "0") {
            if (buff == "") {
                buff = "0"
                display()
                return
            }
        }

        if (buff == "0") {
            buff = c
        } else {
            buff += c
        }

        display()
    }

    def getInputVal() {
        Double.parseDouble(buff)
    }

    def endInput() {
        userInput = false
        if (!buff.empty) {
            setVal(getInputVal())
            buff = ""
        }
    }

    def setVal(val) {
        if (op == null) {
            ans = val
        } else {
            rVal = val
        }
    }

    def setAns(val) {
        ans = val
    }

    def c() {
        reset()
    }

    private void reset() {
        dot = false
        op = null
        buff = ""
        setAns(null)
        rVal = null
        userInput = false
        display()
    }

    def operator(o) {
        equals()

        rVal = null
        endInput()

        op = o

        display()

    }

    def eq() {
        equals()
    }

    private void equals() {
        endInput()

        if (rVal == null) {
            rVal = ans
        }

        switch (op) {
            case "+":
                setAns(getAns() + rVal)
                break
            case "-":
                setAns(getAns() - rVal)
                break
            case "/":
                if (rVal == 0) {
                    println("Cannot divide by zero")
                    System.exit(1)
                }
                setAns(getAns() / rVal)
                break
            case "*":
                setAns(getAns() * rVal)
                break
        }

        display()
    }


    def memClear() {
        memory.clear()
        display()
    }

    def memRecall() {
        if(op != null) {
            rVal = memory.value
            buff = String.valueOf(rVal)
            userInput = true

        } else {
            setAns(memory.value)
        }
        display()
        endInput()
    }

    def memPlus() {
        endInput()
        setAns(memory.memPlus(getAns()))
        display()
    }

    def memMinus() {
        endInput()
        setAns(memory.memMinus(getAns()))
        display()
    }

    def ce() {
        memory.clear()
        reset()
    }

    def oneOverX() {
        endInput()
        if (rVal != null) {
            rVal = 1.0 / rVal
        } else {
            setAns(1.0 / getAns())
        }
        display()
    }

    def xSquared() {
        endInput()
        if (rVal != null) {
            rVal = Math.pow(rVal, 2)
        } else {
            setAns(Math.pow(getAns(), 2))
        }
        display()
    }

    def squareRoot() {
        endInput()
        if (rVal != null) {
            rVal = Math.sqrt(rVal)
        } else {
            setAns(Math.sqrt(getAns()))
        }
        display()
    }

    def sign() {
        endInput()
        if (rVal != null) {
            rVal = -rVal
        } else {
            setAns(-getAns())
        }
        display()
    }

    def getDispMem() {
        memory.isMem() ? "M" : ""
    }
}
