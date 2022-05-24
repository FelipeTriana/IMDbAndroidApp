package com.example.chameleon.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chameleon.screens.FirstScreen
import com.example.chameleon.screens.RegisterScreen
import com.example.chameleon.screens.SecondScreen

//Elemento composable encargado de orquestar la navegacion
//Conocerá las pantallas de nuestra app y gestionará el paso entre ellas de la manera correcta
@Composable
fun AppNavigation(){
    /*
    navController se propaga en todas las pantallas ya que permite saber el estado de navegación entre ellas y así
    podernos desplazar entre cada una*/
    /*
    navController es el unico que conoce el estado de navegacion actual, así que a cada funcion de pantalla
    se le tiene que dar la posibilidad de recibir un parametro que sea un navController
    (ej: FirstScreen(navController: NavController))
    */
    val navController = rememberNavController()
    /*
    NavHost conocerá las pantallas y como navegar entre ellas
     */
    NavHost(navController = navController, startDestination = AppScreens.FirstScreen.route){
        /*
         NavHost esta conformado por diferentes composables, composables que van a designar a cada una
         de las pantallas
         */
        composable(route = AppScreens.FirstScreen.route){
            //Esta ruta hace referencia al objeto composable FirstScreen
            FirstScreen(navController)
        }
        composable(route = AppScreens.SecondScreen.route){
            //Esta ruta hace referencia al objeto composable SecondScreen
            SecondScreen(navController)
        }
        composable(route = AppScreens.RegisterScreen.route){
            //Esta ruta hace referencia al objeto composable SecondScreen
            RegisterScreen(navController)
        }
    }
}