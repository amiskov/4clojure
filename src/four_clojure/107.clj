(ns four-clojure.107)

; 107. Simple closures

; my version
(def exp
  #(partial (fn [exp base] (apply * (repeat exp base))) %))

(= 256 ((exp 2) 16) ((exp 8) 2))
(= [1 8 27 64] (map (exp 3) [1 2 3 4]))

; other version
(= [1 2 4 8 16] (map #((fn [exp] (fn [base] (repeat exp base)) %) 2) [0 1 2 3 4]))
