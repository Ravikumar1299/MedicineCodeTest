package com.example.ravikumarcodetest.room.entries

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "associated_drugs")
data class AssociatedDrugEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val dose: String,
    val strength: String
)

