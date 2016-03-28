package main.actor

import akka.actor.{Actor, ActorLogging}
import main.entity.Rotation

import scala.collection.mutable

/**
 * Created by geo on 3/25/16.
 *
 * This class performs a very basic linear average over the streaming data
 * it isn't perfect right now because it could grab a few readings that didn't
 * actually fall between the correct time window.
 *
 * I will revisit and fix once I get things working back to front.
 *
 * @param millisToAverage window in milliseconds to average over
 */
class LinearAvgActor( val millisToAverage : Long ) extends Actor with ActorLogging
{
  val queue = mutable.Queue[ Rotation ]()
  var lastAverageTime = System.currentTimeMillis

  def receive =
  {
    case rot : Rotation =>
      queue.enqueue( rot )
      val now = System.currentTimeMillis
      val diff = now - lastAverageTime
      //val filtered = queue.filter( rot => rot.unixTime > )
      if( diff >= millisToAverage )
      {
        val length = queue.size
        val sums = queue.foldLeft( ( 0, 0, 0 ) )(
          ( running, reading ) => ( running._1 + reading.xRot,
                                    running._2 + reading.yRot,
                                    running._3 + reading.zRot ) )
        val avgs = ( 1.0 * sums._1 / length,
                     1.0 * sums._2 / length,
                     1.0 * sums._3 / length )
        log.info( s"Avg for $millisToAverage($diff) ms : $avgs over $length readings." )
        lastAverageTime = now
        queue.clear()
      }
  }

}
