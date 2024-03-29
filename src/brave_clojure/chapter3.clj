(ns brave-clojure.chapter3
  "Exercises from Chapter 3"
  (:require clojure.set clojure.string)
  (:gen-class
    :methods [^:static [handler [java.util.Map] java.util.Map]]))

(defn exercise-1
  "1. Use the `str`, `vector`, `list`, `hash-map`, and `hash-set` functions."
  []
  {:str (str "Just " "a " "simple " "string.")
   :vector (vector "a" "b" "c")
   :list (list 1 "a" "b" 2 "a" :end)
   :hash-map (hash-map :key "value")
   :hash-set (hash-set "a" "a" "b" "c" "c" "c")})

(defn exercise-2
  "2.  Write a function that takes a number and adds 100 to it."
  [input-number]
  (+ input-number 100))

(defn exercise-3
  "3. Write a function, dec-maker,
  that works exactly like the function inc-maker except with subtraction."
  [decrementor]
  #(- % decrementor))

(defn exercise-4
  "4. Write a function, mapset,
  that works like map except the return value is a set."
  [& args]
  (into #{} (apply map args)))

(defn -replace-in-name
  "Replace string in :name value of input-map"
  [input-map match replacement]
  (update input-map :name #(clojure.string/replace % match replacement)))

(defn exercise-5
  "5.  Create a function that’s similar to `symmetrize-body-parts`
  except that it has to work with weird space aliens with radial symmetry.
  Instead of two eyes, arms, legs, and so on, they have five."
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts
         final-body-parts #{}]
    (if (empty? remaining-asym-parts)
      final-body-parts
      (let [[part & remaining] remaining-asym-parts]
        (recur remaining
               (clojure.set/union
                 final-body-parts
                 #{part}
                 (set (map
                   (partial -replace-in-name part #"^middle-")
                   '("right-upper-" "right-lower-" "left-lower-" "left-upper-")))))))))

(defn exercise-6
  "6. Create a function that generalizes `symmetrize-body-parts`
  and the function you created in Exercise 5.
  The new function should take a collection of body parts
  and the number of matching body parts to add."
  [number-of-body-parts asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts
         final-body-parts #{}]
    (if (empty? remaining-asym-parts)
      final-body-parts
      (let [[part & remaining] remaining-asym-parts]
        (recur remaining
               (clojure.set/union
                 final-body-parts
                 #{part}
                 (set (map
                   #(-replace-in-name part #"^1-" (str % "-"))
                   (range 2 (+ number-of-body-parts 2))))))))))

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
