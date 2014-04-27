(ns elastic-clojure-demo.index
  (:require [clojurewerkz.elastisch.rest :as esr]
            [clojurewerkz.elastisch.rest.index :as esi]
            [clojurewerkz.elastisch.rest.bulk :as esb]
            [clojurewerkz.elastisch.rest.document :as doc]))

(defn connect
  "Connects to Elasticsearch using Elastisch and returns the connection"
  [port]
  (esr/connect (str "http://localhost:" port)))

(def index-name
  "The name of the index to create in Elasticsearch"
  "groceries")

(def type-name
  "The name of the type created within the index."
  "item")

(def mapping-fields
  "A map of fields names and types"
  {:name {:type "string" :index "not_analyzed"}
   :cost {:type :float}
   :amount {:type :long}})

(def index-settings
  { "index" {"number_of_shards" 3
             "number_of_replicas" 1
             "refresh_interval" "1s"}})

(defn create-index
  "Creates the index in Elasticsearch."
  [conn]
  (when-not (esi/exists? conn index-name)
    (esi/create conn
                index-name
                :settings index-settings
                :mapping {type-name mapping-fields})))

(defn save-records
  [conn records]
  (let [records (map #(assoc % :_type type-name) records)
        response (esb/bulk-with-index
                   conn
                   index-name
                   (esb/bulk-index records))]
    ;; dissociate items from response so many individual items aren't printed in repl.
    ;; If the are errors comment this out to get details
    (dissoc response :items)))
