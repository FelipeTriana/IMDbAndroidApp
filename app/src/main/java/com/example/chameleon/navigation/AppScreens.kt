package com.example.chameleon.navigation

sealed class AppScreens(val route: String){
    //Nuestras pantallas y sus rutas para crearse:
    object FirstScreen: AppScreens("first_screen")
    object SecondScreen: AppScreens("second_screen")
    object RegisterScreen: AppScreens("register_screen")



}
