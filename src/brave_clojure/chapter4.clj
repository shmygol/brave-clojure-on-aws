(ns brave-clojure.chapter4
  "Exercises from Chapter 4"
  (:gen-class
    :methods [^:static [handler [java.util.Map] java.util.Map]]))

(defn exercise-1
  "1. Description for the exercise"
  []
  {:result "foo"})

(defn exercise-2
  "2. Description for the exercise"
  []
  {:result "foo"})

(defn exercise-3
  "3. Description for the exercise"
  []
  {:result "foo"})

(defn exercise-4
  "4. Description for the exercise"
  []
  {:result "foo"})

(defn -handler
  "AWS Lambda entry point.
  event[\"exercise-number\"] - exercise numeber
  event[\"arguments\"] - exercise arguments
  "
  [event]
  (let [{:strs [exercise-number arguments]} event
        exercises [nil
                   exercise-1
                   exercise-2
                   exercise-3
                   exercise-4]]
    (apply (exercises exercise-number) arguments)))
