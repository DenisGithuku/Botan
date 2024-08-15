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
package com.githukudenis.botan.core.database

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith

@SmallTest
@RunWith(AndroidJUnit4::class)
class PlantDaoTest {

    private lateinit var botanDatabase: BotanDatabase
    private lateinit var plantDao: PlantDao

    @get:Rule val instantTaskExecutor by lazy { InstantTaskExecutorRule() }

    @Before
    fun setup() {
        botanDatabase =
            Room.inMemoryDatabaseBuilder(
                    ApplicationProvider.getApplicationContext(),
                    BotanDatabase::class.java
                )
                .allowMainThreadQueries()
                .build()
        plantDao = botanDatabase.plantDao()
    }

    @After
    fun tearDown() {
        botanDatabase.clearAllTables()
        botanDatabase.close()
    }

    @Test
    fun testInsertPlants() = runTest {
        val plant =
            PlantData(
                plant_id = 1,
                common_name = "name",
                scientific_name = "scientific",
                description = "desc",
                image_uri = "",
                watering_frequency = "",
                light_requirements = "",
                temperature_range = "",
                humidity = 23,
                last_watered = 0,
                next_watering_due = 1L,
                fertilization = "",
                notes = "",
                tags = ""
            )

        plantDao.insertPlant(plant)
        val plants = plantDao.getAllPlants()
        assert(plants.contains(plant))
    }

    @Test
    fun testDeletePlant() = runTest {
        val plant =
            PlantData(
                plant_id = 1,
                common_name = "name",
                scientific_name = "scientific",
                description = "desc",
                image_uri = "",
                watering_frequency = "",
                light_requirements = "",
                temperature_range = "",
                humidity = 23,
                last_watered = 0,
                next_watering_due = 1L,
                fertilization = "",
                notes = "",
                tags = ""
            )

        plantDao.insertPlant(plant)
        plantDao.deletePlant(plant)
        val plants = plantDao.getAllPlants()
        assert(plants.isEmpty())
    }

    @Test
    fun testUpdatePlant() = runTest {
        val plant =
            PlantData(
                plant_id = 1,
                common_name = "name",
                scientific_name = "scientific",
                description = "desc",
                image_uri = "",
                watering_frequency = "",
                light_requirements = "",
                temperature_range = "",
                humidity = 23,
                last_watered = 0,
                next_watering_due = 1L,
                fertilization = "",
                notes = "",
                tags = ""
            )
        plantDao.insertPlant(plant)
        plantDao.updatePlant(plant.copy(common_name = "common"))
        val updatedPlant = plantDao.getAllPlants().first()
        assertEquals("common", updatedPlant.common_name)
    }
}
