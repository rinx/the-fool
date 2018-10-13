# The-Fool

[![Clojars Project](https://clojars.org/the-fool/lein-template/latest-version.svg)](https://clojars.org/the-fool/lein-template)

A Leiningen template for gRPC based micro services.

## Usage

### Create a new project

    $ lein new the-fool <project-name>


Add path to your compiled java sources of protobuf in `project.clj`:

    :java-source-paths []

You should keep consistency between the versions of these gRPC libraries.

* io.grpc/grpc-netty
* io.grpc/grpc-protobuf
* io.grpc/grpc-stub
* io.grpc/grpc-services

Also, the version of com.google.protobuf/protobuf-java should be taken care.

### Using gRPC Server Reflection Protocol

If you need [gRPC Server Reflection Protocol](https://github.com/grpc/grpc/blob/master/doc/server-reflection.md), you should inject `(io.grpc.protobuf.services/ProtoReflectionService/newInstance)` to `services` in `<projectname>.interface.server`.
By default, `io.grpc/grpc-services` is in the vector of dev-dependencies because reflection protocol should be enabled only in developing environment.

## License

Copyright © 2018 rinx.

Distributed under the Eclipse Public License either version 1.0 or any later version.
