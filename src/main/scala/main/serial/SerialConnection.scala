package main.serial

import gnu.io.{CommPortIdentifier, SerialPort}

/**
 * Created by geo on 3/6/16.
 *
 * This class will get a connection to the serial port
 */
case class SerialConnection( props   : SerialConnectionProps,
                             process : String => Unit )
{

  def getPortId : Option[ CommPortIdentifier ] =
  {
    val portEnum = CommPortIdentifier.getPortIdentifiers
    println( "ha  =>  " + portEnum.toString )
    while( portEnum.hasMoreElements )
    {
      val elem = portEnum.nextElement()

      val currPortId = elem.asInstanceOf[ CommPortIdentifier ]
      println( currPortId.getName )
      if( props.portPath == currPortId.getName )
      {
        return Some( currPortId )
      }
    }
    None
  }


  val portId = getPortId match
  {
    case None => throw new RuntimeException( s"Could NOT get port ${props.portPath}")
    case Some( tempPortId ) => tempPortId
  }

  val serialPort = portId.open( this.getClass.getName, props.timeOut ).asInstanceOf[ SerialPort ]
  serialPort.setSerialPortParams( props.baudRate,
                                  SerialPort.DATABITS_8,
                                  SerialPort.STOPBITS_1,
                                  SerialPort.PARITY_NONE )

  var num = 0
  var count = 0
  val buf = new StringBuilder
  val stream = serialPort.getInputStream
  //val vals = List.newBuilder[ String ]
  //val inputStreamReader = new BufferedReader( new InputStreamReader( serialPort.getInputStream ) )
  Stream.continually( stream.read ).foreach(
    ( str : Int ) =>
    {
      val ch = str.asInstanceOf[ Char ]

      if( ch == '\n' )
      {
        //println( buf.result() )
        //process( buf.result() )
        buf.clear()
        num += 1
      }
      else
      {
        buf += ch
      }

      if( num % 10000 == 0 )
      {
        count += 1

        println(s"${System.currentTimeMillis} : Count = ${count * 10000}")
      }
    }
  )
}
