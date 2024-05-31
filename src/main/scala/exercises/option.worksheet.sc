  // case class User(id: Int, name: String)

  // val aUser = User(1, null)
  // val nameLength = aUser.name.length

  // println(s"user's name length = $nameLength")
  

  case class User(id: Int, name: Option[String])

  val aUser = User(1, Some("None"))

  val userName: Option[String] = aUser.name

  val nameLength = userName match {
    case Some(name) => name.length
    case None => 0
  }

  println(s"user's name length = $nameLength") // user's name length = 0