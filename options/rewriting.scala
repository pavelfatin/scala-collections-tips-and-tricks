// Convert "map" with "getOrElse" to "fold"

// Before
option.map(f).getOrElse(z)

// After
option.fold(z)(f)


// Don't emulate "exists"

// Before
option.map(p).getOrElse(false)

// After
option.exists(p)


// Don't emulate "flatten"

// Before (option: Option[Option[T]])
option.getOrElse(None)

// After
option.flatten


// Don't convert option to sequence manually

// Before
option.map(Seq(_)).getOrElse(Seq.empty)
option.getOrElse(Seq.empty) // option: Option[Seq[T]]

// After
option.toSeq
