(ns {{name}}.core
  (:require [{{name}}.system :as system]
            [clojure.spec.alpha :as spec]
            [com.stuartsierra.component :as component]
            [taoensso.timbre :as timbre])
  (:gen-class))

(defn parse-int [s]
  (try
    (Integer/parseInt s)
    (catch Exception _ nil)))

(defn get-opts []
  {:port (or (parse-int (System/getenv "PORT")) 8080)})

(defn -main []
  (timbre/set-level! :info)
  (component/start
    (system/system (get-opts)))
  (while true (Thread/sleep 10000000000)))

