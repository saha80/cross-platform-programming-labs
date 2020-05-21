object lab_7 {

  object char {
    val half: Int = ('z' - 'a') / 2 + 'a'

    abstract class AlphaChar

    case class LessHalf() extends AlphaChar

    case class GreaterHalf() extends AlphaChar

    def apply(c: Char): AlphaChar = {
      if (c.toLower < half) {
        new LessHalf
      } else {
        new GreaterHalf
      }
    }
  }

  def patterMatching(c: Char): Char = {
    char.apply(c) match {
      case char.LessHalf() => c.toLower
      case char.GreaterHalf() => c.toUpper
    }
  }

  def main(args: Array[String]): Unit = {
    val s: String = "The quick brown fox jumps over the lazy dog"
    println(s.map(Char => patterMatching(Char)))
  }
}
