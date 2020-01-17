package albertmartorell.com.domain

import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class ResultHandler {

    /**
     * It is just a suspending function and most of all it also gets a suspending lambda as a parameter.
     * So, inside this function, we just call the lambda, then in case, an error is thrown we just return the result of error based on the message that we pass as a parameter.
     *
     */
    suspend fun <T : Any> safeApiCall(
        call: suspend () -> Result<T>,
        errorMessage: String
    ): Result<T> =

        try {

            call.invoke()

        } catch (e: Exception) {

            when (e) {

//                is HTTPException ->
//                    Result.Error(IOException("Http errònia", e))
                is UnknownHostException ->
                    Result.Error(IOException("No hi ha Internet", e))

                is SocketTimeoutException ->
                    Result.Error(IOException("Servidor caigut", e))

                else ->
                    Result.Error(IOException("Crida errònia", e))

            }

        }

}