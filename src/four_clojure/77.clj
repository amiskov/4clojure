(ns four-clojure.77
  (:require [clojure.test :as t]))

;; Anagram Finder
;; Difficulty:	Medium
;; Topics:
;;
;; Write a function which finds all the anagrams in a vector of words. A word `x` is an anagram of word `y`
;; if all the letters in `x` can be rearranged in a different order to form `y`. Your function should return
;; a set of sets, where each sub-set is a group of words which are anagrams of each other. Each sub-set
;; should have at least two words. Words without any anagrams should not be included in the result.

; Group words by sorted sequence of their letters (key is the sorted sequence of letters, value is the vector of
; words composed from those letters).
; Than take those vectors of words and make sets from them.
; Remove sets with no anagram (consists of only one word).
; Make a final set of sets.
(defn anagram-finder [words]
  (->> (group-by sort words)
       (vals)
       (map set)
       (filter #(> (count %) 1))
       (set)))

(t/testing "anagram finder"
  (t/is (= (anagram-finder ["meat" "mat" "team" "mate" "eat"])
           #{#{"meat" "team" "mate"}}))
  (t/is (= (anagram-finder ["veer" "lake" "item" "kale" "mite" "ever"])
           #{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}})))

(comment
  ; First attempt
  (defn anagram-finder [words]
    (let [anagram? #(and (= (count %1) (count %2)) (= (set %1) (set %2)))
          anagrams-for (fn [word] (->> words (filter #(anagram? word %)) (set)))]
      (->> words
           (map #(anagrams-for %))
           (filter #(> (count %) 1))
           (set)))))
