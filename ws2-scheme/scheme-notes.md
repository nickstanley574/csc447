
## 4.2.1 Examples
```
SISC (1.16.6)
#;> (* 3 (+ 5 6))
33
#;> (+ 5 6)
11
#;> ( * 2 3 4 5)
120
```
## 4.2.2 Exercise

Translate the arithmetic expression 10 / 2 + 3 * 2 into Scheme using the standard rules of precedence for arithmetic operators. Test your answer by running it in the Scheme interpreter.

10 / 2 + 3 * 2 = 11

```
#;> (+ (/ 10 2) (* 3 2))
11
```
## 4.3.1 Examples

```
nstanley@nstanley-ud-ws-01:~/Dropbox/github/574/cheatsheets$ sisc
SISC (1.16.6)
#;> "hello"
"hello"
#;> (number->string 123)
"123"
#;> (string->number "123")
123
#;> (string->number "12x3")
#f
#;> (string-append "hello" "world")
"helloworld"
#;> (string-append "he" "ll" "o")
"hello"
#;> (string-length "hello")
5
#;> (string->list "hello")
(#\h #\e #\l #\l #\o)
#;> (string-ref "hello" 1)
#\e
#;> 
```
## 4.3.2 Exercise

Translate the following Java expression into Scheme. Then test your Scheme expression in the SISC REPL.

`(((1 + 2) * 3) + 4) + " = " + (16 - 3)`

```
#;> ( string-append (number->string (+ (* (+ 1 2) 3) 4)) " = " (number->string (- 16 3)))
"13 = 13"
```

## 4.4.1 Examples
```
SISC (1.16.6)
#;> (define (f n) (+ n 1))
#;> (f 10)
11
#;> (define (f n) (+ n 2))
#;> (f 10)
12
#;> (define x 10)
#;> (f x)
12
```
## 4.4.2 Exercise
Define a Scheme function `greet` that takes a string `s` as an argument and returns the result of concatenating `hello`, a space, and the string `s`.

`(define (greet s) (string-append "hello " s))`

## 4.5.1 Examples

The true and false Boolean values are written as #t and #f in Scheme. The and, or, and not functions operate on Boolean values in the usual way.
```
#;> (and #f #f)
#f
#;> (and #t #f)
#f
#;> (and #t #t)
#t
#;> (or #t #f)
#t
#;> (not #t)
#f
#;> (not #f)
#t
```
The functions number? and string? can be used to whether an argument is a number or string respectively.
```
#;> 
#;> (number? #f)
#f
#;> (number? 5)
#t
#;> (number? "5")
#f
#;> (string? #f)
#f
#;> (string? 5)
#f
#;> (string? "5")
#t
#;> 
```
The function = can be used to test equality of numbers. The usual inequality operators on numbers are also available as functions.
```
#;> (= 5 2)
#f
#;> (= 2 2)
#t
#;> (<= 5 2)
#f
#;> (> 5 2)
#t
```
The function string=? can be used to test equality of strings. The lexicographic (dictionary order) operators are also available as functions.
```
#;> (string=? "hello" "world")
#f
#;> (string<=? "hello" "world")
#t
#;> (string<=? "hello" "he")
#f
```
The generic equality functions eq?, eqv?, and equal? can be used for numeric and string types as well as other types.
```
#;> (equal? 5 10)
#f
```
q? is true when the arguments point to the same location in memory. It is useful for lists, where there is guaranteed to be a unique representation of the empty list in memory, but its behavior is implementation dependent on other types, so better to use eqv? rather than eq?.
```
#;> (if (= (+ 2 2) 4) "that's good" "that's strange")
"that's good"
#;> (string-append "that's " (if (= (+ 2 2) 4) "good" "strange"))
"that's good"
```
## 4.5.2 Exercise
Write a Scheme function `check-password` (note that hyphens are allowed as characters in Scheme identifiers!) that takes a string as a parameter. The function should return the string "pass, friend" if its parameter is equal to the password "Rosebud". Otherwise it should return the string "get out of here".
```
#;> (define (check-password s)  (if (string=? s "Rosebud") "pass, friend"  "get out of here")) 
#;> check-password test
#<procedure check-password>
#;> Error: undefined variable 'test'.
#;> check-password "test"
#<procedure check-password>
#;> "test"
#;> (check-password "test")
"get out of here"
#;> (check-password "Rosebud")
"pass, friend"
```
## 4.6.2 Exercise
Define a Scheme function triangle that finds the nth triangular number, i.e.,
- (triangle 0) returns 0 = 0
- (triangle 1) returns 1 = 0+1
- (triangle 2) returns 3 = 0+1+2
- (triangle 3) returns 6 = 0+1+2+3
- (triangle 4) returns 10 = 0+1+2+3+4

