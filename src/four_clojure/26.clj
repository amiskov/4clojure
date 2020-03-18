(ns four-clojure.26
  (:require [clojure.test :as t]))

;; Fibonacci Sequence
;; Difficulty:	Easy
;; Topics:	    Fibonacci seqs
;;
;; Write a function which returns the first X fibonacci numbers.

; 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 ...
; For the explanation see https://blog.klipse.tech/clojurescript/2016/04/19/fibonacci.html
(defn fib [n]
  (->> (iterate
         (fn [[a b]]
           [b (+' a b)])
         [1 1])
       (map first)
       (take n)))

(t/testing "first X Fibonacci numbers"
  (t/is (= (fib 3) '(1 1 2)))
  (t/is (= (fib 6) '(1 1 2 3 5 8)))
  (t/is (= (fib 8) '(1 1 2 3 5 8 13 21))))

; `+` can't operate with really big integers, but Clojure has a set alternative
; operators (less efficient than usual), like +', inc', *', ... which automatically transform
; Ints to BitInts if necessary:
; https://clojure.org/reference/data_structures#_longs

; Also found `reduction` function in solutions:
(fn [n]
  (map first
       (reductions (fn [[a b] _] [b (+ a b)])
                   [1 1]
                   (range 1 n))))

