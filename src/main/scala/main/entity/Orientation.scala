package main.scala.main.entity

/**
 * Created by geo on 3/6/16.
 */
object Orientation extends Enumeration
{
  val portraitUpFront,
      portraitUpBack,
      portraitDownFront,
      portraitDownBack,
      landscapeRightFront,
      landscapeRightBack,
      landscapeLeftFront,
      landscapeLeftBack = Value

  private val mapping = Map(0 -> portraitUpFront,
                            1 -> portraitUpBack,
                            2 -> portraitDownFront,
                            3 -> portraitDownBack,
                            4 -> landscapeRightFront,
                            5 -> landscapeRightBack,
                            6 -> landscapeLeftFront,
                            7 -> landscapeLeftBack)
  def fromInt( int : Integer ) : Orientation.Value =
  {
    mapping.get( int ) match
    {
      case Some( orient ) => orient
      case None           => throw new RuntimeException( s"Cannot map $int to an enum.")
    }
  }
}
