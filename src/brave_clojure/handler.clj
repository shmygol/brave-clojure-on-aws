(ns brave-clojure.handler
  "Handler for AWS Lambda functions func1 and func2.
  See appropriate functions for more info."
  (:gen-class
    ;; Define handler method signature here so that AWS can find the method
    :methods [^:static [func1 [String] String]
              ^:static [func2 [String] String]]))

(defn -func1
  "AWS Lambda func1 entry point"
  [event]
  (str "Hello, " event "!"))

(defn -func2
  "AWS Lambda func2 entry point"
  [event]
  (str "Bye, " event "!"))

