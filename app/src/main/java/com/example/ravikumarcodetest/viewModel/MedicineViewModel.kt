package com.example.ravikumarcodetest.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ravikumarcodetest.network.AssociatedDrug
import com.example.ravikumarcodetest.network.MedicineApi
import com.example.ravikumarcodetest.room.MedicineDatabase
import com.example.ravikumarcodetest.room.dao.MedicineDao
import com.example.ravikumarcodetest.room.entries.AssociatedDrugEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


import kotlinx.coroutines.launch

enum class MedicineApiStatus { LOADING, ERROR, DONE }

@HiltViewModel
class MedicineViewModel @Inject constructor(
    private val medicineDao: MedicineDao

) : ViewModel()  {
    private val _status = MutableLiveData<MedicineApiStatus>()
    val status: LiveData<MedicineApiStatus>
        get() = _status

    private val _associatedDrugs = MutableLiveData<List<AssociatedDrug>>()
    val associatedDrugs: LiveData<List<AssociatedDrug>>
        get() = _associatedDrugs

    init {
        getMedicineProperties()
    }


    private fun getMedicineProperties() {
        viewModelScope.launch {
            _status.value = MedicineApiStatus.LOADING
            try {
                val response = MedicineApi.retrofitService.getMedicineProblem()
                _associatedDrugs.value = response.problems.flatMap { healthCondition ->
                    healthCondition.diabetes.flatMap { diabetes ->
                        diabetes.medications.flatMap { medications ->
                            medications.medicationsClasses.flatMap { medicationsClass ->
                                medicationsClass.className.flatMap { className ->
                                    className.associatedDrug + className.associatedDrug2
                                } + medicationsClass.className2.flatMap { className2 ->
                                    className2.associatedDrug + className2.associatedDrug2
                                }
                            }
                        }
                    }
                }


                val associatedDrugEntities = _associatedDrugs.value!!.map { drug ->
                    AssociatedDrugEntity(name = drug.name, dose = drug.dose, strength = drug.strength)
                }
                medicineDao.insertAssociatedDrugs(associatedDrugEntities)
                _associatedDrugs.value = _associatedDrugs.value // Update LiveData for UI
                _status.value = MedicineApiStatus.DONE
            } catch (e: Exception) {
                _status.value = MedicineApiStatus.ERROR
            }
        }
    }

    suspend fun retrieveSavedAssociatedDrugs(): List<AssociatedDrugEntity> {
        return medicineDao.getAssociatedDrugs()
    }
}

