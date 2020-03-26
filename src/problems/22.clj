(ns problems.22
  (:require [clojure.test :as t]))

;; Difficulty:	Easy
;; Topics:	seqs core-functions
;;
;; Write a function which returns the total number of elements in a sequence.
;; `count` is prohibited!

(def count' #(apply + (map (constantly 1) %)))

(t/testing "count elements in a sequence"
  (t/is (= (count' '(1 2 3 3 1)) 5))
  (t/is (= (count' "Hello World") 11))
  (t/is (= (count' [[1 2] [3 4] [5 6]]) 3))
  (t/is (= (count' '(13)) 1))
  (t/is (= (count' '(:a :b :c)) 3)))

(comment
  ; With inner function with accumulator
  (= ((fn [seq]
        ((fn inner-count [seq acc]
           (if (empty? (rest seq))
             (inc acc)
             (inner-count
               (rest seq)
               (inc acc)))) seq 0))
      '(1 2 3 3 1)) 5)

  ; With reduce
  (= (reduce (fn [n _] (inc n)) 0 '(1 2 3 3 1)) 5)

  ; With apply and map
  (= (#(apply + (map (fn [_] 1) %))
       '(1 2 3 3 1))
     5))
