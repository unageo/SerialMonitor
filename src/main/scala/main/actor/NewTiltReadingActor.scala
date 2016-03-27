package main.actor

import akka.actor.{ActorLogging, Actor}
import akka.routing.BroadcastGroup
import main.entity.Rotation
import main.utility.Counter

import scala.collection.immutable.Queue

/**
 * Created by geo on 3/22/16.
 */

case class LastReadingDuration( list : List[ Rotation ], duration : Long )
case class ProcessDuration( duration : Long )

class NewTiltReadingActor extends Actor with ActorLogging
{

  var q = Queue[ Rotation ]()

  def handleReading( opt : Option[ Rotation ] ) : Unit =
  {
    opt match
    {
      case Some( reading ) =>
        q = q.enqueue( reading )
      case None            =>
    }
  }

  def receive =
  {
    case str : String => handleReading( Rotation.fromString( str ) )
    case _   => log.error( "UNKNOWN" )
  }
}
