(ns elastic-clojure-demo.search
  (:require [clojurewerkz.elastisch.rest.document :as esd]
            [clojurewerkz.elastisch.query :as esq]
            [clojurewerkz.elastisch.aggregation :as esa]
            [clojurewerkz.elastisch.rest.response :as esr]))


;; Example Searches

(defn find-all-groceries
  [conn]
  (esd/search conn
              "groceries" ; index name
              "item" ; type name
              :query (esq/match-all)
              :size 20))

(defn find-groceries-with-name
  [conn name]
  (esd/search conn "groceries" "item"
              :filter {:term {:name name}}
              :size 20))

(defn find-groceries-with-amount-and-cost
  [conn amount cost]
  (esd/search conn "groceries" "item"
              :filter {:and {:filters [{:term {:amount amount}}
                                       {:term {:cost cost}}]}}
              :size 20))

;; Example Aggregations

(defn amount-histogram
  [conn]
  (let [response (esd/search conn "groceries" "item"
                             :query (esq/match-all)
                             :size 0 ;; We don't want any items just aggregation result

                             ;; Aggregations
                             :aggs {:cost ; A name used for this aggregation
                                    {:histogram
                                     {:field "amount"
                                      :interval 5}}})]
    (:aggregations response)))

(defn total-cost
  [conn]
  (let [response (esd/search conn "groceries" "item"
                             :query (esq/match-all)
                             :size 0 ;; We don't want any items just aggregation result

                             ;; Aggregations
                             :aggs {:total-cost ; A name used for this aggregation
                                    {:sum ; Performing a sum aggregation of the provided script
                                     {:script ; This script runs per document. The script language is mvel.
                                      "doc['amount'].value * doc['cost'].value"}}})]
    (:aggregations response)))






(comment
  (find-all-groceries (:connection user/system))

  (find-groceries-with-name (:connection user/system) "coffee")

  (find-groceries-with-amount-and-cost
    (:connection user/system) 10 3.5)

  (amount-histogram (:connection user/system))


  (total-cost (:connection user/system))

  ;; Equivalent Clojure to find total cost
  (->> (find-all-groceries (:connection user/system))
     :hits
     :hits
     (map #(let [s (:_source %)]
             (* (:amount s) (:cost s))))
     (reduce +))


  )