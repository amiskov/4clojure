(ns four-clojure.51)

; 51. Advanced Destructuring
(let [[& all] [1 2 3 4 5 6 7]] all)

(= [1 2 [3 4 5] [1 2 3 4 5]]
   (let [[a b & c :as d] [1 2 3 4 5]] [a b c d]))
