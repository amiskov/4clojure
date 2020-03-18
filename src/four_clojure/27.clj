(ns four-clojure.27)

;; 27. Palindrome Detector
(true? (#(= (seq %) (reverse %)) "racecar"))
