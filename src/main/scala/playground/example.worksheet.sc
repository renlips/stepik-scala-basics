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

// powerOfTwo(9)


//////   Classes    \\\\\\

class Instructor(val id: Int, name: String, surname: String) {
  def fullName(): String = {
    s"${name.capitalize} ${surname.capitalize}"
  }
}

class Course(courseID: Int, title: String, val releaseYear: String, instructor: Instructor) {
  def getID(): String = {
    s"$courseID${instructor.id}"
  }

  def isTaughtBy(isInstructor: Instructor): Boolean = {
    instructor.id == isInstructor.id
  }

  def copyCourse(newReleaseYear: String): Course = new Course(courseID, title, newReleaseYear, instructor)
}



val instuctor1 = new Instructor(1, "jIM", "Beam")
println(instuctor1.fullName())
val instuctor2 = new Instructor(2, "garry", "ham")
println(instuctor2.fullName())

val math101 = new Course(101, "math", "2020", instuctor1)
math101.getID()
math101.isTaughtBy(instuctor1)
math101.isTaughtBy(instuctor2)
math101.copyCourse("2024").releaseYear