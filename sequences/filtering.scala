// Don't negate filter predicate

// Before
seq.filter(!p)

// After
seq.filterNot(p)


// Don't resort to filtering to count elements

// Before
seq.filter(p).length

// After
seq.count(p)


// Don't use filtering to find first occurrence

// Before
seq.filter(p).headOption

// After
seq.find(p)
