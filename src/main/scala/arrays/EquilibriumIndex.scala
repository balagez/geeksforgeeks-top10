package arrays

import main.assert._

/**
 * @see https://www.geeksforgeeks.org/equilibrium-index-of-an-array/
 */
class EquilibriumIndex {

  // time: O(N)
  // space: O(N)
  def apply(in: Vector[Int]): Int = {
    val left = in.foldLeft(Vector.empty[Int]) { (a, h) => if (a.isEmpty) Vector(h) else (a.head + h) +: a }.reverse
    val right = in.foldRight(Vector.empty[Int]) { (h, a) => if (a.isEmpty) Vector(h) else (a.head + h) +: a }
    (0 to in.length - 1).find(i => left(i) == right(i)).getOrElse(-1)
  }

  apply(Vector()) === -1
  apply(Vector(1, 2, 3)) === -1
  apply(Vector(1, 0, 1)) === 1
  apply(Vector(5, 0, 0, 0, 5)) === 1
  apply(Vector(-7, 1, 5, 2, -4, 3, 0)) === 3
}
