val x = 1 + 2
val y = 2 + 3

val x = { print("foo"); 1 + 2 }
val y = { print("bar"); 2 + 3 }

seq filter { x => builder.append(x); x > 3 } headOption

seq find { x => builder.append(x); x > 3 }

seq.foreach(builder.append)
seq.filter(_ > 3).headOption

seq.foreach(builder.append)
seq.find(x > 3)
