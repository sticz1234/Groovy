class Memory {
    def value
    def mem

    Memory() {
        value = 0.0
        mem = false
    }

    def clear() {
        mem = false
        value = 0.0
    }

    def memMinus(def val) {
        mem = true
        value -= val
    }

    def memPlus(def val) {
        mem = true
        value += val
    }

    def isMem() {
        return mem
    }
}
