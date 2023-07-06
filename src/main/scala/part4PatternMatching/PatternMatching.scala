package part4PatternMatching
import scala.util.Random

object PatternMatching extends App{

  val random = new Random

  val x = random.nextInt(10)

  val description  = x match{
    case 1 => "the one."
    case 2 => "double or nothing."
    case 3 => "third time is the charm."
    case _ => "something else."
  }

  println(x)
  println(description)

  //1.Decompose value
  case class Person(name : String,age : Int)
  val bob = Person("Bob",20)

  val greeting = bob match {
    case Person(n,a) if a < 21  => s"hi my name is $n and age is $a and I cannot drink alcohol."
    case Person(n,a) => s"hi my name is $n and age is $a."
    case _ => "any other case class."
  }

  /*
  * 1.cases are matched in order.
  * 2.if nothing matching its a match error.
  * 3. return type is unification of all case (lowest ancestor)*/

  println(greeting)


   class Animal
  case class Dog(breed : String) extends Animal
  case class Parrot(greeting : String) extends Animal

  val animal : Animal = new Dog("Terra Nova")
  animal match {
    case Dog(someBreed) => println(s"matched a dog of $someBreed breed.")
  }

  /*
  * simple function uses Pattern Matching.
  * takes an Expr  => human readale form.
  * sum(Number(2),Number(3)) =>  2 + 3
  * Prod(Sum(Number(2),Number(1)),Number(3)) => (2 + 1) * 3
  * sum(Prod(Number(2),Number(1)),Number(3)) => 2 * 1 + 3*/

  trait Expr
  case class Number(n : Int) extends Expr
  case class Sum(e1 : Expr,e2 : Expr) extends Expr
  case class Prod(e1 : Expr,e2 : Expr) extends Expr

  def show(expr: Expr) : String = {
    expr match {
      case Number(n) => s"$n"
      case Sum(e1,e2) => show(e1) + "  +  " + show(e2)
      case Prod(e1,e2) => {
        def maybeShowParentheses(expr: Expr) = expr match {
          case Prod(_,_) => show(expr)
          case Number(_) => show(expr)
          case _ => "(" + show(expr) + ")"
        }
        maybeShowParentheses(e1) + " * " + maybeShowParentheses(e2)
      }
    }
  }

//  val num1 = Number(1)
//  val num1 = Sum(Number(1),Number(2))
//  val num1 = Prod(Sum(Number(1),Number(2)),Number(3))
  val num1 = Sum(Prod(Number(1),Number(2)),Number(3))
  println(show(num1))



}
