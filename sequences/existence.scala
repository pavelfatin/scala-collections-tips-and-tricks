// Don't use equality predicate to check element presence

// Before
seq.exists(_ == x)

//  After
seq.contains(x)


// Be careful with "contains" argument type

// Before
Seq(1, 2, 3).contains("1") // compilable

//  After
Seq(1, 2, 3).contains(1)


// Don't use inequality predicate to check element absence

// Before
seq.forall(_ != x)

// After
!seq.contains(x)


// Don't count occurrences to check existence

// Before
seq.count(p) > 0
seq.count(p) != 0
seq.count(p) == 0

//  After
seq.exists(p)
seq.exists(p)
!seq.exists(p)


// Don't resort to filtering to check existence

// Before
seq.filter(p).nonEmpty
seq.filter(p).isEmpty

// After
seq.exists(p)
!seq.exists(p)


// Don't resort to search to check existence

// Before
seq.find(p).isDefined
seq.find(p).isEmpty

// After
seq.exists(p)
!seq.exists(p)
