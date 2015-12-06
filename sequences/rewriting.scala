// Merge consecutive "filter" calls

// Before
seq.filter(p1).filter(p2)

// After
seq.filter(x => p1(x) && p2(x))


// Merge consecutive "map" calls

// Before
seq.map(f).map(g)

// After
seq.map(f.andThen(g))


// Do sorting after filtering

// Before
seq.sorted.filter(p)

// After
seq.filter(p).sorted


// Don't reverse collection explicitly before calling "map"

// Before
seq.reverse.map(f)

// After
seq.reverseMap(f)


// Don't reverse collection explicitly to acquire reverse iterator

// Before
seq.reverse.iterator

// After
seq.reverseIterator


// Don't convert collection to a set to find distinct elements

// Before
seq.toSet.toSeq

// After
seq.distinct


// Don't emulate "slice"

// Before
seq.drop(x).take(y)

// After
seq.slice(x, x + y)


// Don't emulate "splitAt"

// Before
val seq1 = seq.take(n)
val seq2 = seq.drop(n)

// After
val (seq1, seq2) = seq.spiltAt(n)


// Don't emulate "span"

// Before
val seq1 = seq.takeWhile(p)
val seq2 = seq.dropWhile(p)

// After
val (seq1, seq2) = seq.span(p)


// Don't emulate "partition"

// Before
val seq1 = seq.filter(p)
val seq2 = seq.filterNot(p)

// After
val (seq1, seq2) = seq.partition(p)


// Don't emulate "takeRight"

// Before
seq.reverse.take(n).reverse

// After
seq.takeRight(n)


// Don't emulate "flatten"

// Before (seq: Seq[Seq[T]])
seq.reduce(_ ++ _)
seq.fold(Seq.empty)(_ ++ _)
seq.flatMap(identity)

// After
seq.flatten


// Don't emulate "flatMap"

// Before (f: A => Seq[B])
seq.map(f).flatten

// After
seq.flatMap(f)


// Don't use "map" when result is ignored

// Before
seq.map(...) // the result is ignored

// After
seq.foreach(...)


// Don't create temporary collections

// Transformation reduces collection to a single value.

// Before
seq.map(f).flatMap(g).filter(p).reduce(...)

// After
seq.view.map(f).flatMap(g).filter(p).reduce(...)


// Transformation produces a collection of the same class.

// Before
seq.map(f).flatMap(g).filter(p)

// After
seq.view.map(f).flatMap(g).filter(p).force


// Transformation creates a collection of different class.

// Before
seq.map(f).flatMap(g).filter(p).toList

// After
seq.view.map(f).flatMap(g).filter(p).toList

// Using "breakOut"

seq.map(f).toList(collection.breakOut): List[T]


// Use assignment operators to reassign a sequence

// Before
seq = seq :+ x
seq = x +: seq
seq1 = seq1 ++ seq2
seq1 = seq2 ++ seq1

// After
seq :+= x
seq +:= x
seq1 ++= seq2
seq1 ++:= seq2
