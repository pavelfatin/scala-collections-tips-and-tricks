// Don't rely on "==" to compare array contents

// Before
array1 == array2

// After
array1.sameElements(array2)


// Don't check equality between collections in different categories

// Before
seq == set

// After
seq.toSet == set


// Don't use "sameElements" to compare ordinary collections

// Before
seq1.sameElements(seq2)

// After
seq1 == seq2


// Don't check equality correspondence manually

// Before
seq1.corresponds(seq2)(_ == _)

// After
seq1 == seq2
