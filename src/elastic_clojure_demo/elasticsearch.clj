(ns elastic-clojure-demo.elasticsearch
  "Runs an in-JVM version of Elasticsearch"
  (:import [org.elasticsearch.common.settings
             ImmutableSettings
             ImmutableSettings$Builder]
           org.elasticsearch.common.logging.log4j.LogConfigurator
           org.elasticsearch.node.NodeBuilder
           org.elasticsearch.node.Node))

(defn start
  "Starts an instance of Elasticsearch and returns it."
  [port]
  (let [node-settings (.. (ImmutableSettings/settingsBuilder)
                          (put "node.name" "repl-es")
                          (put "path.conf" "resources")
                          (put "http.port" (str port))
                          (put "transport.tcp.port" (str (+ 10 port)))
                          build)
        ^NodeBuilder builder (NodeBuilder/nodeBuilder)]

    ;; Configure logging
    (LogConfigurator/configure node-settings)

    ;; Configure and start the node.
    (.. builder
        (settings node-settings)

        ;; Set the Elasticsearch cluster to join
        (clusterName "repl-es-cluster")

        ;; Configures the node so that it can allocate shards
        (data true)

        ;; Keeps thisn node from connecting to other Elasticsearch nodes.
        (local true)

        ;; Start the node
        node)))

(defn stop
  "Takes an instance of Elasticsearch and shuts it down."
  [^Node elasticsearch]

  (when elasticsearch
    (.close elasticsearch)
    nil))
