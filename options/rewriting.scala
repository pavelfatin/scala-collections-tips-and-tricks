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


// Don't convert option to sequence manually

// Before
option.map(Seq(_)).getOrElse(Seq.empty)
option.getOrElse(Seq.empty) // option: Option[Seq[T]]

// After
option.toSeq
