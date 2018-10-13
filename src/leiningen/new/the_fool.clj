(ns leiningen.new.the-fool
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "the-fool"))

(defn the-fool
  "expand this leiningen template."
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' the-fool project.")
    (main/info "Your project name is:" name)
    (->files data
             ["LICENSE" (render "LICENSE" data)]
             ["README.md" (render "README.md" data)]
             ["Dockerfile" (render "Dockerfile" data)]
             ["cloudbuild.yaml" (render "cloudbuild.yaml" data)]
             ["project.clj" (render "project.clj" data)]
             ["dev/user.clj" (render "dev/user.clj" data)]
             ["dev/dev.clj" (render "dev/dev.clj" data)]
             ["src/{{sanitized}}/core.clj" (render "src/core.clj" data)]
             ["src/{{sanitized}}/system.clj" (render "src/system.clj" data)]
             ["src/{{sanitized}}/interface/server.clj" (render "src/interface/server.clj" data)]
             ["src/{{sanitized}}/model/model.clj" (render "src/model/model.clj" data)]
             ["src/{{sanitized}}/repository/repository.clj" (render "src/repository/repository.clj" data)]
             ["src/{{sanitized}}/usecase/usecase.clj" (render "src/usecase/usecase.clj" data)]
             ["test/{{sanitized}}/core_test.clj" (render "test/core_test.clj" data)])))
