(ns four-clojure.41)

;; 41. Drop Every Nth Item
(#(->> (partition-all %2 %1)
       (map (fn [n] (take (dec %2) n)))
       (flatten))
  [1 2 3 4 5 6 7 8] 3)

; `partition-all`, unlike `partition`, could have less than `n` items
; in the last part. `partition` has strictly `n` elements in each part.
