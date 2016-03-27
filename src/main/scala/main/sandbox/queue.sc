import scala.collection.immutable.Queue

var q = Queue( 1, 2, 3, 4 )

q = q.enqueue( 55 )

q

q.dequeue

q = q.filter( _ > 2 )

q

