package com.example.ravikumarcodetest.activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels


import androidx.compose.material3.Scaffold

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ravikumarcodetest.screens.DetailsScreen
import com.example.ravikumarcodetest.screens.HomeScreen
import com.example.ravikumarcodetest.screens.LoginScreen
import com.example.ravikumarcodetest.viewModel.AssociatedDrugPar

import com.example.ravikumarcodetest.viewModel.MedicineViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val medicineViewModel: MedicineViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {
            BasicsApp(medicineViewModel)
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BasicsApp(medicineViewModel: MedicineViewModel) {

    val navController = rememberNavController()


    Scaffold(
        content = {
            NavHost(navController = navController, startDestination = "login") {
                composable("login") {
                    LoginScreen{
                        navController.navigate("home/${it}")
                    }
                }
                composable("home/{username}",
                    arguments = listOf(navArgument("username")
                {
                    type = NavType.StringType
                })) {
                 var username =   it.arguments!!.getString("username")
                    HomeScreen(navController,medicineViewModel,username)
                }
                composable("details") {
                    DetailsScreen(it.arguments?.getParcelable<AssociatedDrugPar>("selectedMedication"))
                }
            }
        }
    )
}

