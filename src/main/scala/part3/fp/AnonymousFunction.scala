package part3.fp

object AnonymousFunction extends App{

  val doubler : Int => Int = x => x * 2

  val doubler2 = (x : Int) => x * 2

  //multiple parameter in lambdas
  val adder : (Int,Int) => Int = (a :Int,b : Int) => a + b

  val dosomething : () => Int = () => 3

  println(dosomething())

  val stringToInt =  (str : String) => str.toInt

  val niceIncrementer : Int => Int = _ + 1
  val niceAdder = (a : Int,b : Int) => a + b
//  val niceAdder : (Int,Int) => Int = _ + _
  //val niceAdder = _ + _

  val hof = new Function1[Int,Function1[Int,Int]] {
    override def apply(v1: Int): Int => Int = new Function[Int,Int] {
      override def apply(v2: Int): Int = v1 + v2
    }
  }

  val anonymousAdder : (Int => Int => Int) = (a : Int) => (b : Int) => a + b
}
