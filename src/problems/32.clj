(ns problems.32)

;; 32. Duplicate a Sequence
(= (mapcat #(conj '() % %) [1 2 3]) '(1 1 2 2 3 3))
(= (#(interleave % %) [1 2 3]) '(1 1 2 2 3 3))

(interleave '(1 2 3) [:a :b :c] #{\e \f \j})

