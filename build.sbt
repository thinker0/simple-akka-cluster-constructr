scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.4.16",
  "com.typesafe.akka" %% "akka-cluster" % "2.4.16",
  "de.heikoseeberger" %% "constructr" % "0.15.0",
  // "de.heikoseeberger" %% "constructr-coordination-etcd" % "0.15.0",
  "com.lightbend.constructr" %% "constructr-coordination-zookeeper" % "0.3.2"
)

initialCommands in console += """
import akka.actor._
import akka.routing._
import akka.cluster.routing._
import akka.cluster.Cluster
"""
