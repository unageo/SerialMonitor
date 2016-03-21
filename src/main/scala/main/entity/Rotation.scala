package main.scala.main.entity

/**
 * Created by geo on 3/6/16.
 */
case class Rotation( xRot        : Double,
                     yRot        : Double,
                     zRot        : Double,
                     orientation : Orientation.Value )

object Rotation
{
  def apply( str : String ) : Rotation =
  {
    val tokens = str.split( "," )
    Rotation( tokens( 0 ).asInstanceOf[ Double ],
              tokens( 1 ).asInstanceOf[ Double ],
              tokens( 2 ).asInstanceOf[ Double ],
              Orientation.fromInt( tokens( 3 ).asInstanceOf[ Int ] ) )
  }
}