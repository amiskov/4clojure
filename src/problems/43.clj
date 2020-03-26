(ns problems.43
  (:require [clojure.test :as t]))

;; Reverse Interleave
;; Difficulty:	Medium
;; Topics:	    seqs
;;
;; Write a function which reverses the interleave process into x number of subsequences.

(defn reverse-interleave [ns n]
  (->> (partition n ns)
       (apply map list)))

; The idea is to create lists from each nth element:
; (apply map list '((1 2 3) (4 5 6)))
; => ((1 4) (2 5) (3 6))

(t/testing "reverse interleave"
  (t/is (= (reverse-interleave '(0 1 2 3 4 5 6 7 8) 3) '((0 3 6) (1 4 7) (2 5 8))))
  (t/is (= (reverse-interleave [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6))))
  (t/is (= (reverse-interleave (range 9) 3) '((0 3 6) (1 4 7) (2 5 8))))
  (t/is (= (reverse-interleave (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))))

(comment
  ; first try
  (defn append-each-nth
    "Appends 0, then (0 + n), then (0 + n + n), then (0 + n + n + ...) to the acc until n is <= (count ns)."
    [ns n start]
    (loop [acc '()
           idx start]
      (if (>= idx (count ns))
        (reverse acc)
        (recur (cons (nth ns idx) acc) (+ idx n)))))

  (t/is (= (append-each-nth '(0 1 2 3 4 5 6 7 8) 3 0)
           '(0 3 6)))
  (t/is (= (append-each-nth '(0 1 2 3 4 5 6 7 8) 3 1)
           '(1 4 7)))
  (t/is (= (append-each-nth '(0 1 2 3 4 5 6 7 8) 3 2)
           '(2 5 8)))

  (defn ri [ns n]
    (loop [acc '()
           idx 0]
      (if (>= (count acc) n)
        (reverse acc)
        (recur (cons (append-each-nth ns n idx) acc)
               (inc idx))))))

