import scala.collection.mutable.ListBuffer

object lab_8 {

  class User(var name: String, var age: Int, var country: String) {

    def this() {
      this("", 0, "")
    }

    def scan(): Unit = {
      name = scala.io.StdIn.readLine()
      age = scala.io.StdIn.readInt()
      country = scala.io.StdIn.readLine()
    }

    def showInfo(): Unit = {
      println(name)
      println(age)
      println(country)
    }

  }

  class DataBase {
    def show(): Unit = {
      var i: Int = 0
      for (user <- list) {
        println("User[" + i + "]:")
        i = i + 1
        user.showInfo()
      }
    }

    var list: ListBuffer[User] = new ListBuffer[User]

    def add(user: User): Unit = {
      list += user
    }

    def setAgeAndCountry(username: String): Unit = {
      val res = list.indexWhere(User => User.name == username)
      if (res != -1) {
        list(res).age = scala.io.StdIn.readInt()
        list(res).country = scala.io.StdIn.readLine()
      }
    }

    def find(user: User): Int = {
      list.indexOf(user)
    }
  }

  def main(args: Array[String]): Unit = {
    val dataBase = new DataBase
    val user = new User("alex", 18, "Belarus")
    user.showInfo()
    dataBase.add(user)
    do {
      println("1 - Add new user")
      println("2 - Change age and country for certain user")
      println("3 - Show DataBase")
      println("4 - Exit")
      print("Choice: ")
      val a = scala.io.StdIn.readChar()
      a match {
        case '1' =>
          val newUser = new User()
          println("Enter name, age, country")
          newUser.scan()
          dataBase.add(newUser)
        case '2' =>
          println("enter name to set age and country")
          val name = scala.io.StdIn.readLine()
          dataBase.setAgeAndCountry(name)
        case '3' =>
          println("DataBase:")
          dataBase.show()
        case '4' => println(); return
        case _ => println("\nChoose option\n")
      }
    } while (true)
  }
}
