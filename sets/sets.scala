// Don't use "sameElements" to compare unordered collections

// Before
set1.sameElements(set2)

// After
set1 == set2


// Use "Set" instance as a function value

// Before (set: Set[Int])
Seq(1, 2, 3).filter(set(_))
Seq(1, 2, 3).filter(set.contains)

// After
Seq(1, 2, 3).filter(set)


// Don't compute set intersection manually

// Before
set1.filter(set2)

// After
set1.intersect(set2) // or set1 & set2


// Don't compute set difference manually

// Before
set1.filterNot(set2)

// After
set1.diff(set2) // or set1 &~ set2
