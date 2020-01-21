package albertmartorell.com.domain

import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class MyResponse {

    suspend fun <T : Any> handleRequest(requestFunc: suspend () -> T): Result<T> {

        return try {

            Result.Success(requestFunc.invoke())

        } catch (ex: Exception) {

            when (ex) {

                is UnknownHostException ->
                    Result.Error(IOException(ERROR_INTERNET, ex))

                is SocketTimeoutException ->
                    Result.Error(IOException(ERROR_SERVER, ex))

                else ->
                    Result.Error(IOException(ERROR_HTTP, ex))

            }

        }

    }

}