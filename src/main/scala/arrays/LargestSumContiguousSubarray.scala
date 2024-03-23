package arrays

import scala.annotation.tailrec
import main.utils._

/**
 * @see https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 */
class LargestSumContiguousSubarray {

  @tailrec final def apply(
      in: List[Int],
      i: Int = 0,
      currentSum: Int = 0,
      currentStart: Int = 0,
      largestSum: Int = 0,
      start: Int = 0,
      end: Int = 0
  ): (Int, Int, Int) = {
    in match {
      case Nil => (largestSum, start, end)
      case num :: rest =>
        val newCurrentSum = math.max(currentSum + num, num)
        val newSubarrayFound = newCurrentSum > largestSum
        // println(f"$num%3d $newCurrentSum%3d $largestSum%3d     $start..$end")
        apply(
          in = rest,
          i = i + 1,
          currentSum = newCurrentSum,
          currentStart = if (newCurrentSum == num) i else currentStart,
          largestSum = if (newSubarrayFound) newCurrentSum else largestSum,
          start = if (newSubarrayFound) currentStart else start,
          end = if (newSubarrayFound) i else end
        )
    }
  }

  apply(List(-2, -3, 4, -1, -2, 1, 5, -3)) === (7, 2, 6)
  apply(List(-2, -3, 4, -1)) === (4, 2, 2)
  apply(List(-2, -3, 4, 3, -1, -8, -2, 1)) === (7, 2, 3)
  apply(List(1, 2, 4, 3, -1, -8, -2, 1)) === (10, 0, 3)
  apply(List(-2, -3, 4, -1, -2, 1, 5, -3)) === (7, 2, 6)
  apply(List(-2, -3)) === (0, 0, 0)
}
