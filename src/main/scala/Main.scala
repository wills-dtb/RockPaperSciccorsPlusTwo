import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import model.ComputerPlayer
import repository.InMemoryGameRepository

import scala.concurrent.Await
import scala.concurrent.duration._
import scala.util.{Failure, Success}

object Main extends App {
  val host = "0.0.0.0"
  val port = 9000

  implicit val system: ActorSystem = ActorSystem(name = "RPSSL-Game")
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  import system.dispatcher

  val gameRepository = new InMemoryGameRepository(Seq(
    ComputerPlayer("1", "Robodroid", "Spock")
// TODO: refactor
  ))
  val router = new GameRouter(gameRepository)
  val server = new Server(router, host, port)

  val binding = server.bind()
  binding.onComplete {
    case Success(_) => println("Succeeded")
    case Failure(exception) => println(s"Failed: ${exception.getMessage}")
  }

  Await.result(binding, 4.seconds)
}
