(ns four-clojure.35)

;; http://www.4clojure.com/problem/35
(= 7 (let [x 5] (+ 2 x)))
(= 7 (let [x 3, y 10] (- y x)))
(= 7 (let [x 21] (let [y 3] (/ x y))))


;; http://www.4clojure.com/problem/36
(= 10 (let [y 3 x 7] (+ x y)))
(= 4 (let [y 3 z 1] (+ y z)))
(= 1 (let [z 1]  z))

;; http://www.4clojure.com/problem/28
;; Write a function which flattens a sequence.
(defn my-flatten
  "Flattens sequence `se`."
  [se acc]
  (let [f (first se)
        r (rest se)]
    (cond
      (seq? f) ())))


   
  
      

(my-flatten '((1 2) 3 [4 [5 6]]) '())

(= (my-flatten '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))
(= (["a" ["b"] "c"]) '("a" "b" "c"))
(= (my-flatten '((((:a))))) '(:a))
