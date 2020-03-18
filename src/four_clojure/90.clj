(ns four-clojure.90)

; 90. Cartesian Product
;(def cp ; first try
;(fn [s1 s2]
;  (set
;    (mapcat
;      (fn [el1]
;        (map #(vector el1 %) s2)
;        ) s1)))
;  )

; After reviewing solutions
(def cp
  #(set (for [x %1, y %2] [x y])))

(cp #{1 2 3} #{4 5})

(= (cp #{1 2 3} #{4 5})
   #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]})

(= (cp #{"ace" "king" "queen"} #{"♠" "♥" "♦" "♣"})
   #{["ace" "♠"] ["ace" "♥"] ["ace" "♦"] ["ace" "♣"]
     ["king" "♠"] ["king" "♥"] ["king" "♦"] ["king" "♣"]
     ["queen" "♠"] ["queen" "♥"] ["queen" "♦"] ["queen" "♣"]})

(= 300 (count (cp (into #{} (range 10))
                  (into #{} (range 30)))))
