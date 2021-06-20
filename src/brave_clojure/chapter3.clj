(ns brave-clojure.chapter3
  "Exercises from Chapter 3"
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

(defn exercise-5
  "5.  Create a function that’s similar to `symmetrize-body-parts`
  except that it has to work with weird space aliens with radial symmetry.
  Instead of two eyes, arms, legs, and so on, they have five."
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts
         final-body-parts []]
    (if (empty? remaining-asym-parts)
      final-body-parts
      (let [[part & remaining] remaining-asym-parts]
        (recur remaining
               (into final-body-parts
                     (set [part {:name (clojure.string/replace (:name part) #"^left-" "right-")
                                 :size (:size part)}])))))))

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
