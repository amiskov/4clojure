(ns four-clojure.58
  (:require [clojure.test :as t]))

;; Function Composition
;; Difficulty: Medium
;; Topics: higher-order-functions, core-functions
;; Special Restrictions: comp
;;
;; Write a function which allows you to create function compositions.
;; The parameter list should take a variable number of functions,
;; and create a function that applies them from right-to-left.

(defn compose [& fns]
  (let [fns (reverse fns)]
    (fn [& args]
      (reduce
        (fn [acc f]
          (f acc))
        (apply (first fns) args)
        (rest fns)))))

(t/testing "function composition"
  (t/is (= [3 2 1] ((compose rest reverse) [1 2 3 4])))
  (t/is (= 5 ((compose (partial + 3) second) [1 2 3 4])))
  (t/is (= true ((compose zero? #(mod % 8) +) 3 5 7 9)))
  (t/is (= "HELLO" ((compose #(.toUpperCase %) #(apply str %) take) 5 "hello world"))))

