(ns four-clojure.16)

;; 16
(= (#(str "Hello, " % "!") "Dave") "Hello, Dave!")

(#(str "Hello, " %) "Dave")

