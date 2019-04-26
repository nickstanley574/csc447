```
// 3.1 Scheme - Looping in Scheme
(let loop([n 1])
  (if (< n 5)
    (begin
      (display (string-append (number->string n) " potato\n"  ))
      (loop (+ n 1)))))

//3.2 Scheme - Looping in Scheme with a Function
(define (potato n)
  (if (> n 4)
  ()
  (begin 
    (display (string-append (number->string n) " potato\n"))
    (potato (+ n 1)))))

(potato 1)

// 3.4 Scheme - Counting Values
(define countingValuesHelpter lst lowNum highNum count)
  (if (equal? xs) )

(define (countingValuesHelper lst low high count)
  (if (equal? lst ())
    count
    (if (and (<= low (car lst)) (<= (car lst)  high))
      (countingValuesHelper(cdr lst) low high (+ 1 count))
      (countingValuesHelper(cdr lst) low high count ))))

(define (countingValues lst low high)
  (countingValuesHelper lst low high 0))

(countingValues '(1 2 3 4 5 6 7 8 9 10 11 12) 5 10)
---
BiwaScheme Interpreter version 0.6.4
Copyright (C) 2007-2014 Yutaka HARA and the BiwaScheme team
   
=> 6


```
