(ns dnd-character-test
  (:require [clojure.test :refer [deftest testing is]]
            dnd-character))
{{#test_cases.modifier}}
(deftest modifier_test_{{idx}}
  (testing {{string description}}
    (is (= {{expected}} (dnd-character/modifier {{input.score}})))))
{{/test_cases.modifier}}
(deftest ability_test_1
  (testing "random ability is within range"
    (is (<= 3 (dnd-character/ability) 18))))

(deftest ability_test_2
  (testing "ability is generated randomly"
    (is (>= (count (set (repeatedly 100 #(dnd-character/ability)))) 5))))
{{#test_cases.character}}
(deftest character_test_{{idx}}
  (testing {{string description}}
    (is (<= 3 (:{{ability}} (dnd-character/character)) 18))))
{{/test_cases.character}}
(deftest character_test_7
  (testing "random character is valid - hitpoints"
    (let [char (dnd-character/character)
          expected (+ 10 (dnd-character/modifier (:constitution char)))]
      (is (= expected (:hitpoints char))))))

(deftest character_test_8
  (testing "random character is generated randomly"
    (is (>= (count (set (repeatedly 100 #(dnd-character/character)))) 5))))
