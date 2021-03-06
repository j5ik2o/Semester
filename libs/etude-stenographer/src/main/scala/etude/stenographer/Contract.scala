package etude.stenographer

import org.apache.commons.codec.digest.DigestUtils
import scala.collection.mutable
import etude.chatwork.v0.RoomMeta

case class Contract(orgId: Option[String],
                    email: String) {

  lazy val rooms: mutable.HashMap[BigInt, RoomMeta] = mutable.HashMap[BigInt, RoomMeta]()

  lazy val id = DigestUtils.sha256Hex(orgId.getOrElse("") + email)
}

object Contract {
  def apply(email: String): Contract = Contract(orgId = None, email = email)

  def apply(orgId: String, email: String): Contract = Contract(orgId = Some(orgId), email = email)
}
