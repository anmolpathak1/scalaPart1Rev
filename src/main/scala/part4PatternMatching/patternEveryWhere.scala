package part4PatternMatching

object patternEveryWhere extends App{

  //big idea # 1

  try{

  }catch {
    case e : RuntimeException => "runtime"
    case npe : NullPointerException => "npoe"
    case _ => "something else"
  }

  //cathces are actually matches
  /*try{
     //code
  * }catch(e){
    e match{
    case e : runtimeException => "runtime"
    case npe: NullPointerException => "npe"
    case _ => "something else"
    }
  }*/

  //big idea #2

  //generators are also based on pattern matching
  val list = List(1,2,3,4)
  val evenOnes = for{
    x <- list if x % 2 == 0
  }yield 1 * x


  val tuples = List((1,2),(3,4))
  val filterTuples = for{
    (first,second) <- tuples
  }yield first * second

  //big idea # 3
  val tuple = (1,2,3)
  val (a,b,c) = tuple
  println(b)

  val head :: tail = list
  println(head)
  println(tail)

  //big idea # 4
  //partial functiona

  val mappedList = list.map {
    case v if v %2 == 0 => v  + "is even."
    case 1 => "the one."
    case _ => "something else."
  }//partail function literal.

  val mappedList2 = list.map{
    x => x match{
      case v if v % 2 ==0 => v + "is even."
      case 1 => "the one."
      case _ => "something else."
    }
  }

  println(mappedList)


}
