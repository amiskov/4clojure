(ns problems.33)

;; 33. Replicate a Sequence
(= ((fn [c n] (map #(repeat n) c)) [1 2 3] 2)
   '(1 1 2 2 3 3))
