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
