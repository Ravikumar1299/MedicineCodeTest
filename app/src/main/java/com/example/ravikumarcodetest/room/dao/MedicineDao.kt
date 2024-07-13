package com.example.ravikumarcodetest.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ravikumarcodetest.room.entries.AssociatedDrugEntity

@Dao
interface MedicineDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAssociatedDrugs(drugs: List<AssociatedDrugEntity>)

    @Query("SELECT * FROM associated_drugs")
    suspend fun getAssociatedDrugs(): List<AssociatedDrugEntity>

    @Query("SELECT * FROM associated_drugs WHERE id= :id")
    suspend fun getAssociatedDrugsById(id:String): AssociatedDrugEntity
}
