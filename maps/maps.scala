// Don't search for a value manually

// Before
map.find(_._1 == k).map(_._2)

// After
map.get(k)


// Don't use "get" when a raw value is needed

// Before
map.get(k).get

// After
map(k) 


// Don't use "lift" instead of "get"

// Before
map.lift(k)

// After
map.get(k)


// Don't call "get" with "getOrElse" separately

// Before
map.get(k).getOrElse(z)

// After
map.getOrElse(k, z)


// Use "Map" instance as a function value

// Before (map: Map[Int, T])
Seq(1, 2, 3).map(map(_))

// After
Seq(1, 2, 3).map(map)


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


// Be careful with "filterKeys"

// Before
map.filterKeys(p)

// After
map.filter(p(_._1))


// Unambiguous synonym

type MapView[A, +B] = Map[A, B]

implicit class MapExt[A, +B](val map: Map[A, B]) extends AnyVal {
  def withKeyFilter(p: A => Boolean): MapView[A, B] =
    map.filterKeys(p)
}


// Helper method

def get(k: T) = if (p(k)) map.get(k) else None


// Be careful with "mapValues"

// Before
map.mapValues(f)

// After
map.map(f(_._2))


// Unambiguous synonym
	
type MapView[A, +B] = Map[A, B]

implicit class MapExt[A, +B](val map: Map[A, B]) extends AnyVal {
  def withValueMapper[C](f: B => C): MapView[A, C] =
    map.mapValues(f)
}


// Helper method

def get(k: T) = map.get(k).map(f)


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
