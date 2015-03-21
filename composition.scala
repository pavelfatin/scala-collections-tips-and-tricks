seq.filter(_ == x).headOption != None

// Via seq.filter(p).headOption -> seq.find(p)

seq.find(_ == x) != None

// Via option != None -> option.isDefined

seq.find(_ == x).isDefined

// Via seq.find(p).isDefined -> seq.exists(p)

seq.exists(_ == x)

// Via seq.exists(_ == x) -> seq.contains(x)

seq.contains(x)
