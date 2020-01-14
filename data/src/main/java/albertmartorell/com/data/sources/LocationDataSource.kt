package albertmartorell.com.data.sources

interface LocationDataSource {

    suspend fun findLastRegion(): String?

}