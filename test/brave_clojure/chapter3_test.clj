(ns brave-clojure.chapter3-test
    "Tests for the exercises from Chapter 3"
    (:require [clojure.test :refer [deftest is testing]]
              [brave-clojure.chapter3 :as sut]))

(deftest exercise-1-test
  (testing "Returns foo"
    (is (= {:result "foo"}
           (sut/-handler {:exercise-number 1 :exercise-arguments []})))))

(deftest exercise-2-test
  (testing "Returns foo"
    (is (= {:result "foo"}
           (sut/-handler {:exercise-number 2 :exercise-arguments []})))))

(deftest exercise-3-test
  (testing "Returns foo"
    (is (= {:result "foo"}
           (sut/-handler {:exercise-number 3 :exercise-arguments []})))))

(deftest exercise-4-test
  (testing "Returns foo"
    (is (= {:result "foo"}
           (sut/-handler {:exercise-number 4 :exercise-arguments []})))))

(deftest exercise-5-test
  (testing "Returns foo"
    (is (= {:result "foo"}
           (sut/-handler {:exercise-number 5 :exercise-arguments []})))))

(deftest exercise-6-test
  (testing "Returns foo"
    (is (= {:result "foo"}
           (sut/-handler {:exercise-number 6 :exercise-arguments []})))))
