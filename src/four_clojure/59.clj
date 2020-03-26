(ns four-clojure.59
  (:require [clojure.test :as t]))

;; Juxtaposition
;; Difficulty: Medium
;; Topics: higher-order-functions, core-functions
;; Special Restrictions: juxt
;;
;; Take a set of functions and return a new function that takes a variable number of arguments
;; and returns a sequence containing the result of applying each function left-to-right to the argument list.

(defn juxtaposition [& fns]
  (fn [& args]
    (mapv #(apply % args) fns)))

(t/testing "juxtaposition"
  (t/is (= [21 6 1] ((juxtaposition + max min) 2 3 5 1 6 4)))
  (t/is (= ["HELLO" 5] ((juxtaposition #(.toUpperCase %) count) "hello")))
  (t/is (= [2 6 4] ((juxtaposition :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10}))))

(comment
  ; With reduce
  (defn juxtaposition [& fns]
    (fn aux [& args]
      (reduce
        (fn [acc f]
          (conj acc (apply f args)))
        []
        fns)))
  )
