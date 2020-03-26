(ns problems.55
  (:require [clojure.test :as t]))

;; Count Occurrences
;; Difficulty: Medium
;; Topics: seqs, core-functions
;; Special Restrictions: frequencies
;;
;; Write a function which returns a map containing the number of occurences
;; of each distinct item in a sequence.

;; Initial
(defn fqs [xs]
  (->> xs
       (group-by identity)
       (map (fn [[k v]] {k (count v)}))
       (apply conj)))

;; After review
(defn fqs [s]
  (into {}
        (for [[k v] (group-by identity s)]
          [k (count v)])))

(t/testing "frequencies"
  (t/is (= (fqs [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1}))
  (t/is (= (fqs [:b :a :b :a :b]) {:a 2, :b 3}))
  (t/is (= (fqs '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2})))
