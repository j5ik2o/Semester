package etude.html

import java.io.StringReader
import nu.validator.htmlparser.common.XmlViolationPolicy
import nu.validator.htmlparser.sax.HtmlParser
import scala.xml.parsing.NoBindingFactoryAdapter
import scala.xml.{InputSource, Node}

/**
 * Normalize HTML as XML.
 */
object Normalizer {
  def html(text: String): Either[Exception, Node] = {
    // reference:
    // http://www.mwsoft.jp/programming/scala/web_scraping.html
    try {
      val htmlParser = new HtmlParser
      val contentHandler = new NoBindingFactoryAdapter

      htmlParser.setNamePolicy(XmlViolationPolicy.ALLOW)
      htmlParser.setContentHandler(contentHandler)
      htmlParser.parse(new InputSource(new StringReader(text)))

      Right(contentHandler.rootElem)
    } catch {
      case e: Exception => Left(e)
    }
  }
}
