// Use partial function instead of function with pattern matching

// Before
seq.map {
  _ match {
    case P => ??? // x N 
  }
}

// After
seq.map {
  case P => ??? // x N
}


// Convert "flatMap" with partial function to "collect"

// Before
seq.flatMap {
  case P => Seq(???) // x N
  case _ => Seq.empty
}

// After
seq.collect {
  case P => ??? // x N
}


// Convert "match" to "collect" when the result is a collection

// Before
v match {
  case P => Seq(???) // x N
  case _ => Seq.empty
}

// After
Seq(v) collect {
  case P => ??? // x N
}


// Don't emulate "collectFirst"

// Before
seq.collect{case P => ???}.headOption

// After
seq.collectFirst{case P => ???}

