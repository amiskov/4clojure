(ns problems.54
  (:require [clojure.test :as t]))

;; Partition a Sequence
;; Difficulty: Medium
;; Topics: seqs core-functions
;; Special Restrictions: partition, partition-all
;;
;; Write a function which returns a sequence of lists of x items each.
;; Lists of less than x items should not be returned.

(defn prttn [n ns]
  (loop [acc []
         ns ns]
    (if (< (count ns) n)
      acc
      (recur (conj acc (take n ns))
             (drop n ns)))))

(t/testing "partition"
  (t/is (= (prttn 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8))))
  (t/is (= (prttn 2 (range 8)) '((0 1) (2 3) (4 5) (6 7))))
  (t/is (= (prttn 3 (range 8)) '((0 1 2) (3 4 5)))))
