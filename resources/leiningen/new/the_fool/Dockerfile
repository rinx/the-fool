FROM clojure:lein-alpine as builder
LABEL maintainer "FIXME <FIXME>"

RUN set -eux && apk update && apk --no-cache add git openssh

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

COPY project.clj /usr/src/app/
RUN lein deps
COPY . /usr/src/app
RUN mv "$(lein uberjar | sed -n 's/^Created \(.*standalone\.jar\)/\1/p')" app-standalone.jar

FROM clojure:alpine
LABEL maintainer "FIXME <FIXME>"

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

COPY --from=builder /usr/src/app/app-standalone.jar /usr/src/app/app-standalone.jar

ENV PORT 8080
ENV HEALTH_PORT 80

EXPOSE ${PORT} ${HEALTH_PORT}
ENTRYPOINT ["/usr/bin/java"]
CMD ["-Djava.security.policy=/usr/src/app/java.policy", "-jar", "app-standalone.jar"]
