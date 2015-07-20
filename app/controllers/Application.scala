package controllers

import play.api._
import play.api.libs.json.JsArray
import play.api.libs.ws.WS
import play.api.mvc._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import play.api.Play.current
import scala.concurrent.duration._

class Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready1."))
  }

  def tweets(q: String) = Action.async {
    val futureResponse = WS.url(s"http://twitter-search-proxy.herokuapp.com/search/tweets?q=$q").get()
    futureResponse.map { response =>
        Ok(JsArray((response.json \\ "text").distinct))
    }
  }

}
