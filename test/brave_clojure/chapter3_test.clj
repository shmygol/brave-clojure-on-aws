(ns brave-clojure.chapter3-test
    "Tests for the exercises from Chapter 3"
    (:require [clojure.test :refer [deftest is testing]]
              [brave-clojure.chapter3 :as sut]))

(deftest exercise-1-test
  (testing "Returns foo"
    (is (= {:str "Just a simple string."
            :vector ["a" "b" "c"]
            :list '(1 "a" "b" 2 "a" :end)
            :hash-map {:key "value"}
            :hash-set #{"a" "b" "c"}}
           (sut/-handler {:exercise-number 1 :arguments []})))))

(deftest exercise-2-test
  (testing "Adds 100 to 0"
    (is (= 100
           (sut/-handler {:exercise-number 2 :arguments [0]}))))
  (testing "Adds 100 to a negative number"
    (is (= 0
           (sut/-handler {:exercise-number 2 :arguments [-100]})))
    (is (= 1
           (sut/-handler {:exercise-number 2 :arguments [-99]}))))
  (testing "Adds 100 to a positive number"
    (is (= 101
           (sut/-handler {:exercise-number 2 :arguments [1]})))
    (is (= 201
           (sut/-handler {:exercise-number 2 :arguments [101]})))
    (is (= 1201
           (sut/-handler {:exercise-number 2 :arguments [1101]}))))
  (testing "Adds 100 to a float number"
    (is (= 220.1
           (sut/-handler {:exercise-number 2 :arguments [120.1]})))
    (is (= 99.9
           (sut/-handler {:exercise-number 2 :arguments [-0.1]})))))

(deftest exercise-3-test
  (testing "Makes a function, which decrements by 1"
    (let [decrement-by-1 (sut/-handler {:exercise-number 3 :arguments [1]})]
      (is (= 0
             (decrement-by-1 1)))
      (is (= -1
             (decrement-by-1 0)))
      (is (= 9
             (decrement-by-1 10)))))
  (testing "Makes a function, which decrements by 0"
    (let [decrement-by-0 (sut/-handler {:exercise-number 3 :arguments [0]})]
      (is (= 1
             (decrement-by-0 1)))
      (is (= 0
             (decrement-by-0 0)))
      (is (= 10
             (decrement-by-0 10)))))
  (testing "Makes a function, which decrements by -1"
    (let [decrement-by-minus-1 (sut/-handler {:exercise-number 3 :arguments [-1]})]
      (is (= 2
             (decrement-by-minus-1 1)))
      (is (= 1
             (decrement-by-minus-1 0)))
      (is (= 11
             (decrement-by-minus-1 10))))))

(deftest exercise-4-test
  (testing "Returns foo"
    (is (= {:result "foo"}
           (sut/-handler {:exercise-number 4 :arguments []})))))

(deftest exercise-5-test
  (testing "Returns foo"
    (is (= {:result "foo"}
           (sut/-handler {:exercise-number 5 :arguments []})))))

(deftest exercise-6-test
  (testing "Returns foo"
    (is (= {:result "foo"}
           (sut/-handler {:exercise-number 6 :arguments []})))))
