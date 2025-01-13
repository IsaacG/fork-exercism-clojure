(ns wordy-test
  (:require [clojure.test :refer [deftest testing is]]
            wordy))
{{#test_cases.answer}}
(deftest evaluate_test_{{idx}}
  (testing {{string description}}
    {{~#if error}}
    (is (thrown? IllegalArgumentException (wordy/evaluate {{string input.question}})))))
    {{else}}
    (is (= {{expected}} (wordy/evaluate {{string input.question}})))))
    {{/if~}}
{{/test_cases.answer~}}
