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

import com.githukudenis.botan.core.database.PlantDao
import com.githukudenis.botan.core.database.PlantData
import com.githukudenis.botan.core.domain.model.Plant
import com.githukudenis.botan.core.domain.repository.PlantRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PlantRepositoryImpl @Inject constructor(private val plantDao: PlantDao) : PlantRepository {
    override val plants: Flow<List<Plant>>
        get() = flow { plantDao.getAllPlants() }

    override suspend fun insertPlant(plant: Plant) {
        plantDao.insertPlant(plant.asPlantData())
    }

    override suspend fun deletePlant(plant: Plant) {
        plantDao.deletePlant(plant.asPlantData())
    }

    override fun getPlantById(id: Long): Plant = plantDao.getPlantById(id).asPlant()

    override suspend fun updatePlant(plant: Plant) {
        plantDao.updatePlant(plant.asPlantData())
    }
}

fun Plant.asPlantData(): PlantData {
    return PlantData(
        plant_id = plantId,
        common_name = commonName,
        scientific_name = scientificName,
        description = description,
        image_uri = imageUri,
        watering_frequency = wateringFrequency,
        light_requirements = lightRequirements,
        temperature_range = temperatureRange,
        humidity = humidity,
        last_watered = lastWatered,
        next_watering_due = nextWateringDue,
        fertilization = fertilization,
        notes = notes,
        tags = tags
    )
}

fun PlantData.asPlant(): Plant {
    return Plant(
        plantId = plant_id,
        commonName = common_name,
        scientificName = scientific_name,
        description = description,
        imageUri = image_uri,
        wateringFrequency = watering_frequency,
        lightRequirements = light_requirements,
        temperatureRange = temperature_range,
        humidity = humidity,
        lastWatered = last_watered,
        nextWateringDue = next_watering_due,
        fertilization = fertilization,
        notes = notes,
        tags = tags
    )
}
