package main.actor

import akka.actor.{Actor, ActorLogging}

/**
 * Created by geo on 3/25/16.
 */
class LinearAvgActor extends Actor with ActorLogging
{

  def receive =
  {
    case tmp : String => log.info( tmp )
  }

}
