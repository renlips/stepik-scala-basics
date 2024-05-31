  case class User(id: Int, name: Option[String])

  val bob = User(2, Some("Bob"))

  val userName: Option[String] = bob.name


  val nameLength = userName match {
    case Some(name) => name.length
    case None => 0
  }

  println(s"user's name length = $nameLength") // user's name length = 3