```
(define (triangle n)
  (if (= n 0)
  0
  (+ n (triangle (- n 1)))
  ) 
)
   (triangle 0)
=> 0
   (triangle 1)
=> 1
   (triangle 2)
=> 3
   (triangle 3)
=> 6
   (triangle 4)
=> 10
```
## 4.7.1 Examples

```
nstanley@nstanley-ud-ws-01:~$ sisc
SISC (1.16.6)
#;> ()
()
#;> cons
#<native procedure cons>
#;> (cons 3)
Error in cons: incorrect number of arguments to procedure.
console:3:1: <from call to cons>
---------------------------
To enable more detailed stack tracing, set the dynamic parameter max-stack-trace-depth to a non-zero value, e.g. 16.
---------------------------
Some stack trace entries may have been suppressed. To see all entries set the dynamic parameter suppressed-stack-trace-source-kinds to '().
#;> (cons 3 ())
(3)
#;> (cons 2 (cons 3 ()))
(2 3)
#;> (cons 1 (cons 2 (cons 3 ())))
(1 2 3)
#;> (quote (1 2 3))
(1 2 3)
#;> '(1 2 3)
(1 2 3)
#;> (list 1 2 3)
(1 2 3)
#;> (list 1 (+ 1 1) 3)
(1 2 3)
#;> '(1 (+ 1 1) 3)
(1 (+ 1 1) 3)
#;> (append '(1 2) '(3 4 5))
(1 2 3 4 5)
#;> (cons 0 (append '(1 2) '(3 4 5)))
(0 1 2 3 4 5)
#;> (length (cons 10 (cons 11 (cons 12 ()))))
3
#;> (length '(10 11 12))
3
#;> (car '(1 2 3))
1
#;> (cdr '(1 2 3))
(2 3)
#;> (car (cdr '(1 2 3)))
2
#;> (cadr '(1 2 3))
2
#;> (reverse '(1 2 3))
(3 2 1)
```
## 4.7.2 Exercise
Write 10 different Scheme expressions that evaluate to the list of numbers 10, 11, 12, 13.
1. `'(10 11 12 13)`
2. `(cons 10 (cons 11 (cons 12 ( cons 13 ()))))`
3. `(reverse '(13 12 11 10))`
4. `(append '(10 11) '(12 13))`
5. `(list (+ 9 1) (+ 10 1) (+ 11 1) (+ 12 1))`
6. `(cdr '(9 10 11 12 13))`
7. `(quote (10 11 12 13))`
8. `(cons 10 '(11 12 13))`
9. `(append '() '(10 11 12 13))`
10. `(list 10 11 12 13)`

## 4.8.1 Examples
```
(define (my-length l) 
  (if (equal? l ())
     0
     (+ 1 (my-length (cdr l)))))
#;> (my-length '(10 11 12 13))
4
```
## 4.8.2 Exercise
Define a Scheme function sum that sums the numbers in a list. Your function should use recursion.
```
#;> (define (list-sum l)  (if (equal? l ()) 0 (+ (car l)  (list-sum (cdr l)))))
#;> (list-sum '(10 11 12 13))
46
#;> (list-sum '(1 2 3))
6
#;> 
```



 









# The Scheme Programming Language (R. Kent Dybvig)
https://www.scheme.com/tspl4/

## Chapter 2. Getting Started

### Section 2.1. Interacting with Scheme

 The simplest interaction with Scheme follows a "read-evaluate-print" cycle. A program (often called a read-evaluate-print loop, or REPL) reads each expression you type at the keyboard, evaluates it, and prints its value.

 If you have access to an interactive Scheme system, it might be a good idea to start it up now and type in the examples as you read. One of the simplest Scheme expressions is a string constant. Try typing `"Hi Mom!"` (including the double quotes) in response to the prompt. The system should respond with "Hi Mom!"; the value of any constant is the constant itself.

