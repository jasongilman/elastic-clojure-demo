(defproject elastic-clojure-demo "0.1.0-SNAPSHOT"
  :description "Demonstrates Elasticsearch integration with Clojure."
  :url "https://github.com/jasongilman/elastic-clojure-demo"
  :dependencies [[org.clojure/clojure "1.6.0"]

                 ;; Use for Elasticsearch communication
                 [clojurewerkz/elastisch "2.0.0-rc1"]
                 ;; Configure Elasticsearch logging
                 [log4j/log4j "1.2.17"]

                 ;; Use this for reading the CSV data
                 [org.clojure/data.csv "0.1.2"]]

  :plugins [[lein-shell "0.3.0"]]

  :profiles
  {:dev {:dependencies [[org.clojure/tools.namespace "0.2.4"]
                        [org.clojars.gjahad/debug-repl "0.3.3"]]

         :source-paths ["src" "dev"]}}


  :aliases {
            ;; Removes the Elasticsearch installed data.
            "clean-es" ["shell" "rm" "-r" "data"]

            ;; Installs the Elasticsearch Marvel plugin
            "install-marvel" ["do"
                              "shell" "curl" "-O" "https://download.elasticsearch.org/elasticsearch/marvel/marvel-latest.zip,"
                              "shell" "mkdir" "-p" "plugins/marvel,"
                              "shell" "unzip" "marvel-latest.zip" "-d" "plugins/marvel,"
                              "shell" "rm" "marvel-latest.zip"]
            })


