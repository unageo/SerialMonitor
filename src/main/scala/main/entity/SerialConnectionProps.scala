package main.scala.main.entity

/**
 * Created by geo on 3/6/16.
 *
 * These are the properties needed to connect to a serial port on
 * the machine.
 *
 * @param portPath    Location of port on machine
 *                    ex: /dev/ttyACM0 for Arduino on linux
 *
 * @param baudRate    Rate at which the device will be sending data
 *                    ex: for the Arduino possible baud rates can be found
 *                        at https://www.arduino.cc/en/serial/begin
 *
 * @param timeOut     Milliseconds to wait until timeout
 */
case class SerialConnectionProps( portPath : String,
                                  baudRate : Int,
                                  timeOut  : Int )