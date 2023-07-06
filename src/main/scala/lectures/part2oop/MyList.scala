package lectures.part2oop

//TODO - convert it to generics

/*
* created by Anmol .
* */


trait MyPredicate[-T]{
  def test(x : T) : Boolean
}

trait MyTransform[-A,B]{
  def transform(a : A) : B
}

abstract class MyList[+A] {

  /*
  * head = first element of the list.
  * tail = remainder of the list.
  * isEmpty = is this list empty.
  * add(int) => new list with this element added.
  * toString => a string representation of the list.
  * */

  def head : A
  def tail : MyList[A]
  def isEmpty : Boolean
  def add[B >: A](element : B) : MyList[B]

//  protected def printElements : String               //this one causes an error -> find out what it is ?


  def printElements : String

  //implementing it
  override def toString: String = "{" + printElements + "}"

  def map[B](myTransform: MyTransform[A,B]) : MyList[B]
}


case object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException

  override def tail: Nothing = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](element: B): MyList[B] = new Cons(element , Empty)

  override def printElements: String = ""

  override def map[B](myTransform: MyTransform[Nothing, B]): MyList[B] = Empty
}



/*
* byb adding case keyword to cons I get -
* 1.h and t are now class members.
* 2.equals ,hashcode,toString implemented OOTB.
* 3.Cons is now serializable.
* 4.Companion object predefined.
* 5.A handy copy method.
* 6.*/
case class Cons[+A](h : A,t : MyList[A] ) extends MyList[A]{
  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](element: B): MyList[B] = new Cons(element,this)

  override  def printElements: String = {
    if(t.isEmpty) "" + h
    else  "" + h + " " +  t.printElements
  }

  override def map[B](myTransform: MyTransform[A, B]): MyList[B] = {
    Cons(myTransform.transform(h),t.map(myTransform))
  }
}


object ListTest extends App{
//  val list = new Cons(1,new Cons(2,new Cons(3,Empty)))
//  println(list.head)

  val list : MyList[String] = new Cons("hello",new Cons("world", Empty))
  println(list.tail.head)
  println(list.add("asdf").head)
  println(list.isEmpty)

  println(list.toString)

  val numericList = Cons(3,Cons(2,Cons(3,Empty)))
  println(numericList.map(new MyTransform[Int,Int] {
    override def transform(a: Int): Int = a * 2
  }))
}
