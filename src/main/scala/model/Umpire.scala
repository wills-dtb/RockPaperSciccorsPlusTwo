package model

case class Umpire(
                   moves: Seq[String]  = Seq.empty,
                   roundWinner: Seq[String] = Seq.empty
                 )
