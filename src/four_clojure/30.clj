(ns four-clojure.30)

;; 30. Compress a Sequence
(= (reduce
     #(if (= %2 (last %1))
        %1
        (concat %1 (list %2))) '() [1 1 2 3 3 2 2 3])
   '(1 2 3 2 3))

