package com.example.ravikumarcodetest.screens



import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import com.example.ravikumarcodetest.R
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState

import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.ravikumarcodetest.network.AssociatedDrug
import com.example.ravikumarcodetest.viewModel.AssociatedDrugPar
import com.example.ravikumarcodetest.viewModel.MedicineApiStatus
import com.example.ravikumarcodetest.viewModel.MedicineViewModel
import java.util.Calendar


@Composable
fun HomeScreen(
    navController: NavController,
    medicineViewModel: MedicineViewModel
) {
    val status by medicineViewModel.status.observeAsState(MedicineApiStatus.ERROR)
    val medications by medicineViewModel.associatedDrugs.observeAsState(emptyList())
//    val currentGreeting = getGreeting(currentTimeMillis(),username) // Get greeting based on time

//    Text(text = currentGreeting) // Display greeting
    LaunchedEffect(Unit) {
        medicineViewModel.retrieveSavedAssociatedDrugs()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when (status) {
            MedicineApiStatus.DONE -> {
                // Displaying list of medications (API + saved)
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(medications.size) { index ->
                        MedicationItem(medication = medications[index]) {
                            navController.navigate("details") {
//                                putParcelable("medicationId", index+1) // Pass medication ID as argument
                            }                        }
                    }
                }
            }

            MedicineApiStatus.LOADING -> {
                Image(
                    painter = rememberImagePainter(data = R.drawable.loading_animation),
                    contentDescription = "Loading Medications",
                    modifier = Modifier.fillMaxSize()
                )
            }

            else -> { // Error and the initial status
                Image(
                    painter = rememberImagePainter(data = R.drawable.ic_connection_error),
                    contentDescription = "Connection Error",
                    modifier = Modifier.fillMaxSize()
                )

                Text(
                    "Error! Can't connect to the internet.\n" +
                            "Check your internet connection.",
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }
    }
}

@Composable
private fun MedicationItem(medication: AssociatedDrug, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onClick() } // Use provided onClick callback
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Name: ${medication.name}",
                style = TextStyle(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = "Dose: ${medication.dose}",
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = "Strength: ${medication.strength}",
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
    }
}

@Composable
fun DetailsScreen(medicine: AssociatedDrugPar?) {
    if (medicine != null) {
        // Display medication details using medicine.name, medicine.dose, etc.
        Text("Name: ${medicine.name}")
        Text("Dose: ${medicine.dose}")
        Text("Strength: ${medicine.strength}")
    } else {
        // Handle the case where no medication was passed (optional)
        Text("No medication data found.")
    }
}


@Composable
fun LoginScreen(navController: NavController) {
    val username = remember { mutableStateOf("") } // Store username
    val email = remember { mutableStateOf("") } // Store email

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = username.value,
            onValueChange = { username.value = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))



        Button(
            onClick = {
                    navController.navigate("home")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Next")
        }
    }
}

fun getGreeting(currentTime: Long, username: MutableState<String>): String {
    val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    return when (hour) {
        in 0..11 -> "Good Morning,"
        in 12..17 -> "Good Afternoon,"
        else -> "Good Evening,"
    } + " ${username.value}" // Assuming username access (replace with email if needed)
}



