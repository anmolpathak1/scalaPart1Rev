package part3.fp

object curriesAndPAF extends App{

  //curried function.
  val adder : Int => Int => Int = x =>  y => x + y

  val add3 = adder(3)
  println(add3(4))

  println(adder(4)(5))

  //curried method
  def curriedAdder(x : Int)(y : Int) : Int = x + y

  println(curriedAdder(2)(3))

  //convert curried method to curried funtion.


  // in scala 2 when you call a method you need to provide all parameter
  val add4 : Int => Int  = curriedAdder(3)

  //lifting - ETA expansion.
  println(add4(4))

  // functions != MEthods (JVM limitation)
  def inc(x : Int) = x + 1
//  List(1,2,3).map(inc)           //ETA- expansion
   List(1,2,3).map(x => x + 1)

   //Partial function applications.
   val add5 = curriedAdder(5) _


   /*exercise
   * */

   val simpleAddFunction = (x : Int,y : Int) => x + y
   def simpleAddMethod(x:Int,y:Int) : Int = x + y
   def curriedAddMethod(x : Int)(y:Int) : Int = x + y


  //add7 : Int => Int = y => 7 + y
  //as many different implementations of add7

  val add71 : Int => Int = y => simpleAddFunction(7,y)

  val add72 = simpleAddFunction.curried(7)
  val add73 : Int => Int = y => simpleAddMethod(7,y)
  val add74 = curriedAddMethod(7)
  val add75 = simpleAddMethod(7,_ : Int)   //alternative syntax for turning methods into function values
  val add76 = simpleAddFunction(7,_)


  //underscore are powerful

  def concatenator(a : String,b : String,c :String) = a+ b +c
  val insertName = concatenator("Hello ,I am ", _ , "how are you")
  println(insertName("anmol"))

  val fillInTheBlanks = concatenator("hello ", _ : String,_:String)
  println(fillInTheBlanks("daniel ","scal is awesome"))

  /*
  * EXERCISE - 1.Process a list of numbers and return their string reprentations with different formats
  use the %4.2f,%8.6f and %14.12f with a curried formatter function
  * */

  def curriedFormatter(s : String)(number : Double) = s.format(number)

  val simpleFormatter = curriedFormatter("%4.2f")
  val preciseFormatter = curriedFormatter("%14.12f")

  val num = List(Math.PI,12.34)

  println(num.map(preciseFormatter))









}
