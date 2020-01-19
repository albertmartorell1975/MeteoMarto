package albertmartorell.com.domain

import java.io.IOException
import java.lang.Exception
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class MyResponse {

    suspend fun <T : Any> handleRequest(requestFunc: suspend () -> T): Result<T> {

        return try {

            Result.Success(requestFunc.invoke())

        } catch (ex: Exception) {

            when (ex) {

//                is HTTPException ->
//                    Result.Error(IOException("Http errònia", e))

                is UnknownHostException ->
                    Result.Error(IOException("No hi ha Internet 33333", ex))

                is SocketTimeoutException ->
                    Result.Error(IOException("Servidor caigut", ex))

                else ->
                    Result.Error(IOException("Crida errònia", ex))

            }

            //Result.failure(he)
        }

    }

}