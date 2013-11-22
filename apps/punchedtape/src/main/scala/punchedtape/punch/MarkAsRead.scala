package punchedtape.punch

import scala.Boolean
import punchedtape.Punch
import etude.chatwork.Session

case class MarkAsRead(roomId: String) extends Punch {
  def execute(session: Session): Boolean = {
    session.room(BigInt(roomId)) match {
      case Some(room) =>
        println("Mark as read: rid[" + roomId + "]: " + room.description)
        session.markAsRead(room)
        true
      case _ =>
        false
    }
  }
}
