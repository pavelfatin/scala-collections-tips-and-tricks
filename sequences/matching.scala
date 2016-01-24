// Use partial function instead of function with pattern matching

// Before
seq.map {
  _ match {
    case P => ???
  }
}

// After
seq.map {
  case P => ???
}


// Convert "flatMap" with partial function to "collect"

// Before
seq.flatMap {
  case P => Seq(???)
  case _ => Seq.empty
}

// After
seq.collect {
  case P => ???
}


// Don't emulate "collectFirst"

// Before
seq.collect{case P => ???}.headOption

// After
seq.collectFirst{case P => ???}
