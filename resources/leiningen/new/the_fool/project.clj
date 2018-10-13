(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "FIXME"
  :url "https://github.com/YOURNAME/{{name}}"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.0-beta3"]
                 [org.clojure/spec.alpha "0.2.176"]
                 [org.clojure/core.async "0.4.474"]
                 [com.stuartsierra/component "0.3.2"]
                 [com.taoensso/timbre "4.10.0"]
                 [orchestra "2018.09.10-1"]
                 [io.grpc/grpc-netty "1.14.0" :exclusions [io.netty/netty-codec-http2 io.grpc/grpc-core]]
                 [io.grpc/grpc-protobuf "1.14.0"]
                 [io.grpc/grpc-stub "1.14.0"]
                 [io.netty/netty-all "4.1.28.Final"]]
  :plugins [[info.sunng/lein-bootclasspath-deps "0.3.0"]]
  :target-path "target/%s"
  :java-source-paths []
  :boot-dependencies [[com.google.protobuf/protobuf-java "3.6.0"]]
  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "0.2.11"]
                                  [io.grpc/grpc-services "1.14.0"]]
                   :source-paths ["dev"]}
             :uberjar {:aot :all
                       :main {{name}}.core}})
