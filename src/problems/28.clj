(ns problems.28
  (:require [clojure.test :as t]))

;; Flatten a Sequence
;; Difficulty: Easy
;; Topics: seqs core-functions
;; Special Restrictions: flatten
;;
;; Write a function which flattens a sequence.
;; See also `resources/28.js`

(defn fltn [ns]
  (letfn [(reducer [acc n]
            (if (sequential? n)
              (concat acc (fltn n))
              (concat acc (list n))))]
    (reduce reducer () ns)))

;; puredanger's solution:
(fn f [s] (if (coll? s) (mapcat f s) [s]))

(t/testing "flattening a sequence"
  (t/is (= (fltn '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6)))
  (t/is (= (fltn ["a" ["b"] "c"]) '("a" "b" "c")))
  (t/is (= (fltn '((((:a))))) '(:a))))

(comment
  ; First attempt
  (defn fltn [s]
    ((fn aux [s acc]
       (if (empty? s)
         acc
         (let [f (first s)]
           (if (sequential? f)
             (aux (rest s) (concat acc (aux f '())))
             (aux (rest s) (concat acc (list f)))))))
     s '())))
