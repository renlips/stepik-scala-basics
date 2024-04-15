/* Лямбда-функции */

val result = (x: Int, y: Int) => x * y

println(result(1, 2)) // 2
//1 Class
class Multiplication {
  def multiply(x: Int, y: Int): Int = x * y
}
//2 Trait
trait Multiplication[A, B, C] {
  def multiply(x: A, y: B): C
}

val result1 = new Multiplication[Int, Int, Int] {
  override def multiply(x: Int, y: Int): Int = x * y
}

val result2 = new Multiplication[Int, Double, Double] {
  override def multiply(x: Int, y: Double): Double = x * y
}

println(result2.multiply(1, 2.5))
//3 apply
trait Multiplication[A, B, C] {
  def apply(x: A, y: B): C
}

val result = new Multiplication[Int, Double, Double] {
  override def apply(x: Int, y: Double): Double = x * y
}

println(result(1, 2.5))
//4 Func0 1 2 .. 22
val result = new Function2[Int, Double, Double] {
  override def apply(x: Int, y: Double): Double = x * y
}

println(result(1, 2.5))

//5 Synt sugar
val result = new((Int, Double) => Double) {
  override def apply(x: Int, y: Double): Double = x * y
}

println(result(1, 2.5))

val sum = (a, b, c) => a + b + c
//
//var sum = (a: Int, b: Int, c: Int) => a + b + c
//
//val sum: (Int, Int, Int) => Int = (a, b, c) => a + b + c
//
//val sum = (a: Int, b: Int, c: Int) => a + b + c
//
//val sum: (Int, Int, Int => Int) = (a, b, c) => a + b + c