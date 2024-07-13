package com.example.ravikumarcodetest.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


// Data class for Medication
@JsonClass(generateAdapter = true)
data class Medication(
    @Json(name = "name") val name: String,
    @Json(name = "dose") val dose: String = "", // Optional field with default value
    @Json(name = "strength") val strength: String
)

// Data class for AssociatedDrug (nested inside MedicationClass for simplicity)
@JsonClass(generateAdapter = true)
data class AssociatedDrug(
    @Json(name = "name") val name: String,
    @Json(name = "dose") val dose: String = "", // Optional field with default value
    @Json(name = "strength") val strength: String
)

@JsonClass(generateAdapter = true)
data class MedicationsClass(
    @Json(name = "className") val className: List<ClassName>,
    @Json(name = "className2") val className2: List<ClassName>
)

@JsonClass(generateAdapter = true)
data class ClassName(
    @Json(name = "associatedDrug") val associatedDrug: List<AssociatedDrug>,
    @Json(name = "associatedDrug#2") val associatedDrug2: List<AssociatedDrug>
)

// Data class for MedicationClass
@JsonClass(generateAdapter = true)
data class MedicationClass(
    @Json(name = "associatedDrug") val associatedDrug: List<AssociatedDrug>,
    @Json(name = "associatedDrug#2") val associatedDrug2: List<AssociatedDrug> // Assuming #2 represents another list
)

// Data class for Labs (can be empty for now)
@JsonClass(generateAdapter = true)
data class Labs(
    @Json(name = "missing_field") val missingField: String // Use Json for field name consistency
)

// Data class for a single health condition with its medications and labs
//@JsonClass(generateAdapter = true)
//data class HealthCondition(
//    @Json(name = "Diabetes") val conditionName: String,
//    @Json(name = "medications") val medications: List<MedicationClass>,
//    @Json(name = "labs") val labs: List<Labs>
//)


@JsonClass(generateAdapter = true)
data class Medications(
    @Json(name = "medicationsClasses") val medicationsClasses: List<MedicationsClass>
)

@JsonClass(generateAdapter = true)
data class Diabetes(
    @Json(name = "medications") val medications: List<Medications>,
    @Json(name = "labs") val labs: List<Labs>
)

@JsonClass(generateAdapter = true)
data class HealthCondition(
    @Json(name = "Diabetes") val diabetes: List<Diabetes>,
    @Json(name = "Asthma") val asthma: List<Map<String, Any>>
)



// Data class to represent the entire API response structure
@JsonClass(generateAdapter = true)
data class ApiResponse(
    @Json(name = "problems") val problems: List<HealthCondition>
)

