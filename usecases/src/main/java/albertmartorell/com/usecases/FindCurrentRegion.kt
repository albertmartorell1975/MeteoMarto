package albertmartorell.com.usecases

import albertmartorell.com.data.repositories.RegionRepository

class FindCurrentRegion(private val regionRepository: RegionRepository) {

    suspend operator fun invoke(): String {

        return regionRepository.findLastRegion()

    }

}