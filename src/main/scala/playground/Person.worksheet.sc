//class Person(val name: String) {
//  def unary_+ : Person = new Person(name + " NoSurname")
//
//}
//
//val person = new Person("Bob")
//
//println((+person).name)

object A {
  val a: String = "value a"
  println("object A")
}

val aVal = A


println(aVal.a)
