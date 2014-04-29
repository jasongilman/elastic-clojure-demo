(ns elastic-clojure-demo.core
  "A commented out namespace with forms to be evaluated to try out Elasticsearch and Clojure"
  (:require [elastic-clojure-demo.index :as idx]
            [elastic-clojure-demo.data :as data]
            [elastic-clojure-demo.search :as srch]
            [clojure.pprint :refer [pp pprint]]))


(comment

  ;; Runs reset function defined in dev/user.clj.
  ;; This will start elasticsearch and reconnect to it.
  (user/reset)

  ;; Grab the user connection for use in this namespace
  (def conn (:connection user/system))

  ;; Create the index if it does not exist
  ;; To clear out all data or delete the index shutdown the repl and then run `lein clean-es`
  (idx/create-index conn)

  ;; Index some data
  (idx/save-records conn (data/grocery-data))

  ;; Now try out Elasticsearch Marvel
  ;; Open http://localhost:9200/_plugin/marvel/


  ;; Searching
  (srch/find-all-groceries conn)

  (srch/find-groceries-with-name conn "coffee")

  (srch/find-groceries-with-amount-and-cost conn 10 3.5)

  (srch/amount-histogram conn)

  (srch/total-cost conn)


  )

