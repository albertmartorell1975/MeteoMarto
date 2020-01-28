package albertmartorell.com.data.sources

import albertmartorell.com.domain.cityweather.Coordinates


interface LocationDataSource {

    suspend fun findLastRegion(): Coordinates?

}