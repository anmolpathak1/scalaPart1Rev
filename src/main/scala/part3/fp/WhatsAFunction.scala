package part3.fp

object WhatsAFunction extends App{
  //DREAM : use functions as first class elements.
  //problem : oop

  val doubler = new Function[Int,Int]{
    override def apply(v1: Int): Int = v1 * 2
  }
  println(doubler(2))

  //function types = Function[A,B]
  val stringToIntConverter =  new Function1[String,Int]{
    override def apply(v1: String): Int = v1.toInt
  }

  println(stringToIntConverter("3") + 4)

  val adder = new Function2[Int,Int,Int]{
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  //ALL SCALA FUNCTIONS ARE OBJECTS.

  /*
  * 1. A function that takes 2 string and concatenates them.
  * 2.transform the MyPredicate and MyTransformer into function Types.
  * 3.define a function which takes an int and returns another function  which takes and int and returns an int.
  *   -what's the type of this function.
  *   -how to do it ?
  */

  val concatenate = new Function2[String,String,String] {
    override def apply(v1: String,v2 : String): String = v1 + v2
  }

  val hof = new Function1[Int,Function1[Int,Int]] {
    override def apply(v1: Int): Int => Int = new Function[Int,Int] {
      override def apply(v2: Int): Int = v1 + v2
    }
  }

}

trait Action[A,B]{
  def execute (element : A) : B = ???
}
