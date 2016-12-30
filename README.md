# Simple Akka Cluster for ConstructR

https://github.com/hseeberger/constructr
http://chariotsolutions.com/screencast/simple-akka-clustering/

[![Youtube Vides](http://img.youtube.com/vi/6RQb7Hz_TPw/0.jpg)](http://www.youtube.com/watch?v=6RQb7Hz_TPw)

Setting up Akka clustering is quite easy and provides a way to distribute work across multiple machines in the cluster. In many cases this requires no changes to an Actor compared to a non-cluster deployment. In this screencast, I walk through setting up a cluster and compare deploying an actor in a local actor system and a clustered actor system.

# Local Mode
```bash
sbt console
```
```scala
val system = TestSystem.system
val roundRobinPool = RoundRobinPool(nrOfInstances = 4)
val router = system.actorOf(roundRobinPool.porps(Props[Logger]))
(1 to 10).foreach(i => router ! i)
system.terminate
```

# Cluster Mode
```bash
brew install zookeeper sbt
zkServer start
```
```bash
sbt console -Dakka.remote.netty.tcp.port=0  -Dakka.actor.provider=akka.cluster.ClusterActorRefProvider
```
```scala
val system = TestSystem.system
```
```bash
sbt console -Dakka.remote.netty.tcp.port=0 -Dakka.actor.provider=akka.cluster.ClusterActorRefProvider
```
```scala
val system = TestSystem.system
val roundRobinPool = RoundRobinPool(nrOfInstances = 4)
val clusterRouterSetting = ClusterRouterPoolSettings(totalInstances = 4, maxInstancesPerNode = 2, allowLocalRoutees = true, useRole = None)
val clusterPool = ClusterRouterPool(roundRobinPool, clusterRouterSetting)
val router = system.actorOf(clusterPool.props(Props[Logger]))
(1 to 10).foreach(i => router ! i)
system.terminate
```
```bash
zkServer stop
```
