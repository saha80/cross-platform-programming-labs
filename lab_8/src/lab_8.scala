object lab_8 {

  class User(val name: String, val age: Int, val country: String) {

    def showInfo(): Unit = {
      println(name)
      println(age)
      println(country)
    }
  }

  //  class DataBase {
  //    val list: List[User]
  //
  //    def add(user: User): Unit = {
  //      list.:::(List(user))
  //    }
  //
  //    def find(user: User): Int = {
  //      list.indexOf(user)
  //    }
  //  }

  def main(args: Array[String]): Unit = {
    //    val dataBase = new DataBase
    //    val user = new User("alex", 18, "Belarus");
    //    user.showInfo()
    //    dataBase.add(user)
    //    println(dataBase.find(user))
  }
}
