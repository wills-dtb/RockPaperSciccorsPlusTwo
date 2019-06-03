import akka.http.scaladsl.server.{Directive1, Directives}

import scala.concurrent.Future
import scala.util.{Failure, Success}

trait GameDirectives extends Directives {

    def handle[T](f: Future[T])(e: Throwable => ApiError): Directive1[T] = onComplete(f) flatMap {
      case Success(t) =>
        provide(t)
      case Failure(err) =>
        val apiError = e(err)
        complete(apiError.statusCode, apiError.msg)
    }

    def handleWithGeneric[T](f: Future[T]): Directive1[T] =
      handle[T](f)(_ => ApiError.generic)
}
