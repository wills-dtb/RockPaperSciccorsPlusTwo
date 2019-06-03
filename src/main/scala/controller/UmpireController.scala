package controller

import model.{ComputerPlayer, HumanPlayer}
import play.twirl.api.HtmlFormat
import twirl.html.{loser, tie, winner}

object UmpireController {

  def evaluateMoves(humanMove: HumanPlayer, computerMove: ComputerPlayer): HtmlFormat.Appendable = {
    (humanMove.move, computerMove.move) match {
      case ("Rock", "Scissors") |
           ("Paper", "Rock") |
           ("Scissors", "Paper") |
           ("Rock", "Lizard") |
           ("Lizard", "Spock") |
           ("Spock", "Scissors") |
           ("Lizard", "Paper") |
           ("Spock", "Rock") |
           ("Scissors", "Lizard") => winner.render()
      case _ => if (humanMove.move == computerMove.move) tie.render() else loser.render()
    }
  }
//  TODO: Implement method
}
