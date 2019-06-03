import java.util.UUID

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Route
import model.HumanPlayer
import repository.GameRepository
import twirl.html.home

trait BaseRouter {
  def route: Route
}

class GameRouter(gameRepository: GameRepository) extends BaseRouter with GameDirectives {
  import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
  import io.circe.generic.auto._

  override def route: Route = pathPrefix("home") {
    pathEndOrSingleSlash {
      get {
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`,
          "<h1>Welcome to RPSSL!</h1>" + home.render("Home")
        ))
      } ~ path(Segment) { playerId =>
        put(
          entity(as[HumanPlayer]) { _ =>
            handleWithGeneric(gameRepository.start(playerId)) { player =>
              complete(player)
            }
          }
        )
      }
//      get {
//        handleWithGeneric(gameRepository.start()) { game =>
//          complete(game)
//        }
//      }
    }
  }
}