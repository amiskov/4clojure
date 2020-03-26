(ns problems.134)

;; http://www.4clojure.com/problem/134
;; Write a function which, given a key and map,
;; returns true iff the map contains an entry with that key and its value is nil.

(defn nil-key
  "Returns true iff the map `m` contains an entry with key `k` and it's value is nil."
  [k m]
  (nil? (get m k :not-found)))

(true? (nil-key :a {:a nil :b 2}))
(false? (nil-key :b {:a nil :b 2}))
(false? (nil-key :c {:a nil :b 2}))

;; Explanation:
;; The third parameter for `get` function is the value which is
;; returned if key is not presented in the map.

;; Also we could use (:key :hap-map "default if not found") to get value by key:
(false? (#(nil? (%1 %2 :not-found)) :c {:a nil :b 2}))