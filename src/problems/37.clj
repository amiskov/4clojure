(ns problems.37)

;; 37
(= "ABC" (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))

