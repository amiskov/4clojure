(ns problems.44
  (:require [clojure.test :as t]))

;; Rotate Sequence
;; Difficulty:	Medium
;; Topics:	    seqs
;;
;; Write a function which can rotate a sequence in either direction.

(defn rotate [pivot s]
  (let [c (count s)
        idx (if (or (< pivot 0) (>= pivot c))
              (mod pivot c)
              pivot)]
    (->> s
         (split-at idx)
         (reverse)
         (apply concat))))

(t/testing "rotate sequence"
  (t/is (= (rotate 2 [1 2 3 4 5]) '(3 4 5 1 2)))
  (t/is (= (rotate -2 [1 2 3 4 5]) '(4 5 1 2 3)))
  (t/is (= (rotate 6 [1 2 3 4 5]) '(2 3 4 5 1)))
  (t/is (= (rotate 1 '(:a :b :c)) '(:b :c :a)))
  (t/is (= (rotate -4 '(:a :b :c)) '(:c :a :b))))
