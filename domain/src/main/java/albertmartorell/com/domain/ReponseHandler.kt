package albertmartorell.com.domain


import java.net.SocketTimeoutException


open class ResponseHandler {
    fun <T : Any> handleSuccess(data: T): Resource<T> {
        return Resource.success(data)
    }

    fun <T : Any> handleException(e: Exception): Resource<T> {

        return when (e) {
            //is HttpException ->
              //  Resource.error(getErrorMessage(400), null)
            is SocketTimeoutException ->
                Resource.error(getErrorMessage(1000), null)
            else ->
                Resource.error(getErrorMessage(Int.MAX_VALUE), null)
        }
    }

    private fun getErrorMessage(code: Int): String {

        code.let {

            return when {

                it == 400 ->
                    "Unauthorised"
                it == 404 ->
                    "Not found"
                it > 500 ->
                    "Server error"
                else ->
                    "Something went wrong"
            }
        }
//        return when (code) {
//            401 -> "Unauthorised"
//            404 -> "Not found"
//            code > 500 -> "Server error"
//            else -> "Something went wrong"
//        }
    }

}

//enum class HttpException {
//
//}
