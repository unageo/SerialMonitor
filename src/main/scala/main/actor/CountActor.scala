package main.actor

import akka.actor.{Actor, ActorLogging}

/**
 * Created by geo on 3/22/16.
 */
class CountActor extends Actor with ActorLogging
{
  import CountActor._

  log.info( "I AM ALIVE!" )
  //val counter = Counter( printLimit, x => log.info( x.toString ) )
  var counter = 0
  var prevTime = System.currentTimeMillis()

  def receive =
  {
    case Increment => counter += 1
    case Print =>
    {
      val now = System.currentTimeMillis
      log.info( s"Counter is at $counter after ${now - prevTime} ms." )
      prevTime = now
      counter = 0
    }
  }

}

object CountActor
{
  sealed trait CountAction
  case object Increment extends CountAction
  case object Print extends CountAction
}