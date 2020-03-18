(ns four-clojure.67
  (:require [clojure.test :as t]))

;; Prime Numbers
;; Difficulty:	Medium
;; Topics:	primes
;;
;; Write a function which returns the first x number of prime numbers.

(defn prime?
  "Returns true if the given number divides with zero remainder only by itself and 1."
  [n]
  (not-any? #(= 0 (rem n %))
            (range 2 (inc (/ n 2)))))

(defn primes
  "Returns a vector of n prime numbers."
  [n]
  (->> (iterate inc 2)
       (filter prime?)
       (take n)))

(t/testing "is prime number"
  (t/is (true? (prime? 3)))
  (t/is (true? (prime? 541))))

(t/testing "is not prime number"
  (t/is (false? (prime? 100)))
  (t/is (false? (prime? 4))))

(t/testing "N prime numbers"
  (t/is (= (primes 2) [2 3]))
  (t/is (= (primes 5) [2 3 5 7 11]))
  (t/is (= (last (primes 100)) 541)))

(comment
  ; First version
  (defn prime? [n]
    (let [dividers (range 2 (inc (/ n 2)))]
      (not-any? (fn [d] (= 0 (rem n d))) dividers)))

  (defn primes [n]
    (loop [acc []
           i 2]
      (if (= n (count acc))
        acc
        (if (prime? i)
          (recur (conj acc i) (inc i))
          (recur acc (inc i)))))))

