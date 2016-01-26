// Don't calculate sum manually

// Before
seq.reduce(_ + _)
seq.fold(z)(_ + _)

// After
seq.sum
seq.sum + z


// Don't calculate product manually

// Before
seq.reduce(_ * _)
seq.fold(z)(_ * _)

// After
seq.product
seq.product * z


// Don't search for the smallest element manually

// Before
seq.reduce(_ min _)
seq.fold(z)(_ min _)

// After
seq.min
z min seq.min


// Don't search for the largest element manually

// Before
seq.reduce(_ max _)
seq.fold(z)(_ max _)

// After
seq.max
z max seq.max


// Don't emulate "forall"

// Before
seq.foldLeft(true)((x, y) => x && p(y))
!seq.map(p).contains(false)

// After
seq.forall(p)


// Don't emulate "exists"

// Before
seq.foldLeft(false)((x, y) => x || p(y))
seq.map(p).contains(true)

// After
seq.exists(p)


// Don't emulate "map"

// Before
seq.foldLeft(Seq.empty)((acc, x) => acc :+ f(x))
seq.foldRight(Seq.empty)((x, acc) => f(x) +: acc)

// After
seq.map(f)


// Don't emulate "filter"

// Before
seq.foldLeft(Seq.empty)((acc, x) => if (p(x)) acc :+ x else acc)
seq.foldRight(Seq.empty)((x, acc) => if (p(x)) x +: acc else acc)

// After
seq.filter(p)


// Don't emulate "reverse"

// Before
seq.foldLeft(Seq.empty)((acc, x) => x +: acc)
seq.foldRight(Seq.empty)((x, acc) => acc :+ x)

// After
seq.reverse
