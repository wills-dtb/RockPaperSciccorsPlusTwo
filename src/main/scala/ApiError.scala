import akka.http.scaladsl.model.{StatusCode, StatusCodes}

final case class ApiError private(statusCode: StatusCode, msg: String)

object ApiError {
  private def apply(statusCode: StatusCode, msg: String): ApiError = new ApiError(statusCode, msg)
  val generic: ApiError = new ApiError(StatusCodes.InternalServerError, "Unknown error.")
  val emptyNameField: ApiError = new ApiError(StatusCodes.BadRequest, "The name field must not be empty")
}