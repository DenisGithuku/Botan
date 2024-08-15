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
package com.githukudenis.botan.core.domain.model

data class Plant(
    val plantId: Long = 0,
    val commonName: String,
    val scientificName: String,
    val description: String,
    val imageUri: String,
    val wateringFrequency: String,
    val lightRequirements: String,
    val temperatureRange: String,
    val humidity: Int = 0,
    val lastWatered: Long,
    val nextWateringDue: Long,
    val fertilization: String? = null,
    val notes: String? = null,
    val tags: String? = null
)
