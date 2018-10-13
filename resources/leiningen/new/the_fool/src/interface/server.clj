(ns {{name}}.interface.server
  (:require [clojure.spec.alpha :as spec]
            [com.stuartsierra.component :as component]
            [taoensso.timbre :as timbre])
  (:import [io.grpc Server ServerBuilder]))

(defn create-grpc-service [])

(defrecord ServerComponent [options]
  component/Lifecycle
  (start [this]
    (timbre/info "Starting server...")
    (let [port (get options :port)
          builder (ServerBuilder/forPort port)
          services (create-grpc-service)
          _ (doseq [s services]
              (.addService builder s))
          server (-> builder
                   (.build))]
      (-> server
          (.start))
      (timbre/info "Listening on port:" port)
      (assoc this :server server)))
  (stop [this]
    (timbre/info "Stopping server...")
    (-> (get this :server)
        (.shutdown))
    (assoc this :server nil)))

(defn start-server [port]
  (map->ServerComponent
    {:options {:port port}}))

