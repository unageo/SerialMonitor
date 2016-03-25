package main.actor

import akka.actor.{Actor, ActorLogging}

/**
 * Created by geo on 3/25/16.
 */
class BuildActor extends Actor with ActorLogging
{
  val buf = new StringBuilder
  val eventActor = context.actorSelection( "akka://SerialSystem/user/newSerialEventActor")

  def handleChar( ch : Int ): Unit =
  {
    ch.asInstanceOf[ Char ] match
    {
      case char if char == '\n' =>
      {
        eventActor ! buf.toString
      }
      case char =>
        buf.append( char )
    }
  }

  def receive =
  {
    case ch : Int => handleChar( ch )

  }

}
