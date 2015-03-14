// Don't use "sameElements" to compare unordered collections

// Before
set1.sameElements(set2)

// After
set1 == set2


// Don't check element correspondence on unordered collections

// Before
set1.corresponds(set2)(p)

// After
???


// Don't compute set intersection manually

// Before
set1.filter(set2.contains)
set1.filter(set2)

// After
set1.intersect(set2) // or set1 & set2


// Don't compute set difference manually

// Before
set1.filterNot(set2.contains)
set1.filterNot(set2)

// After
set1.diff(set2) // or set1 &~ set2
