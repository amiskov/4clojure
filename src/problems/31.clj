(ns problems.31)

;; 31. Pack a Sequence
(= (partition-by identity [1 1 2 1 1 1 3 3])
   '((1 1) (2) (1 1 1) (3 3)))

; `partition-by` applies `identity` to each element of the vector
; and returns a new seq every time this value is different.
