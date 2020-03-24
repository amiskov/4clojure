(ns four-clojure.53
  (:require [clojure.test :as t]
            [clojure.core.reducers :as r]))

;; Longest Increasing Sub-Seq
;; Difficulty: Hard
;; Topics: seqs
;;
;; Given a vector of integers, find the longest consecutive sub-sequence  of increasing numbers.
;; If two sub-sequences have the same length, use the one that occurs first.
;; An increasing sub-sequence must have a length of 2 or greater to qualify.

(defn longest [ns]
  (->> (map #(vector (- %2 %1) [%1 %2]) ns (rest ns))
       (partition-by (fn [[k _]] k))
       (filter #(let [[k _] (first %)] (= k 1)))
       (map #(distinct (mapcat second %)))
       (sort-by count >)
       (first)
       (vec)))

(t/testing "longest consecutive sub-sequence"
  (t/is (= (longest [1 0 1 2 3 0 4 5]) [0 1 2 3]))
  (t/is (= (longest [5 6 1 3 2 7]) [5 6]))
  (t/is (= (longest [2 3 3 4 5]) [3 4 5]))
  (t/is (= (longest [7 6 5 4]) [])))