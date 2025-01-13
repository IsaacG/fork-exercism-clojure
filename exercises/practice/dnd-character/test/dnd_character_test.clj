(ns dnd-character-test
  (:require [clojure.test :refer [deftest testing is]]
            dnd-character))

(deftest modifier_test_1
  (testing "ability modifier - ability modifier for score 3 is -4"
    (is (= -4 (dnd-character/modifier 3)))))

(deftest modifier_test_2
  (testing "ability modifier - ability modifier for score 4 is -3"
    (is (= -3 (dnd-character/modifier 4)))))

(deftest modifier_test_3
  (testing "ability modifier - ability modifier for score 5 is -3"
    (is (= -3 (dnd-character/modifier 5)))))

(deftest modifier_test_4
  (testing "ability modifier - ability modifier for score 6 is -2"
    (is (= -2 (dnd-character/modifier 6)))))

(deftest modifier_test_5
  (testing "ability modifier - ability modifier for score 7 is -2"
    (is (= -2 (dnd-character/modifier 7)))))

(deftest modifier_test_6
  (testing "ability modifier - ability modifier for score 8 is -1"
    (is (= -1 (dnd-character/modifier 8)))))

(deftest modifier_test_7
  (testing "ability modifier - ability modifier for score 9 is -1"
    (is (= -1 (dnd-character/modifier 9)))))

(deftest modifier_test_8
  (testing "ability modifier - ability modifier for score 10 is 0"
    (is (= 0 (dnd-character/modifier 10)))))

(deftest modifier_test_9
  (testing "ability modifier - ability modifier for score 11 is 0"
    (is (= 0 (dnd-character/modifier 11)))))

(deftest modifier_test_10
  (testing "ability modifier - ability modifier for score 12 is +1"
    (is (= 1 (dnd-character/modifier 12)))))

(deftest modifier_test_11
  (testing "ability modifier - ability modifier for score 13 is +1"
    (is (= 1 (dnd-character/modifier 13)))))

(deftest modifier_test_12
  (testing "ability modifier - ability modifier for score 14 is +2"
    (is (= 2 (dnd-character/modifier 14)))))

(deftest modifier_test_13
  (testing "ability modifier - ability modifier for score 15 is +2"
    (is (= 2 (dnd-character/modifier 15)))))

(deftest modifier_test_14
  (testing "ability modifier - ability modifier for score 16 is +3"
    (is (= 3 (dnd-character/modifier 16)))))

(deftest modifier_test_15
  (testing "ability modifier - ability modifier for score 17 is +3"
    (is (= 3 (dnd-character/modifier 17)))))

(deftest modifier_test_16
  (testing "ability modifier - ability modifier for score 18 is +4"
    (is (= 4 (dnd-character/modifier 18)))))

(deftest ability_test_1
  (testing "random ability is within range"
    (is (<= 3 (dnd-character/ability) 18))))

(deftest ability_test_2
  (testing "ability is generated randomly"
    (is (>= (count (set (repeatedly 100 #(dnd-character/ability)))) 5))))

(deftest character_test_1
  (testing "random character is valid - strength"
    (is (<= 3 (:strength (dnd-character/character)) 18))))

(deftest character_test_2
  (testing "random character is valid - dexterity"
    (is (<= 3 (:dexterity (dnd-character/character)) 18))))

(deftest character_test_3
  (testing "random character is valid - charisma"
    (is (<= 3 (:charisma (dnd-character/character)) 18))))

(deftest character_test_4
  (testing "random character is valid - wisdom"
    (is (<= 3 (:wisdom (dnd-character/character)) 18))))

(deftest character_test_5
  (testing "random character is valid - intelligence"
    (is (<= 3 (:intelligence (dnd-character/character)) 18))))

(deftest character_test_6
  (testing "random character is valid - constitution"
    (is (<= 3 (:constitution (dnd-character/character)) 18))))

(deftest character_test_7
  (testing "random character is valid - hitpoints"
    (let [char (dnd-character/character)
          expected (+ 10 (dnd-character/modifier (:constitution char)))]
      (is (= expected (:hitpoints char))))))

(deftest character_test_8
  (testing "random character is generated randomly"
    (is (>= (count (set (repeatedly 100 #(dnd-character/character)))) 5))))
