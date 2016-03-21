package main

import serial.{SerialConnectionProps, SerialConnection}


/**
 * Created by geo on 11/4/15.
 */



//sealed trait PiMessage
//case object Calculate extends PiMessage
//case class Work( start : Int, nrOfElements : Int ) extends PiMessage
//case class Result( value : Double ) extends PiMessage
//case class PiApproximation( pi : Double, duration : Duration )
//
//
//class Worker extends Actor
//{
//  val created = System.nanoTime()
//  def calculatePiFor( start : Int, nrOfElements : Int ) =
//  {
//    println( s"ACTOR $created, got some work!" )
//    ( start until start + nrOfElements).foldLeft( 0.0 )(
//      ( running, elem ) => running + 4.0 * (1 - (elem % 2) * 2) / (2 * elem + 1) )
//  }
//
//  def receive =
//  {
//    case Work( start, nrOfElements ) =>
//      val res = Result( calculatePiFor( start, nrOfElements ) )
//      sender ! res
//  }
//}
//
//class Master( nrOfWorkers : Int,
//              nrOfMessages : Int,import entity.SerialConnectionProps
//              nrOfElements : Int,
//              listener : ActorRef ) extends Actor
//{
//  var pi          : Double = _
//  var nrOfResults : Int    = _
//  val start       : Long   = System.currentTimeMillis
//
//  val workerRouter = context.actorOf(
//    Props[Worker].withRouter( RoundRobinPool( nrOfWorkers ) ), name = "workerRouter" )
//
//  def receive =
//  {
//    case Calculate =>
//
//      for (i <- 0 until nrOfMessages)
//      {
//        println( "Sending to worker....." )
//        workerRouter ! Work(i * nrOfElements, nrOfElements)
//
//      }
//    case Result( value ) =>
//    {
//      pi          += value
//      nrOfResults += 1
//      if( nrOfResults == nrOfMessages )
//      {
//        listener ! PiApproximation( pi, ( System.currentTimeMillis - start ).millis )
//        context.stop( self )
//      }
//
//    }
//  }
//}
//
//class Listener extends Actor
//{
//  def receive =
//  {
//    case PiApproximation( pi, duration ) =>
//      println("\n\tPi approximation: \t\t%s\n\tCalculation time: \t%s"
//        .format(pi, duration))
//      context.system.terminate()
//  }
//}

object main extends App
{
  //val listener = new SerialListener
  val serialProps = SerialConnectionProps( "/dev/ttyACM0", 115200, 2000 )
  val serConn = SerialConnection( serialProps, println( _ ) )

//  calculate(2, 100000000, 4 )
//
//  def calculate(nrOfWorkers: Int, nrOfElements: Int, nrOfMessages: Int) {
//    // Create an Akka system
//    val system = ActorSystem("PiSystem")
//
//    // create the result listener, which will print the result and shutdown the system
//    val listener = system.actorOf(Props[Listener], name = "listener")
//
//    // create the master
//    val master = system.actorOf(Props(new Master(
//      nrOfWorkers, nrOfMessages, nrOfElements, listener)),
//      name = "master")
//
//    // start the calculation
//    master ! Calculate
//
//  }

}
