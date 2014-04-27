(defproject elastic-clojure-demo "0.1.0-SNAPSHOT"
  :description "Demonstrates Elasticsearch integration with Clojure."
  :url "https://github.com/jasongilman/elastic-clojure-demo"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [clojurewerkz/elastisch "2.0.0-rc1"]
                 [log4j/log4j "1.2.17"]]

  :profiles
  {:dev {:dependencies [[org.clojure/tools.namespace "0.2.4"]
                        [org.clojars.gjahad/debug-repl "0.3.3"]]

         :source-paths ["src" "dev" "test"]}})


