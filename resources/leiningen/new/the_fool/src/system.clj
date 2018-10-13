(ns {{name}}.system
  (:require [{{name}}.interface.server :as server]
            [com.stuartsierra.component :as component]))

(defn system [{:keys [port] :as conf}]
  (component/system-map
    :server (server/start-server port)))

