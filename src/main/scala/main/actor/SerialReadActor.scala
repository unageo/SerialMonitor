package main.actor

import akka.actor._
import main.serial.{SerialConnection, SerialConnectionProps}


/**
 * Created by geo on 3/6/16.
 */

class SerialReadActor( val props : SerialConnectionProps ) extends Actor with ActorLogging
{
  //val countActor = context.actorOf( Props[CountActor( 10000 )], "serialCounter" )

  val countActor = context.actorSelection( "akka://SerialSystem/user/serialReadCounter" )
  val buildActor = context.actorSelection( "akka://SerialSystem/user/buildActor" )

  private def processLine( str : String ) : Unit =
  {
    countActor ! CountActor.Increment
  }

  private def processInt( ch : Int ): Unit =
  {
    buildActor ! ch
    countActor ! CountActor.Increment
  }

  val connection = SerialConnection( props, processInt )

  def receive =
  {
    case myString : String =>
    {
      log.info( myString )
    }
  }

}

object SerialReadActor
{
  case object StartReading
}
