(ns four-clojure.97)

; 97. Pascal’s Triangle
(def pt
  (fn [n]
    (loop [i 1, acc [1]]
      (if (= i n)
        acc
        (recur (inc i)
               (mapv + (cons 0 acc) (conj acc 0))))))
  )

(= (map pt (range 1 6))
   [[1]
    [1 1]
    [1 2 1]
    [1 3 3 1]
    [1 4 6 4 1]])

(= (pt 11)
   [1 10 45 120 210 252 210 120 45 10 1])

