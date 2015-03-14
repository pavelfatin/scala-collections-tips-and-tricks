// Prefer "length" to "size" for arrays

// Before
array.size

// After
array.length


// Don't negate emptiness-related properties

// Before
!seq.isEmpty
!seq.nonEmpty

// After
seq.nonEmpty
seq.isEmpty


// Don't compute length for emptiness check

// Before
seq.length > 0
seq.length != 0
seq.length == 0

// After
seq.nonEmpty
seq.nonEmpty
seq.isEmpty


// Don't compute length for emptiness check

// Before
seq.length > 0
seq.length != 0
seq.length == 0

// After
seq.nonEmpty
seq.nonEmpty
seq.isEmpty
