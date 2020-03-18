(ns four-clojure.20)

;; 20. Penultimate Element
(= ((comp last butlast)
    (list 1 2 3 4 5))
   4)

(= (#(second (into '() %))
     (list 1 2 3 4 5))
   4)
