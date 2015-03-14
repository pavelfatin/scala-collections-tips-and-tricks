// Don't compare option values with "None"

// Before
option == None
option != None

// After
option.isEmpty
option.isDefined


// Don't resort to pattern matching to check value existence

// Before
option match {
    case Some(_) => true
    case None => false
}

// After
option.isDefined


// Don't negate value existence-related properties

// Before
!option.isEmpty
!option.isDefined
!option.nonEmpty

// After
seq.isDefined
seq.isEmpty
seq.isEmpty


// Don't check value existence to process value

// Before
if (option.isDefined) {
    val v = option.get
    ...
}

// After
option.foreach { v =>
    ...
}
