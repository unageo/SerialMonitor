package main.actor

import akka.actor.{Actor, ActorLogging}

/**
 * Created by geo on 3/25/16.
 */
class BuildActor extends Actor with ActorLogging
{
  val countActor = context.actorSelection( "akka://SerialSystem/user/processedCounter" )
  val eventActor = context.actorSelection( "akka://SerialSystem/user/newTiltReadingActor")
  val buf = new StringBuilder

  def handleChar( ch : Int ): Unit =
  {
    ch.asInstanceOf[ Char ] match
    {
      case char if char == '\n' =>
        countActor ! CountActor.Increment// buf.toString
        eventActor ! buf.mkString
        buf.clear()
      case char =>
        buf.append( char )
    }
  }

  def receive =
  {
    case ch : Int => handleChar( ch )
  }
}