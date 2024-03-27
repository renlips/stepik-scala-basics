package lectures.week1basics

object Functions extends App {
  def aPerson(name: String, surname: String): Unit = println(s"$name $surname")

  aPerson("John" , "Smith")
}
