(ns four-clojure.96
  (:require [clojure.test :as t]))

;; Beauty is Symmetry
;; Difficulty:	Easy
;; Topics:	    trees
;;
;; Let us define a binary tree as "symmetric" if the left half of the tree is the mirror image of the right half
;; of the tree. Write a predicate to determine whether or not a given binary tree is symmetric.
;; (see [To Tree, or not to Tree](http://www.4clojure.com/problem/95) for a reminder on the tree representation we're using).

(defn to-set [s]
  (cond
    (not (sequential? s)) s
    (every? #(not (sequential? %)) s) (set s)
    :else (set (map to-set s))))

(defn sym-btree? [[_ left right :as t]]
  (= (to-set left) (to-set right)))

(t/testing "if binary tree is symmetric"
  (t/is (true? (sym-btree? '(:a (:b nil nil) (:b nil nil)))))
  (t/is (false? (sym-btree? '(:a (:b nil nil) nil))))
  (t/is (false? (sym-btree? '(:a (:b nil nil) (:c nil nil)))))
  (t/is (true? (sym-btree? [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]] [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])))
  (t/is (false? (sym-btree? [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]] [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]]))))
