(ns problems.42
  (:require [clojure.test :as t]))

;; 42. Factorial Fun
(defn fact
  [n]
  (apply * (range n 1 -1)))

(t/are [i r]
  (= (fact i) r)
  1 1
  3 6
  5 120
  8 40320)
