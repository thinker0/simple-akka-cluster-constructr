import akka.actor._

object TestSystem {
  val system = ActorSystem("test-system")
  sys.addShutdownHook(system.shutdown)
}
