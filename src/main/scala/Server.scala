import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.Http.ServerBinding
import akka.stream.ActorMaterializer

import scala.concurrent.{ExecutionContext, Future}

class Server(router: GameRouter, host: String, port: Int)(implicit system: ActorSystem, ex: ExecutionContext, mat: ActorMaterializer) {
  def bind(): Future[ServerBinding] = Http().bindAndHandle(router.route, host, port)
}
