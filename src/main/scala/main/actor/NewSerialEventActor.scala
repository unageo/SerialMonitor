package main.actor

import akka.actor.{ActorLogging, Actor}
import main.utility.Counter

/**
 * Created by geo on 3/22/16.
 */
class NewSerialEventActor extends Actor with ActorLogging
{

  val counter = Counter( 1000, x => log.info( x.toString ) )

  def receive =
  {
    case str : String => counter.hit()
    case _   => log.error( "UNKNOWN" )
  }

}
