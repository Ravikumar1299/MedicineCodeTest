package com.example.ravikumarcodetest.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ravikumarcodetest.room.dao.MedicineDao
import com.example.ravikumarcodetest.room.entries.AssociatedDrugEntity

@Database(entities = [AssociatedDrugEntity::class], version = 1, exportSchema = false)
abstract class MedicineDatabase : RoomDatabase() {

    abstract fun medicineDao(): MedicineDao

}
