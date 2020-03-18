(ns four-clojure.21)

;; 21
;; Write a function which returns the total number of elements in a sequence.
(= (count '(1 2 3 3 1)) 5)
(defn my-count
  "Returns the total number of elements in a sequence."
  [seq]
  ((fn inner-count [seq acc]
     (if (empty? (rest seq))
       (inc acc)
       (inner-count
         (rest seq)
         (inc acc)))) seq 0))

(= (my-count '(1 2 3 3 1)) 5)

; My solution with inner function with accumulator
(= ((fn [seq]
      ((fn inner-count [seq acc]
         (if (empty? (rest seq))
           (inc acc)
           (inner-count
             (rest seq)
             (inc acc)))) seq 0))
    '(1 2 3 3 1)) 5)

; With reduce
(= (reduce (fn [n _] (inc n)) 0 '(1 2 3 3 1))
   5)

; With apply and map
(= (#(apply + (map (fn [_] 1) %))
     '(1 2 3 3 1))
   5)

(apply + '(1 1 1 1 1))

(map (constantly 1) '(1 2 10 20))

; My solution after reviewing other's
(= (#(apply + (map (constantly 1) %))
     '(1 2 3 3 1))
   5)