`"Hi Mom!" => "Hi Mom!"`

Be careful not to miss any single quotes ( `'` ), double quotes, or parentheses. If you left off a single quote in the last expression, you probably received a message indicating that an exception has occurred. Just try again. If you left off a closing parenthesis or double quote, the system might still be waiting for it.

Next, let's try defining a procedure.
```
(define square
  (lambda (n)
    (* n n)))
```

The procedure square computes the square n^2 of any number n. For now it suffices to say that `define` establishes variable bindings, `lambda` creates procedures, and `*` names the multiplication procedure. All structured forms are enclosed in parentheses and written in **prefix notation**, i.e., the operator precedes the arguments.

```
#;> (square 5)
25
#;> (square -200) 
40000
#;> (square 0.5) 
0.25
#;> (square -1/2) 
1/4
```

### Section 2.2. Simple Expressions

The simplest Scheme expressions are constant data objects, such as strings, numbers, symbols, and lists. Scheme supports other object types, but these four are enough for many programs. We saw some examples of strings and numbers in the preceding section.

We often say an object is quoted when it is enclosed in a quote expression.

A `quote` expression is not a procedure application, since it inhibits the evaluation of its subexpression. It is an entirely different syntactic form. Scheme supports several other syntactic forms in addition to procedure applications and `quote` expressions. 

You might wonder why applications and variables share notations with lists and symbols. The shared notation allows Scheme programs to be represented as Scheme data, simplifying the writing of interpreters, compilers, editors, and other tools in Scheme.

Now let's discuss some Scheme procedures for manipulating lists. There are two basic procedures for taking lists apart: `car` and `cdr` (pronounced could-er). `car` returns the first element of a list, and `cdr` returns the remainder of the list.

Just as `car` and `cdr` are often used as nouns, `cons` is often used as a verb. Creating a new list by adding an element to the beginning of a list is referred to as consing the element onto the list.

An improper list is printed in **dotted-pair** notation, with a period, or dot, preceding the final element of the list.

### Section 2.3. Evaluating Scheme Expressions

 Here, procedure is an expression representing a Scheme procedure, and arg1 ... argn are expressions representing its arguments

 This rule works for procedure applications but not for quote expressions because the subexpressions of a procedure application are evaluated, whereas the subexpression of a quote expression is not. The evaluation of a quote expression is more similar to the evaluation of constant objects. The value of a quote expression of the form (quote object) is simply object.

 ### Section 2.4. Variables and Let Expressions

Suppose *expr* is a Scheme expression that contains a variable var. Suppose, additionally, that we would like *var* to have the value val when we evaluate expr. For example, we might like `x` to have the value `2` when we evaluate `(+ x 3)` Or, we might want `y` to have the value `3` when we evaluate `(+ 2 y)`. The following examples demonstrate how to do this using Scheme's let syntactic form:
```
#;> (let ((x 2)) (+ x 3))
5
#;> (let ((y 3)) (+ 2 y)
)
5
#;> (let ((x 2) (y 3)) (+ x y))
5
```
The let syntactic form includes a list of variable-expression pairs, along with a sequence of expressions referred to as the body of the let. 

Since expressions in the first position of a procedure application are evaluated no differently from other expressions, a let-bound variable may be used there as well.
```
#;> (let ([f +]) (f 2 3))
5

#;> (let ([f +] [x 2]) (f x 3))
5
```

When nested let expressions bind the same variable, only the binding created by the inner let is visible within its body.
```
(let ([x 1])
  (let ([x (+ x 1)])
    (+ x x)))
4
```
The outer let expression binds x to 1 within its body, which is the second let expression. The inner let expression binds x to (+ x 1) within its body, which is the expression (+ x x). What is the value of (+ x 1)? Since (+ x 1) appears within the body of the outer let but not within the body of the inner let, the value of x must be 1 and hence the value of (+ x 1) is 2. What about (+ x x)? It appears within the body of both let expressions. Only the inner binding for x is visible, so x is 2 and (+ x x) is 4.
