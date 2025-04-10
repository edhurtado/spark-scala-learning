package example

import scala.compiletime.ops.int

object Lists:

  /**
   * This method computes the sum of all elements in the list xs. There are
   * multiple techniques that can be used for implementing this method, and
   * you will learn during the class.
   *
   * For this example assignment you can use the following methods in class
   * `List`:
   *
   *  - `xs.isEmpty: Boolean` returns `true` if the list `xs` is empty
   *  - `xs.head: Int` returns the head element of the list `xs`. If the list
   *    is empty an exception is thrown
   *  - `xs.tail: List[Int]` returns the tail of the list `xs`, i.e. the the
   *    list `xs` without its `head` element
   *
   *  ''Hint:'' instead of writing a `for` or `while` loop, think of a recursive
   *  solution.
   *
   * @param xs A list of natural numbers
   * @return The sum of all elements in `xs`
   */
  def sum(xs: List[Int]): Int =
    xs.foldLeft(0)( (prev, next) => prev + next ) // Logica creada por mi

  /**
   * This method returns the largest element in a list of integers. If the
   * list `xs` is empty it throws a `java.util.NoSuchElementException`.
   *
   * You can use the same methods of the class `List` as mentioned above.
   *
   * ''Hint:'' Again, think of a recursive solution instead of using looping
   * constructs. You might need to define an auxiliary method.
   *
   * @param xs A list of natural numbers
   * @return The largest element in `xs`
   * @throws java.util.NoSuchElementException if `xs` is an empty list
   */
  def max(xs: List[Int]): Option[Int] = 
    /* Implementación pensada por mi: 
    def maxTwo(a: Int, b: Int): Int = if a > b then a else b
    // xs.foldLeft(0)( (max, elem) => maxTwo(elem, max) ) // Codigo pensado por mi
    xs.foldLeft(Int.MinValue)( (max, elem) => maxTwo(max, elem) ) // Sugerido por ChatGPT
    */

    xs.foldLeft(Option.empty[Int]) { //Proporcionado por ChatGPT, basado en un Scala Sr.
      case (None, elem) => Some(elem)
      case (Some(maxVal), elem) => Some(maxVal max elem)
    }

    /*if (xs.isEmpty) None
    else xs.foldLeft(Option.empty[Int]) {
      case (none, elem) => Some(elem)
      case (Some(maxVal), elem) => Some(maxVal max elem)
    }*/