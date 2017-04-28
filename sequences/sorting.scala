// Don't sort by a property manually

// Before
seq.sortWith(_.property <  _.property)

// After
seq.sortBy(_.property)


// Don't sort by identity manually

// Before
seq.sortBy(identity)
seq.sortWith(_ < _)

// After
seq.sorted


// Perform reverse sorting in one step

// Before
seq.sorted.reverse
seq.sortBy(_.property).reverse
seq.sortWith(f(_, _)).reverse

// After
seq.sorted(Ordering[T].reverse)
seq.sortBy(_.property)(Ordering[T].reverse)
seq.sortWith(!f(_, _))


// Don't use sorting to find the smallest element

// Before
seq.sorted.head
seq.sortBy(_.property).head

// After
seq.min
seq.minBy(_.property)


// Don't use sorting to find the largest element

// Before
seq.sorted.last
seq.sortBy(_.property).last

// After
seq.max
seq.maxBy(_.property)
