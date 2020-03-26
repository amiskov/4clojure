(ns problems.21
  (:require [clojure.test :as t]))

;; Nth Element
;; Difficulty:	Easy
;; Topics:	    seqs core-functions
;;
;; Write a function which returns the Nth element from a sequence.

(defn find-nth [s n]
  (first (drop n s)))

(t/testing "find nth element in the sequence"
  (t/is (= (find-nth '(4 5 6 7) 2) 6))
  (t/is (= (find-nth [:a :b :c] 0) :a))
  (t/is (= (find-nth [1 2 3 4] 1) 2))
  (t/is (= (find-nth '([1 2] [3 4] [5 6]) 2) [5 6])))

(comment
  ; First attempt
  (defn find-nth [seq n]
    (if (zero? n)
      (first seq)
      (find-nth (rest seq) (dec n)))))
