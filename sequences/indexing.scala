// Don't retrieve first element by index

// Before
seq(0)

// After
seq.head


// Don't retrieve last element by index

// Before
seq(seq.length - 1)

// After
seq.last


// Don't check index bounds explicitly

// Before
if (i < seq.length) Some(seq(i)) else None

// After
seq.lift(i)


// Don't emulate "headOption"

// Before
if (seq.nonEmpty) Some(seq.head) else None
seq.lift(0)

// After
seq.headOption


// Don't emulate "lastOption"

// Before
if (seq.nonEmpty) Some(seq.last) else None
seq.lift(seq.length - 1)

// After
seq.lastOption


// Be careful with "indexOf" and "lastIndexOf" argument types

// Before
Seq(1, 2, 3).indexOf("1") // compilable
Seq(1, 2, 3).lastIndexOf("2") // compilable

//  After
Seq(1, 2, 3).indexOf(1)
Seq(1, 2, 3).lastIndexOf(2)


// Don't construct indices range manually

// Before
Range(0, seq.length)

// After
seq.indices


// Don't zip collection with its indices manually

// Before
seq.zip(seq.indices)

// After
seq.zipWithIndex


// Use "IndexedSeq" instance as a function value

// Before (seq: IndexedSeq[T])
Seq(1, 2, 3).map(seq(_))

// After
Seq(1, 2, 3).map(seq)
