(ns problems.66)

; 66. Greatest Common Divisor
(def gcd
  (fn [a b]
    (loop [[s g] (sort [a b])]
      (let [r (rem g s)]
        (if (= r 0)
          s
          (recur [r s]))))))

(= (gcd 2 4) 2)
(= (gcd 10 5) 5)
(= (gcd 10 5) 5)
(= (gcd 1023 858) 33)

