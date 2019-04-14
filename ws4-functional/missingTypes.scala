def cons [X] (x:X, xs:List[X]) : List[X] = x::xs

def append [X] (xs:List[X] ys:List[X] : List[X] = xs:::ys

def map [X,Y] (xs:List[X], f:X=>Y) : List[Y] = {
  xs match {
    case Nil   => Nil
    case y::ys => f(y) :: map(ys, f)
  }
}

def filter [X] (xs:List[X], f:Boolean) : List[X] = {
  xs match {
    case Nil            => Nil
    case y::ys if f (y) => y :: filter (ys, f)
    case _::ys          => filter (ys, f)
  }
}

def exists [X] (xs:List[X] p:X=>Boolean) : Boolean = {
  xs match {
    case Nil       => false
    case (x :: xs) => p (x) || exists (xs, p)
  }
}

def flatten [X] (xss:List[List[X]]) : List[X] = for (xs <- xss; x <- xs) yield x