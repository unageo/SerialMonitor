package main.entity

/**
 * Created by geo on 3/27/16.
 */
case class AveragedRotation( xAvg : Double,
                             yAvg : Double,
                             zAvg : Double,
                             numReadings : Long,
                             firstReadingTime : Long,
                             lastReadingTime : Long )
