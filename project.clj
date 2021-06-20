(defproject brave-clojure "0.1.0"
  :description "Exercises from the book \"Clojure for the brave and true\" deployed on AWS serverless solutions"
  :url "https://github.com/trilliput/brave-clojure-on-aws"
  :license {:name "The MIT License"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.10.0"]]
  :jvm-opts ["-Dclojure.compiler.elide-meta=[:doc]"
             "-Dclojure.compiler.direct-linking=true"]
  :plugins [[jonase/eastwood "0.4.2"]
            ;; Do not upgrade lein-cloverage
            ;; until PR https://github.com/cloverage/cloverage/pull/317 is released
            [lein-cloverage "1.0.9"]]
  ;; :target-path "target/%s"
  :profiles {:uberjar {:aot :all,
                       :uberjar-name "standalone.jar"}})
