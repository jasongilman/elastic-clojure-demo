(ns elastic-clojure-demo.data)


(defn players-data
  "Read the players.csv file and return a sequence of records"
  []
  ;; TODO implement this

  (throw (Exception. "TODO implement me")))


(defn grocery-data
  "Returns hardcoded data for showing how we would stick example data in Elasticsearch"
  []
  [{:name "apples" :cost 1.50 :amount 5}
   {:name "oranges" :cost 3.50 :amount 10}
   {:name "pasta" :cost 5.00 :amount 2}
   {:name "mayo" :cost 3.75 :amount 1}
   {:name "coffee" :cost 4.35 :amount 4}
   {:name "cookies" :cost 2.75 :amount 12}
   {:name "bread" :cost 3.00 :amount 1}
   {:name "lettuce" :cost 2.00 :amount 1}])