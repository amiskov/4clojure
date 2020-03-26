(ns problems.38
  (:require [clojure.test :as t]))

;; Maximum value
;; Difficulty:	Easy
;; Topics:	    core-functions
;;
;; Write a function which takes a variable number of parameters and returns the maximum value.

(defn max-val [& args]
  (last (sort args)))

(t/testing "max value"
  (t/is (= (max-val 1 8 3 4) 8))
  (t/is (= (max-val 30 20) 30))
  (t/is (= (max-val 45 67 11) 67)))

