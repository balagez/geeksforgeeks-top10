package arrays

import main.utils._

// https://www.geeksforgeeks.org/trapping-rain-water/
class TrappingRainWater {

  def apply(in: List[Int]): Int = {
    val height = in.max
    val ini = in.zipWithIndex
    (1 to height).map { h =>
      val walls = ini.collect { case (w, i) if w >= h => i }
      if (walls.length >= 2) walls.max - walls.min - walls.length + 1 else 0
    }.sum
  }

  apply(List(2, 0, 2)) === 2
  apply(List(3, 0, 2, 0, 4)) === 7
  apply(List(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)) === 6
}
