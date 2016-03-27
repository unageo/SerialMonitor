package main

import akka.actor.{Props, ActorSystem}
import actor.{BuildActor, NewTiltReadingActor, CountActor, SerialReadActor}
import serial.{SerialConnectionProps, SerialConnection}
import scala.concurrent.duration._


/**
 * Created by geo on 11/4/15.
 */


object main extends App
{
  import system.dispatcher
  //val listener = new SerialListener
  val serialProps = SerialConnectionProps( "/dev/ttyACM0", 115200, 2000 )
  val system = ActorSystem( "SerialSystem" )

  val serialReadCounter = system.actorOf( Props( new CountActor ), name="serialReadCounter" )
  val processedCounter  = system.actorOf( Props( new CountActor ), name="processedCounter" )
  val serialEventActor  = system.actorOf( Props( new NewTiltReadingActor ), name = "newTiltReadingActor" )
  val buildActor  = system.actorOf( Props( new BuildActor ), name = "buildActor" )

  val serialReader = system.actorOf( Props( new SerialReadActor( serialProps ) ), name = "serialReader" )

  val cancellable = system.scheduler.schedule( 0.milliseconds,
                                               1000.milliseconds,
                                               serialReadCounter,
                                               CountActor.Print )

  val cancellable2 = system.scheduler.schedule( 0.milliseconds,
                                                1000.milliseconds,
                                                processedCounter,
                                                CountActor.Print )
}
