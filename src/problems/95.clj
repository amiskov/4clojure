(ns problems.95
  (:require [clojure.test :as t]))

;; To Tree, or not to Tree
;; Difficulty:	Easy
;; Topics:	trees
;;
;; Write a predicate which checks whether or not a given sequence represents a binary tree.
;; Each node in the tree must have a value, a left child, and a right child.

(defn btree? [t]
  (if (not= (count t) 3)
    false
    (every?
      #(if (sequential? %)
         (btree? %)
         (not (false? %)))
      t)))

(t/testing "if sequence is binary tree"
  (t/is (true? (btree? '(:a (:b nil nil) nil))))
  (t/is (false? (btree? '(:a (:b nil nil)))))
  (t/is (true? (btree? [1 nil [2 [3 nil nil] [4 nil nil]]])))
  (t/is (false? (btree? [1 [2 nil nil] [3 nil nil] [4 nil nil]])))
  (t/is (true? (btree? [1 [2 [3 [4 nil nil] nil] nil] nil])))
  (t/is (false? (btree? [1 [2 [3 [4 false nil] nil] nil] nil])))
  (t/is (false? (btree? '(:a nil ())))))
