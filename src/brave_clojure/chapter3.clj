(ns brave-clojure.chapter3
  "Exercises from Chapter 3"
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

(defn exercise-5
  "5. Description for the exercise"
  []
  {:result "foo"})

(defn exercise-6
  "6. Description for the exercise"
  []
  {:result "foo"})

(defn -handler
  "AWS Lambda entry point.
  event[\"exercise-number\"] - exercise numeber
  event[\"arguments\"] - exercise arguments
  "
  [event]
  (let [{:keys [exercise-number arguments]} event
        exercises [nil
                   exercise-1
                   exercise-2
                   exercise-3
                   exercise-4
                   exercise-5
                   exercise-6]]
    (apply (exercises exercise-number) arguments)))
