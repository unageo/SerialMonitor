trait Junk1
{
  def myName = "Junk1"
}

trait Junk2
{
  def myName = "Junk2"
}

class Mixer extends Junk1 with Junk2
{
  override def myName = super[ Junk2 ].myName
  def getNonsense = myName
}

val mixer = new Mixer

mixer.getNonsense



//trait Animal
//{
//  println( s"At top of Animal trait!!!")
//  val name : String
//  println( s"name=$name")
//  lazy val mp = Map( "name" -> name )
//  println( "Whaaaaaaaaaaat : " + mp )
//}
//
//case class Human( name : String ) extends Animal
//{
//  println( "At top of Human case class!!!")
//  override def toString = s"mp = ${mp}"
//}
//
//def getName =
//{
//  println( "At top of getName")
//  "Georgio"
//}
//
//val me = Human( getName )
