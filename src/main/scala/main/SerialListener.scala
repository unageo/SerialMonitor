//package main
//
//import java.io.{BufferedReader, InputStreamReader}
//
//import gnu.io.{CommPortIdentifier, SerialPort, SerialPortEvent, SerialPortEventListener}
//
///**
// * Created by geo on 3/3/16.
// */
//class SerialListener extends SerialPortEventListener
//{
//  val PORT_NAME = "/dev/ttyACM0"
//  val DATA_RATE = 115200
//  val TIME_OUT  = 2000
//
//
//  def getPortId : Option[ CommPortIdentifier ] =
//  {
////    System.setProperty("gnu.io.rxtx.SerialPorts", "/dev/ttyACM0")
//    val portEnum = CommPortIdentifier.getPortIdentifiers
//    println( "ha  =>  " + portEnum.toString )
//    while( portEnum.hasMoreElements )
//    {
//      val elem = portEnum.nextElement()
//
//      val currPortId = elem.asInstanceOf[ CommPortIdentifier ]
//      println( "name ====> " + currPortId.getName )
//      if( PORT_NAME == currPortId.getName )
//      {
//        return Some( currPortId )
//      }
//    }
//    None
//  }
//
//  //Run initialization
//  val portId = getPortId match
//  {
//    case None => throw new RuntimeException( s"Could NOT get port $PORT_NAME")
//    case Some( tempPortId ) => tempPortId
//  }
//  val serialPort = portId.open( this.getClass.getName, TIME_OUT ).asInstanceOf[ SerialPort ]
//  serialPort.setSerialPortParams( DATA_RATE,
//                                  SerialPort.DATABITS_8,
//                                  SerialPort.STOPBITS_1,
//                                  SerialPort.PARITY_NONE )
//
//  val input = new BufferedReader( new InputStreamReader( serialPort.getInputStream ) )
//  val output = serialPort.getOutputStream
//
//  serialPort.addEventListener( this )
//  serialPort.notifyOnDataAvailable( true )
//
//  var count = 0
//  var running = 0
//  def serialEvent( event : SerialPortEvent ): Unit =
//  {
//    var nano = System.nanoTime
//    event.getEventType match
//    {
//      case SerialPortEvent.DATA_AVAILABLE =>
//        while( true )
//        {
//          count += 1
//          val data = input.readLine
//          val curNano = System.nanoTime
//          //println( s"${System.nanoTime}( ${curNano - nano} ) => ${input.readLine}" )
//          nano = curNano
//          if (count % 1000 == 0)
//          {
//            running += 1
//            println(s"Running $running * 1000")
//          }
//        }
//      case _ =>
//    }
//  }
//
//
//}
