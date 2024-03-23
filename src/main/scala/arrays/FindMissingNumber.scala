package arrays

import main.utils._

// https://www.geeksforgeeks.org/find-the-missing-number/
class FindMissingNumber {

  def apply(in: List[Int]): Int = {
    val n = in.length + 1
    n * (n + 1) / 2 - in.sum
  }

  apply(List(1, 2, 3, 4, 6, 7)) === 5
}
