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

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.Update

@Database(entities = [PlantData::class], version = 1, exportSchema = true)
abstract class BotanDatabase : RoomDatabase() {

    abstract fun plantDao(): PlantDao
}

@Dao
interface PlantDao {

    @Insert fun insertPlant(plantData: PlantData)

    @Delete fun deletePlant(plantData: PlantData)

    @Query("SELECT * FROM PlantData ORDER BY plant_id") fun getAllPlants(): List<PlantData>

    @Query("SELECT * FROM PlantData WHERE plant_id LIKE :id limit 1")
    fun getPlantById(id: Long): PlantData

    @Update fun updatePlant(plantData: PlantData)
}

@Entity(tableName = "PlantData")
data class PlantData(
    @PrimaryKey(autoGenerate = true) val plant_id: Long = 0,
    val common_name: String,
    val scientific_name: String,
    val description: String,
    val image_uri: String,
    val watering_frequency: String,
    val light_requirements: String,
    val temperature_range: String,
    val humidity: Int = 0,
    val last_watered: Long,
    val next_watering_due: Long,
    val fertilization: String? = null,
    val notes: String? = null,
    val tags: String? = null
)
