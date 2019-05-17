/*
Which of foo1, …, foo7 has a nested function whose 
lifetime extends beyond the lifetime of its enclosing
 unction (foo1, …, foo7)? That is, which of the nested 
 functions can run when the enclosing function 
 (foo1, …, foo7) has returned?
*/

object NestedFunctions {
    def foo1 [X] (xs:List[X]) : List[X] = {
        def aux (us:List[X], vs:List[X]) : List = {
            us match {
                case Nil => vs
                case w::ws => aux(ws, w::vs)
            }
        }
    }
    aux(xs, Nil) 
}