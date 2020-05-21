import scala.annotation.tailrec

object lab_5 {
  def fib_tr(n: Int): Int = {
    @tailrec
    def fib_acc(prev: Int, next: Int, n: Int): Int = {
      if (n == 0) {
        prev
      } else {
        fib_acc(next, next + prev, n - 1)
      }
    }

    fib_acc(0, 1, n)
  }

  def fib(n: Int): Int = {
    var prev = 0
    var next = 1
    var i = 0
    for (i <- 0 to n) {
      val temp = next + prev
      prev = next
      next = temp
    }
    prev
  }

  def main(args: Array[String]): Unit = {
    println(fib_tr(3))
    println(fib(3))
  }
}
