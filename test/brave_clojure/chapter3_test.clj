(ns brave-clojure.chapter3-test
    "Tests for the exercises from Chapter 3"
    (:require [clojure.test :refer [deftest is testing]]
              [brave-clojure.chapter3 :as sut]
              [clojure.data]))

(defn is-no-diff
  "Test, that the diff between a and b is nil,
  otherwise print out things-only-in-a things-only-in-b"
  [expected actual]
  (let [actual-vs-expected-diff (clojure.data/diff expected actual)]
    (is (= nil (actual-vs-expected-diff 0) (actual-vs-expected-diff 1)))))

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
  (testing "Straightforward successful path"
    (is (= #{2 3}
           (sut/-handler {:exercise-number 4 :arguments [inc [1 2]]})))))

(deftest exercise-5-test
  (testing "Returns foo"
    (let [input [{:name "head" :size 3}
                 {:name "middle-eye" :size 1}
                 {:name "middle-ear" :size 1}
                 {:name "mouth" :size 1}
                 {:name "nose" :size 1}
                 {:name "neck" :size 2}
                 {:name "middle-shoulder" :size 3}
                 {:name "middle-arm" :size 3}
                 {:name "chest" :size 10}
                 {:name "back" :size 10}
                 {:name "middle-forearm" :size 3}
                 {:name "abdomen" :size 6}
                 {:name "middle-kidney" :size 1}
                 {:name "middle-hand" :size 2}
                 {:name "middle-knee" :size 2}
                 {:name "middle-thigh" :size 4}
                 {:name "middle-leg" :size 3}
                 {:name "middle-achilles" :size 3}
                 {:name "middle-foot" :size 2}]
          expected (hash-set {:name "head" :size 3}
                             {:name "middle-eye" :size 1}
                             {:name "right-upper-eye" :size 1}
                             {:name "right-lower-eye" :size 1}
                             {:name "left-lower-eye" :size 1}
                             {:name "left-upper-eye" :size 1}
                             {:name "middle-ear" :size 1}
                             {:name "right-upper-ear" :size 1}
                             {:name "right-lower-ear" :size 1}
                             {:name "left-lower-ear" :size 1}
                             {:name "left-upper-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "middle-shoulder" :size 3}
                             {:name "right-upper-shoulder" :size 3}
                             {:name "right-lower-shoulder" :size 3}
                             {:name "left-lower-shoulder" :size 3}
                             {:name "left-upper-shoulder" :size 3}
                             {:name "middle-arm" :size 3}
                             {:name "right-upper-arm" :size 3}
                             {:name "right-lower-arm" :size 3}
                             {:name "left-lower-arm" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "middle-forearm" :size 3}
                             {:name "right-upper-forearm" :size 3}
                             {:name "right-lower-forearm" :size 3}
                             {:name "left-lower-forearm" :size 3}
                             {:name "left-upper-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "middle-kidney" :size 1}
                             {:name "right-upper-kidney" :size 1}
                             {:name "right-lower-kidney" :size 1}
                             {:name "left-lower-kidney" :size 1}
                             {:name "left-upper-kidney" :size 1}
                             {:name "middle-hand" :size 2}
                             {:name "right-upper-hand" :size 2}
                             {:name "right-lower-hand" :size 2}
                             {:name "left-lower-hand" :size 2}
                             {:name "left-upper-hand" :size 2}
                             {:name "middle-knee" :size 2}
                             {:name "right-upper-knee" :size 2}
                             {:name "right-lower-knee" :size 2}
                             {:name "left-lower-knee" :size 2}
                             {:name "left-upper-knee" :size 2}
                             {:name "middle-thigh" :size 4}
                             {:name "right-upper-thigh" :size 4}
                             {:name "right-lower-thigh" :size 4}
                             {:name "left-lower-thigh" :size 4}
                             {:name "left-upper-thigh" :size 4}
                             {:name "middle-leg" :size 3}
                             {:name "right-upper-leg" :size 3}
                             {:name "right-lower-leg" :size 3}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-upper-leg" :size 3}
                             {:name "middle-achilles" :size 3}
                             {:name "right-upper-achilles" :size 3}
                             {:name "right-lower-achilles" :size 3}
                             {:name "left-lower-achilles" :size 3}
                             {:name "left-upper-achilles" :size 3}
                             {:name "middle-foot" :size 2}
                             {:name "right-upper-foot" :size 2}
                             {:name "right-lower-foot" :size 2}
                             {:name "left-lower-foot" :size 2}
                             {:name "left-upper-foot" :size 2})]
      (is-no-diff expected (sut/-handler {:exercise-number 5 :arguments [input]})))))

(deftest exercise-6-test
  (testing "Returns foo"
    (is (= {:result "foo"}
           (sut/-handler {:exercise-number 6 :arguments []})))))
