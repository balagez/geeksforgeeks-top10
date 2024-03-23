package arrays

import main.assert._

/**
 * @see https://www.geeksforgeeks.org/trapping-rain-water/
 */
class TrappingRainWater {

  // scan each level from 1 to max height, record wall positions, fill horizontally with
  // intermediate walls skipped
  // time: O(N x M) – M is the max height, time is O(N) if max height is constant
  // space: O(N) – for recording wall positions (zipWithIndex is just for convenience, can be avoided with foldLeft)
  def impl1(in: Vector[Int]): Int = {
    val ini = in.zipWithIndex
    (1 to in.max).foldLeft(0) { (acc, y) =>
      val walls = ini.collect { case (w, i) if w >= y => i }
      val len = walls.length
      acc + (if (len >= 2) walls(len - 1) - walls(0) - len + 1 else 0)
    }
  }

  // pre-calculate the left and right walls for each position
  // time: O(N)
  // space: O(N)
  def impl2(in: Vector[Int]): Int = {
    val left = in.foldLeft(Vector.empty[Int]) { (a, h) => if (a.isEmpty) Vector(h) else (a.head max h) +: a }.reverse
    val right = in.foldRight(Vector.empty[Int]) { (h, a) => if (a.isEmpty) Vector(h) else (a.head max h) +: a }
    in.foldLeft((0, 0)) { case ((acc, i), h) => (acc + math.min(left(i), right(i)) - h, i + 1) }._1
  }

  impl1(Vector(2, 0, 2)) === 2
  impl1(Vector(3, 0, 2, 0, 4)) === 7
  impl1(Vector(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)) === 6

  impl2(Vector(2, 0, 2)) === 2
  impl2(Vector(3, 0, 2, 0, 4)) === 7
  impl2(Vector(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)) === 6
}
