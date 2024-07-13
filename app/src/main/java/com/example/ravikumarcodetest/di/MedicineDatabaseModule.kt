package com.example.ravikumarcodetest.di

import android.content.Context
import androidx.room.Room
import com.example.ravikumarcodetest.R
import com.example.ravikumarcodetest.room.MedicineDatabase
import com.example.ravikumarcodetest.room.dao.MedicineDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class MedicineDatabaseModule {

    @Provides
    @Singleton
    fun provideMedicineDatabase(@ApplicationContext context: Context): MedicineDatabase {
        return Room.databaseBuilder(context, MedicineDatabase::class.java, "myMedicdatabase")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideMedicineDao(database: MedicineDatabase): MedicineDao {
        return database.medicineDao()
    }
}

