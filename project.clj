(defproject brave-clojure "0.1.0"
  :description "Exercises from the book \"Clojure for the brave and true\" deployed on AWS serverless solutions"
  :url "https://github.com/trilliput/brave-clojure-on-aws"
  :license {:name "The MIT License"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/data.json "0.2.6"]]
  :jvm-opts ["-Dclojure.compiler.elide-meta=[:doc]"
             "-Dclojure.compiler.direct-linking=true"]
  :main brave-clojure.handler
  ;; :target-path "target/%s"
  :profiles {:uberjar {:aot :all,
                       :uberjar-name "standalone.jar"}})
