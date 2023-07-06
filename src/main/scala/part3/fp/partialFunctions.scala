package part3.fp

object partialFunctions extends App{

  // a function that works on whole Intergeer range.
  val completeFunction : (Int,Int) => Int = _ + _

  //A partial function only works on subrange of a type .

  val apartialFunction = (x : Int) =>  x match{
    case 1 => "one"
    case 2 => "two"
    case 3 => "three"
  }

  //above function is defined on only range (1,2,3)

  val anotherPartialFunction : PartialFunction[Int,Int] = {
    case 1 => 199
    case 2 => 299
    case 3 => 399
  }

  println(anotherPartialFunction(2))
  //println(anotherPartialFunction(10))

  //pf utilities

  println(anotherPartialFunction.isDefinedAt(64))
  val lifted = anotherPartialFunction.lift    // Int => Option(Int)

  println(lifted(2))
  println(lifted(10))

  val pfChain = anotherPartialFunction.orElse[Int,Int]{
    case 7 => 799
  }

  // partial function extends total function.
  val aTotalFunction : Int => Int = {
    case 1 => 99
  }

  //HOF also accepts partial functions.

  val mappedList = List(1,2,3).map {
    case 1 => 1 + 2
    case 2 => 2 + 3
    case 3 => 4 + 2
  }

  println(mappedList)

  //partial function can only have once parameter.

  /*
  * 1.construct a partial function yourself (anonymous class).*/

  val anonymousPartialFunction = new PartialFunction[Int,Int] {
    override def apply(v1: Int): Int = v1 match {
      case 1 => 1
      case 2 => 2
    }

    override def isDefinedAt(x: Int): Boolean = if( x == 1 || x == 2) true else false
  }

  println(anonymousPartialFunction(1))

  val chatbot : PartialFunction[String,String] =  {
    case "hello" => "how are you"
    case "hi" => "hiii"
  }

  scala.io.Source.stdin.getLines().foreach(line => println(chatbot(line)))
}
