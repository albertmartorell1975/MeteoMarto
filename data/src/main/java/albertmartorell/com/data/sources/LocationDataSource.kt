package albertmartorell.com.data.sources

import albertmartorell.com.domain.Coordinates


interface LocationDataSource {

    suspend fun findLastRegion(): Coordinates?

}