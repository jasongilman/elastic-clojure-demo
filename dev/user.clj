(ns user
  (:require [clojure.pprint :refer (pprint pp)]
            [clojure.test :refer (run-all-tests)]
            [clojure.tools.namespace.repl :refer (refresh refresh-all)]
            [clojure.repl :refer :all]
            [elastic-clojure-demo.system :as system]
            [elastic-clojure-demo.index :as idx]))


(def system nil)

(defn start []
  (alter-var-root #'system
                  (constantly (system/start))))

(defn stop []
  (alter-var-root #'system (constantly (system/stop system))))


(defn reset
  "Stops elasticsearch, reloads all the code, and restarts everything."
  []
  (stop)
  (refresh :after 'user/start))

(println "Custom user.clj loaded.")