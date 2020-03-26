(ns problems.40
  (:require [clojure.test :as t]))

;; Interpose a Seq
;; Difficulty: Easy
;; Topics: seqs core-functions
;; Special Restrictions: interpose
;;
;; Write a function which separates the items of a sequence by an arbitrary value.

(defn intrp [v vs]
  (butlast (mapcat list vs (repeat v))))

;; `interpose` is like `interleave` where value in a second list is the same
(defn intrp [v vs]
  (butlast (interleave vs (repeat v))))

(t/testing "interpose"
  (t/is (= (intrp 0 [1 2 3]) [1 0 2 0 3]))
  (t/is (= (apply str (intrp ", " ["one" "two" "three"])) "one, two, three"))
  (t/is (= (intrp :z [:a :b :c :d]) [:a :z :b :z :c :z :d])))
