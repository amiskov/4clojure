(ns four-clojure.46
  (:require [clojure.test :as t]))

;; Flipping out
;; Difficulty:	Medium
;; Topics:	    higher-order-functions
;;
;; Write a higher-order function which flips the order of the arguments of an input function.

(def flip #(fn [& args] (apply % (reverse args))))

(t/testing "flipping the order of the arguments"
  (t/is (= 3 ((flip nth) 2 [1 2 3 4 5])))
  (t/is (= true ((flip >) 7 8)))
  (t/is (= 4 ((flip quot) 2 8)))
  (t/is (= [1 2 3] ((flip take) [1 2 3 4 5] 3))))
