package part3.fp

object hofAndcurries extends App{

  def ntimes(f : Int => Int,n : Int,x : Int) : Int = {
    if (n <= 0 ) x
    else ntimes(f,n-1,f(x))
  }

  val plusOne : Int => Int = _ + 1
  println(ntimes(plusOne,10,1))

  def ntimesBetter(f : Int => Int , n : Int) : Int => Int = {
    if(n <= 0) (x : Int) => x
    else (x : Int) => ntimesBetter(f,n-1)(f(x))
  }

  println(ntimesBetter(plusOne,10)(1))
}
