class Person(val name: String, occupation: String) {
  def worksAs(jobName: String): Boolean = jobName == occupation
  def speaksEnglish: Boolean = true

  def &(person: Person): String = s"${this.name} and ${person.name} are colleagues"
}

val bob = new Person("Bob", "Developer")

val alice = new Person("Alice", "Data Engineer")

println(bob.&(alice)) // точечная нотация
println(bob & alice) // инфиксная нотация