 sealed trait CourseType
 case object Free extends CourseType
 case object Paid extends CourseType
 
 case class Course(id: Int, courseType: CourseType)
 
 case class User(id: Int, email: String, courses: List[Course])


 val users = List(
   User(
     1,
     "bob@example.com",
     List(Course(1, Free), Course(24, Paid))
   ),
   User(
     2,
     "sam@example.com",
     List(Course(24, Paid), Course(3, Paid))
   ),
   User(
     3,
     "alice@example.com",
     List(Course(5, Free), Course(12, Free))
   ),
 )

  val userEmails = users.map(_.email) 

  val paidCourses = users.flatMap(user => user.courses.filter(_.courseType == Paid)).distinct

  val userCourses = users.filter(user => user.id % 2 != 0).map(user => (user, user.courses.size))

    def getUsersByEmails(
        users: List[User],
        emails: List[String]): List[User] = {
            users.flatMap {
                user => emails.flatMap { 
                    email =>
                        if (user.email.equals(email)) List(user)
                        else List()
                }
            }
        }

 val emails =  List("bob@example.com")//, "sam@example.com", "tom@example.com")
 val usersByEmail = getUsersByEmails(users, emails)