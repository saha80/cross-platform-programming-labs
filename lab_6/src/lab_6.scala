object lab_6 {

  def main(args: Array[String]): Unit = {
    val list = List("d", "fd", "fd", "df")
    println(list.count(String => "fd" == String))
  }

}
