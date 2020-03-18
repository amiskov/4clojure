(ns four-clojure.83)

;(def not-all-are-true? ; my solution
;  (fn [& all]
;    (boolean
;      (and
;        (not-every? true? all)
;        (some true? all)))))

; #(= #{true false} (set %&)) ; borkdude's

(= true (#(= #{true false} (set %&)) true true true false))
(= false (#(= #{true false} (set %&)) false false))
(= false (#(= #{true false} (set %&)) true true true))

(#(set %&) true true true false)
(#(do (prn %1 %2 %&) (set %&)) :a :b 1 2 :a :b)
