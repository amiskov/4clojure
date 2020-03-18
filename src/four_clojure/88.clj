(ns four-clojure.88
  (:require [clojure.test :as t]))

; 88. Symmetric Difference
(defn sd1 [s1 s2]
  (let [diff (fn [s1 s2] (set (filter #(not (s1 %)) s2)))]
    (into (diff s1 s2) (diff s2 s1))))

; it works for me, but not works in 4clojure website
(defn sd2 [s1 s2]
  (let [diff #(set (filter (partial (complement %1)) %2))]
    (into (diff s1 s2)
          (diff s2 s1))))

; with set lib everything is simpler
(defn sd3 [s1 s2]
  (into (clojure.set/difference s1 s2)
        (clojure.set/difference s2 s1)))

(= (sd1 #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7})
(= (sd1 #{:a :b :c} #{}) #{:a :b :c})
(= (sd1 #{} #{4 5 6}) #{4 5 6})
(= (sd1 #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]})

(defn check-88 [f]
  (t/are [s1 s2 res]
    (= (f s1 s2) res)
    #{1 2 3 4 5 6} #{1 3 5 7} #{2 4 6 7}
    #{:a :b :c} #{} #{:a :b :c}
    #{} #{4 5 6} #{4 5 6}
    #{[1 2] [2 3]} #{[2 3] [3 4]} #{[1 2] [3 4]}))

(and (check-88 sd1)
     (check-88 sd2)
     (check-88 sd3))
