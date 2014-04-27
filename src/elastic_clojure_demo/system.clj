(ns elastic-clojure-demo.system
  (:require [elastic-clojure-demo.elasticsearch :as es]))

(defn start
  "Creates and returns a new system that's started"
  []
  {:es (es/start 9200)})

(defn stop
  "Stops the system"
  [system]
  (update-in system [:es] es/stop))

