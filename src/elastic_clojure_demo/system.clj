(ns elastic-clojure-demo.system
  (:require [elastic-clojure-demo.elasticsearch :as es]
            [elastic-clojure-demo.index :as idx]))

(def port 9200)

(defn start
  "Creates and returns a new system that's started"
  []
  {:es (es/start port)
   :connection (idx/connect port)})

(defn stop
  "Stops the system"
  [system]
  (-> system
      (update-in [:es] es/stop)
      (dissoc :connection)))

