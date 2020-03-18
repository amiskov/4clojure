(ns four-clojure.29)

;; 29. Get the Caps
(= (#(apply str (re-seq #"[A-Z]" %))
     "HeLlO, WoRlD!")
   "HLOWRD")

