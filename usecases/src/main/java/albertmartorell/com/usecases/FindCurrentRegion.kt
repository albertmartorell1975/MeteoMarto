package albertmartorell.com.usecases

import albertmartorell.com.data.repositories.RegionRepository
import albertmartorell.com.domain.Coordinates

class FindCurrentRegion(private val regionRepository: RegionRepository) {

    suspend operator fun invoke(): Coordinates {

        return regionRepository.findLastRegion()

    }

}