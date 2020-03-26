(ns problems.56
  (:require [clojure.test :as t]))

;; Find Distinct Items
;; Difficulty: Medium
;; Topics: seqs, core-functions
;; Special Restrictions: distinct
;;
;; Write a function which removes the duplicates from a sequence.
;; Order of the items must be maintained.

(defn remove-duplicates [xs]
  (reduce
    (fn [acc x]
      (if (some #(= x %) acc)
        acc
        (conj acc x)))
    []
    xs))

(t/testing "removing duplicates"
  (t/is (= (remove-duplicates [1 2 1 3 1 2 4]) [1 2 3 4]))
  (t/is (= (remove-duplicates [:a :a :b :b :c :c]) [:a :b :c]))
  (t/is (= (remove-duplicates '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3])))
  (t/is (= (remove-duplicates (range 50)) (range 50))))
