(ns problems.100)

; 100. Least Common Multiple

(defn lcm [& nums]
  (let [m (apply max nums)]
    (loop [i 1]
      (let [mul (* i m)]
        (if (every? #(zero? (rem mul %)) nums)
          mul
          (recur (inc i)))))))

(defn lcm
  "Returns the Least Common Multiple of the given numbers."
  [& nums]
  (let [max-num (apply max nums)
        max-num-seq (iterate (partial + max-num) max-num)
        lcm? (fn [mul] (not-every? #(zero? (rem mul %)) nums))]
    (first (drop-while lcm? max-num-seq))))

(defn lcm-for [& nums]
  (let [m (apply max nums)]
    (first
      (for [i (iterate inc 1)
            :let [mul (* i m)]
            :when (every? #(zero? (rem mul %)) nums)
            ]
        mul))))
(and
  (== (lcm 5 3 7) 105)
  (== (lcm 7 5/7 2 3/5) 210)
  (== (lcm 3/4 1/6) 3/2)
  (== (lcm 1/3 2/5) 2))
