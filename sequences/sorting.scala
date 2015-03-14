// Don't sort by a property manually

// Before
seq.sortWith(_.property <  _.property)

// After
seq.sortBy(_.property)


// Don't sort by identity manually

// Before
seq.sortBy(it => it)
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
