package main

object utils {

  implicit class EqualsOps[T](val a: T) extends AnyVal {
    def ===(b: T): Unit = {
      if (a == b) {
        println("OK")
      } else {
        println(s"KO: $a != $b")
      }
    }
  }
}
