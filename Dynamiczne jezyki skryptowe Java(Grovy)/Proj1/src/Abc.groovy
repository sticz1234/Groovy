def findFactorial = {
    n -> (n == 1) ? 1 : n * call(n - 1)

}
println("Zadanie 1")
println findFactorial(4)

// B
def fibonacci={int n->
    def a = 0, b= 1
    n.times{ // times is used to for looping n times
        (a,b) = [b,a+b]
    }
    print(a)
}
println("Zadanie 2")
fibonacci(10)

// C
def findPrimesBetween = { first = 0, last = 100 ->
    def q = { a, b ->
        def c = 1
        for(d in a){
            if(b % d == 0){
                c = 0
                break
            }
        }
        if(c)
            a.add b
    }

    def a=[]
    (2..(Math.ceil(Math.sqrt(last)).toInteger())).each{ b ->
        q(a,b)
    }
    (first..last).each{ b ->
        q(a,b)
    }
    a.findAll{it > first}
}
println("""  """)
println("Zadanie 3")
print findPrimesBetween(0, 12)

//D, a
def fib(n){
    a=0
    b=1
    while (b < n ){
        t=a
        a=b
        b = a+t
        println a
    }
}
println("""  """)
println("Zadanie 4a")
fib(100)

//D, ba
println("Zadanie 4b")



def fibo(n){
    lista = []
    a=0
    b=1
    while (b < n ){
        t=a
        a=b
        b = a+t
        lista.add(a)

    }
    return lista
}

Fibon = fibo(100)
primes = findPrimesBetween(0, 100)
println("Przed usunięciem")
println(Fibon)
println(primes)
Fibon.removeAll(primes as Object[])
println("Po usunięciu")
println(Fibon)
