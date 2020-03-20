(ns four-clojure.49
  (:require [clojure.test :as t]))

;; Split a sequence
;; Difficulty: Easy
;; Topics: seqs core-functions
;; Special Restrictions: split-at
;;
;; Write a function which will split a sequence into two parts.

(defn splt [i vs]
  (vector (take i vs) (drop i vs)))

(t/testing "splitting colleciton"
  (t/is (= (splt 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]]))
  (t/is (= (splt 1 [:a :b :c :d]) [[:a] [:b :c :d]]))
  (t/is (= (splt 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]])))

(comment
  ; First attempt
  (defn splt [i vs]
    (loop [idx 1
           acc []
           f (first vs)
           r (rest vs)]
      (if (>= idx i)
        [(conj acc f) r]
        (recur (inc idx) (conj acc f) (first r) (rest r))))))
