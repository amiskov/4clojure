(ns problems.145)


;; 145
(def ans-145 [1 5 9 13 17 21 25 29 33 37])
(= ans-145
   (for [x (range 40)
         :when (= 1 (rem x 4))]
     x))
(= ans-145 (for [x (iterate #(+ 4 %) 0)
                 :let [z (inc x)]
                 :while (< z 40)]
             z))
(= ans-145 (for [[x y] (partition 2 (range 20))]
             (+ x y)))

(partition 2 (range 20))
