package services

class PersonService {

  def findUser(name: String): Option[User] = {
    Some(User(name, 12))
  }

}
