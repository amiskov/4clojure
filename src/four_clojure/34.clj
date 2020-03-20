(ns four-clojure.34
  (:require [clojure.test :as t]))

;; Implement range
;; Difficulty: Easy
;; Topics: seqs core-functions
;; Special Restrictions: range
;;
;; Write a function which creates a list of all integers in a given range.

(defn rng [s e]
  (take (- e s) (iterate inc s)))

(t/testing "list of integer in a range [s, e)"
  (t/is (= (rng 1 4) '(1 2 3)))
  (t/is (= (rng -2 2) '(-2 -1 0 1)))
  (t/is (= (rng 5 8) '(5 6 7))))
