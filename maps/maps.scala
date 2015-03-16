// Don't use "lift" instead of "get"

// Before
map.lift(n)

// After
map.get(n)


// Don't call "get" with "getOrElse" separately

// Before
map.get(k).getOrElse(z)

// After
map.getOrElse(k, z)


// Don't extract keys manually

// Before
map.map(_._1)
map.map(_._1).toSet
map.map(_._1).toIterator

// After
map.keys
map.keySet
map.keysIterator


// Don't extract values manually

// Before
map.map(_._2)
map.map(_._2).toIterator

// After
map.values
map.valuesIterator


// Avoid using "filterKeys"

// Before
map.filterKeys(p)

// After
map.filter(p(_._1))


// Avoid using "mapValues"

// Before
map.mapValues(f)

// After
map.map(f(_._2))


// Don't filter out keys manually

// Before
map.filterKeys(!seq.contains(_))

// After
map -- seq


// Use assignment operators to reassign a map

// Before
map = map + x -> y
map1 = map1 ++ map2
map = map - x
map = map -- seq

// After
map += x -> y
map1 ++= map2
map -= x
map --= seq
