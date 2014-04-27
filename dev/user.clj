(ns user
  (:require [clojure.pprint :refer (pprint pp)]
            [clojure.test :refer (run-all-tests)]
            [clojure.tools.namespace.repl :refer (refresh refresh-all)]
            [clojure.repl :refer :all]
            [elastic-clojure-demo.system :as system]))


(def system nil)

(defn start []
  (alter-var-root #'system (constantly (system/start))))

(defn stop []
  (alter-var-root #'system (constantly (system/stop system))))


(defn reset []
  (stop)
  (refresh :after 'user/start))

(println "Custom user.clj loaded.")