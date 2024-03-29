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