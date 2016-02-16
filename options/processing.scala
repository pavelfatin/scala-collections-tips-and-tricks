// Don't emulate "getOrElse"

// Before
if (option.isDefined) option.get else z

option match {
  case Some(it) => it
  case None => z
}

// After
option.getOrElse(z)


// Don't emulate "orElse"
if (option1.isDefined) option1 else option2

option1 match {
  case Some(it) => Some(it)
  case None => option2
}

// After
option1.orElse(option2)


// Don't emulate "exists"

// Before
option.isDefined && p(option.get)

if (option.isDefined) p(option.get) else false

option match {
  case Some(it) => p(it)
  case None => false
}

// After
option.exists(p)


// Don't emulate "forall"

// Before
option.isEmpty || (option.isDefined && p(option.get))

if (option.isDefined) p(option.get) else true

option match {
  case Some(it) => p(it)
  case None => true
}

// After
option.forall(p)


// Don't emulate "contains"

// Before
option.isDefined && option.get == x

if (option.isDefined) option.get == x else false

option match {
  case Some(it) => it == x
  case None => false
}

// After
option.contains(x)


// Don't emulate "foreach"

// Before
if (option.isDefined) f(option.get)

option match {
  case Some(it) => f(it)
  case None =>
}

// After
option.foreach(f)


// Don't emulate "filter"

// Before
if (option.isDefined && p(option.get)) option else None

option match {
  case Some(it) && p(it) => Some(it)
  case _ => None
}

// After
option.filter(p)


// Don't emulate "map"

// Before
if (option.isDefined) Some(f(option.get)) else None

option match {
  case Some(it) => Some(f(it))
  case None => None
}

// After
option.map(f)


// Don't emulate "flatMap"

// Before (f: A => Option[B])
if (option.isDefined) f(option.get) else None

option match {
  case Some(it) => f(it)
  case None => None
}

// After
option.flatMap(f)
