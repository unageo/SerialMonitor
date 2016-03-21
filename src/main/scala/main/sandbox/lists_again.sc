val start = System.nanoTime()
(1 to 1000000).foreach
{
  x =>
    var y = x % 7
    y = x % 8
    y = x % 9
    y = x % 10
}

println( ( System.nanoTime() - start ) / 1000 )