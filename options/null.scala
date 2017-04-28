// Don't compare value with "null" explicitly to construct an "Option"

// Before
if (v != null) Some(v) else None

// After
Option(v)


// Don't use "Option(...)" with a constant

// Before
Option("constant")

// After
Some("constant")


// Don't provide "null" as an explicit alternative

// Before
option.getOrElse(null)

// After
option.orNull
