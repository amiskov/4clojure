(ns problems.39
  (:require [clojure.test :as t]))

;; Interleave Two Seqs
;; Difficulty: Easy
;; Topics: seqs core-functions
;; Special Restrictions: interleave
;;
;; Write a function which takes two sequences and returns the first item from each,
;; then the second item from each, then the third, etc.

(def intrlv #(mapcat list %1 %2))

(t/testing "interleave"
  (t/is (= (intrlv [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c)))
  (t/is (= (intrlv [1 2] [3 4 5 6]) '(1 3 2 4)))
  (t/is (= (intrlv [1 2 3 4] [5]) [1 5]))
  (t/is (= (intrlv [30 20] [25 15]) [30 25 20 15])))

