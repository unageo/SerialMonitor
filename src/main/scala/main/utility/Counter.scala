package main.utility

/**
 * Created by geo on 3/22/16.
 */
case class Counter( modInterval : Int, intervalFunction : Int => Unit )
{
  var counter = 0
  var intervalsHit = 0
  def hit() =
  {
    counter += 1
    if( counter % modInterval == 0 )
    {
      intervalsHit += 1
      intervalFunction( intervalsHit )
    }
  }

}
