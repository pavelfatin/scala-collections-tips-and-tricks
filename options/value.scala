// Don't compare option values with "None"

// Before
option == None
option != None

// After
option.isEmpty
option.isDefined


// Don't compare option values with "Some"

// Before
option == Some(v)
option != Some(v)

// After
option.contains(v)
!option.contains(v)


// Don't rely on instance type to check value existence

// Before
option.isInstanceOf[Some[_]]

// After
option.isDefined


// Don't resort to pattern matching to check value existence

// Before
option match {
    case Some(_) => true
    case None => false
}

option match {
    case Some(_) => false
    case None => true
}

// After
option.isDefined
option.isEmpty


// Don't negate value existence-related properties

// Before
!option.isEmpty
!option.isDefined
!option.nonEmpty

// After
seq.isDefined
seq.isEmpty
seq.isEmpty
