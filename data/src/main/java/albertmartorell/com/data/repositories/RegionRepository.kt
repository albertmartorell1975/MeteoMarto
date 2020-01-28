package albertmartorell.com.data.repositories

import albertmartorell.com.data.sources.LocationDataSource
import albertmartorell.com.domain.cityweather.Coordinates

class RegionRepository(
    private val locationDataSource: LocationDataSource,
    private val permissionChecker: PermissionChecker
) {

    suspend fun findLastRegion(): Coordinates {

        return if (permissionChecker.check(PermissionChecker.Permission.COARSE_LOCATION)) {

            locationDataSource.findLastRegion() ?: Coordinates(0F, 0F)

        } else {

            Coordinates(0F, 0F)

        }

    }

}

interface PermissionChecker {

    enum class Permission { COARSE_LOCATION }

    suspend fun check(permission: Permission): Boolean
}