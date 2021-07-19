static void main(String[] args) {

    def isOdd = (number -> number %2 == 0)

def collatz = {number -> {
     if (number > 1) {
         if (isOdd(number)) {
             return number / 2
         } else {
         return (number*3) +1
         }
         }
     }

    }


int First = 17

while (First != 1) {
    println(First)
    println First.getClass().getName()
    First = collatz(First) as int


}
    println(First)
}