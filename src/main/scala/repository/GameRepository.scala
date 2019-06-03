package repository

import java.util.UUID

import model.{ComputerPlayer, HumanPlayer}

import scala.concurrent.{ExecutionContext, Future}

trait GameRepository {

  def start(playerId: String): Future[HumanPlayer]
// TODO: more endpoints

}


class InMemoryGameRepository(initialPlayers: Seq[ComputerPlayer] = Seq.empty)(implicit execCon: ExecutionContext) extends GameRepository {

  private val humanPlayer = HumanPlayer
  private val computerPlayers: List[ComputerPlayer] = initialPlayers.toList
  // TODO: implement and choose how many computer players ^^

  override def start(playerId: String): Future[HumanPlayer] = Future.successful(humanPlayer.apply(UUID.randomUUID().toString, 5, "Will", "Rock"))
}

