(ns brave-clojure.chapter4-test
    "Tests for the exercises from Chapter 4"
    (:require [clojure.test :refer [deftest is testing]]
              [brave-clojure.chapter4 :as sut]))

(deftest exercise-1-test
  (testing "Returns foo"
    (is (= {:result "foo"}
           (sut/-handler {:exercise-number 1 :arguments []})))))

(deftest exercise-2-test
  (testing "Returns foo"
    (is (= {:result "foo"}
           (sut/-handler {:exercise-number 2 :arguments []})))))

(deftest exercise-3-test
  (testing "Returns foo"
    (is (= {:result "foo"}
           (sut/-handler {:exercise-number 3 :arguments []})))))

(deftest exercise-4-test
  (testing "Returns foo"
    (is (= {:result "foo"}
           (sut/-handler {:exercise-number 4 :arguments []})))))
