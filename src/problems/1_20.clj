(ns problems.1-20
  (:require [clojure.test :as t]))

;; 1. Nothing but the Truth
(= true true)

;; 2. Simple Math
(= (- 10 (* 2 3)) 4)

;; 3. Intro to Strings
(= "HELLO WORLD" (.toUpperCase "hello world"))

;; 4. Intro to Lists
(= (list :a :b :c) '(:a :b :c))

;; 5. Lists: conj
(def p5 '(1 2 3 4))
(= p5 (conj '(2 3 4) 1))
(= p5 (conj '(3 4) 2 1))

;; 6. Intro to Vectors
(= [:a :b :c] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))

;; 7. Vectors: conj
(def p7 [1 2 3 4])
(= p7 (conj [1 2 3] 4))
(= p7 (conj [1 2] 3 4))

;; 8. Intro to Sets
(def p8 #{:a :b :c :d})
(= p8 (set '(:a :a :b :c :c :c :c :d :d)))
(= p8 (clojure.set/union #{:a :b :c} #{:b :c :d}))

;; 9. Sets: conj
(= #{1 2 3 4} (conj #{1 4 3} 2))

;; 10. Intro to Maps
(def p10 20)
(= p10 ((hash-map :a 10, :b 20, :c 30) :b))
(= p10 (:b {:a 10, :b 20, :c 30}))

;; 11. Maps: conj
(= {:a 1, :b 2, :c 3} (conj {:a 1} {:b 2} [:c 3]))

;; 12. Intro to Sequences
(def p12 3)
(= p12 (first '(3 2 1)))
(= p12 (second [2 3 4]))
(= p12 (last (list 1 2 3)))

;; 13. Sequences: rest
(= [20 30 40] (rest [10 20 30 40]))

;; 14. Intro to Functions
(def p14 8)
(= p14 ((fn add-five [x] (+ x 5)) 3))
(= p14 ((fn [x] (+ x 5)) 3))
(= p14 (#(+ % 5) 3))
(= p14 ((partial + 5) 3))

; Not so anonymous function may be useful in stack traces and recursive calls:
(fn add-five [x] (+ x 5))

;; 15. Double Down
(def p15 (partial * 2))
(= (p15 2) 4)
(= (p15 3) 6)
(= (p15 11) 22)
(= (p15 7) 14)

;; 16. Hello World
(defn p16 [name] (str "Hello, " name "!"))
(t/testing "personalized greetings"
           (t/is (= (p16 "Dave") "Hello, Dave!"))
           (t/is (= (p16 "Jenn") "Hello, Jenn!"))
           (t/is (= (p16 "Rhea") "Hello, Rhea!")))

;; 17. Sequences: map
(= '(6 7 8) (map #(+ % 5) '(1 2 3)))

;; 18. Sequences: filter
(= '(6 7) (filter #(> % 5) '(3 4 5 6 7)))

;; 19. Last Element
(def p19 #(nth % (dec (count %))))
(t/testing "returning the last element of the sequence"
           (t/is (= (p19 [1 2 3 4 5]) 5))
           (t/is (= (p19 '(5 4 3)) 3))
           (t/is (= (p19 ["b" "c" "d"]) "d")))

;; 20. Penultimate Element
(def p20 (comp last butlast))
(= (p20 (list 1 2 3 4 5)) 4)
(= (p20 ["a" "b" "c"]) "b")
(= (p20 [[1 2] [3 4]]) [1 2])

; `comp` is for function composition. It works right-to-left:
((comp str /) 2 3)
; => "2/3"
; ((comp / str) 2 3)
; => Error

