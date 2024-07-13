package com.example.ravikumarcodetest.viewModel

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AssociatedDrugPar(
    val name: String,
    val dose: String,
    val strength: String
) : Parcelable
