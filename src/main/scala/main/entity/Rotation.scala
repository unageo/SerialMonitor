package main.entity

/**
 * Created by geo on 3/6/16.
 */
case class Rotation( unixTime    : Long,
                     xRot        : Int,
                     yRot        : Int,
                     zRot        : Int,
                     orientation : Orientation.Value )

object Rotation
{
  def apply( str : String ) : Rotation =
  {
    val tokens = str.trim.split( "," )//need the trim because there appears to be a \r in there...
    Rotation( System.currentTimeMillis,
              tokens( 0 ).toInt,
              tokens( 1 ).toInt,
              tokens( 2 ).toInt,
              Orientation.fromInt( tokens( 3 ).toInt ) )
  }

  def fromString( str : String ) : Option[ Rotation ] =
  {
    try
    {
      Some( Rotation( str ) )
    }
    catch
    {
      case ex : NumberFormatException => None
      case ex : ArrayIndexOutOfBoundsException => None
    }
  }
}