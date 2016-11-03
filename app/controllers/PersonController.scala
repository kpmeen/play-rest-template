package controllers

import com.google.inject.{Inject, Singleton}
import play.api.Logger
import play.api.libs.json.Json
import play.api.mvc._

@Singleton
class PersonController @Inject() (
    val personService: PersonService
) extends Controller {

  private val logger = Logger(classOf[PersonController])

  def getUser(name: String) = Action { implicit request =>
    personService.findUser(name).map { usr =>
      Ok(Json.toJson())
    }.getOrElse(NotFound)
  }

}
