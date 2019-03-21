(ns {{name}}.system
  (:require [{{name}}.interface.server :as server]
            [com.stuartsierra.component :as component]))

(defn system [{:keys [port cancel-ch] :as conf}]
  (component/system-map
    :server (server/start-server port)))

