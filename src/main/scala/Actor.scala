import akka.actor._

class Logger extends Actor with ActorLogging {
  log.info("Logger Started!")

  def receive = {
    case msg => log.info("Got msg: {}", msg)
  }
}

// vim: set ts=2 sw=2 et sts=2;
