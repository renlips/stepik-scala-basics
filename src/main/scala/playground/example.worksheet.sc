val link = "https://stepik.org"

println(s"The link is \t $link")
println(raw"The link is \t $link")
//println(link :+ '/catalog')
println(s"The link is link")
println(link :++ "/catalog")
println(s"The link is $link.toUpperCase")
//println(s"The link is $linc")
println(s"The link is ${link.toUpperCase}")


val someVal = print("It is just a value")
print(someVal)

  def callByValue(x: Long): Unit = {
    println(s"call by value: x1 = $x")
    println(s"call by value: x2 = $x")
  }

  def callByName(x: => Long): Unit = {
    println(s"call by name: x1 = $x")
    println(s"call by name: x2 = $x")
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())

  def someFunc(): Int = 2 * someFunc() + 1
  def callSomeFunc(x: Int, y: => Int) = println(x)

  callSomeFunc(1, someFunc()) 

var i = 0
while (i < 3) {
  println("hello")
  i += 1
}

// import scala.annotation.tailrec

// def powerOfTwo(n: Int): Int = {
//   @tailrec
//   def loop(x: Int, acc: Int = 1): Int = {
//     if
//   }
// }

def powerOfTwo(n: Int): BigInt = {
  if (n == 0) {
    1
  } else {
    2 * powerOfTwo(n -1)
  }
}

powerOfTwo(9)