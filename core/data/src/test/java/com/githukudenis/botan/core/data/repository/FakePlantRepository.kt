/*
*   Copyright 2024 Denis Githuku
*
*   Licensed under the Apache License, Version 2.0 (the "License");
*   you may not use this file except in compliance with the License.
*   You may obtain a copy of the License at
*
*       http://www.apache.org/licenses/LICENSE-2.0
*
*   Unless required by applicable law or agreed to in writing, software
*   distributed under the License is distributed on an "AS IS" BASIS,
*   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*   See the License for the specific language governing permissions and
*   limitations under the License.
*/
package com.githukudenis.botan.core.data.repository

import com.githukudenis.botan.core.domain.model.Plant
import com.githukudenis.botan.core.domain.repository.PlantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakePlantRepository : PlantRepository {
    private val testingPlants =
        (0..5)
            .map {
                Plant(
                    plantId = it.toLong(),
                    commonName = "$it.commonName",
                    scientificName = "$it.scientificName",
                    description = "$it.description",
                    imageUri = "$it.imageUri",
                    wateringFrequency = "$it.freq",
                    lightRequirements = "$it.req",
                    temperatureRange = "$it.temp",
                    humidity = it,
                    lastWatered = it.toLong(),
                    nextWateringDue = it.toLong(),
                    fertilization = "$it.fertilization",
                    notes = "$it.notes",
                    tags = "$it.tags"
                )
            }
            .toMutableList()

    override val plants: Flow<List<Plant>>
        get() = flow { testingPlants }

    override suspend fun insertPlant(plant: Plant) {
        testingPlants.add(plant)
    }

    override suspend fun deletePlant(plant: Plant) {
        testingPlants.remove(plant)
    }

    override fun getPlantById(id: Long): Plant = testingPlants.first { it.plantId == id }

    override suspend fun updatePlant(plant: Plant) {
        testingPlants[plant.plantId.toInt()] = plant
    }
}
