package com.example.chameleon.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.chameleon.R
import com.example.chameleon.navigation.AppScreens

@Composable
fun SecondScreen(navController: NavController){
    Scaffold {
        //Llama al navController y permite navegar
        SecondBodyContent(navController)
    }
}

@Composable
fun SecondBodyContent(navController: NavController){
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        SecondComponent(navController)
    }
}

@Composable
fun SecondContainedButtonExample(navController: NavController, text: String) {
    val WIDTH1 = 150.dp
    val WIDTH2 = 200.dp
    val WIDTH3 = 300.dp

    var width by remember { mutableStateOf(WIDTH1) }


    Button(
        onClick = {
            navController.navigate(route = AppScreens.FirstScreen.route)
            width = when (width) {
                WIDTH1 -> WIDTH2
                WIDTH2 -> WIDTH3
                else -> WIDTH1
            }
        },
        modifier = Modifier.size(width = 280.dp,height = 50.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.onBackground),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(text = text,
            color = Color(0xFFFFFFFF),
            style = MaterialTheme.typography.h6)
    }
}

@Composable
fun SecondText(text: String, font: TextUnit){
    Text(
        color = MaterialTheme.colors.primary,
        fontSize = font,
        modifier = Modifier
            .fillMaxWidth(),
        text = text,
        textAlign = TextAlign.Center)


}


@Composable
fun SecondImage() {
    Image(
        painterResource(R.drawable.icono),
        "Test image",
        modifier = Modifier
            .size(120.dp)

    )
}

@Composable
fun ConstructionImage() {
    Image(
        painterResource(R.drawable.site_under_construction),
        "Test image",
        modifier = Modifier
            .size(150.dp)

    )
}

@Composable
fun SecondComponent(navController: NavController){
    Column(modifier = Modifier
        .padding(start = 8.dp)
        .size(2500.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        SecondImage()
        SecondText("App en desarrollo" +
                        "", 30.sp)
        Spacer(modifier = Modifier.height(8.dp))
        SecondText("Esta app se encuentra en desarrollo, está desarrollada con el SDK de Android" +
                        " y lenguaje Kotlin usando el conjunto de librerias Jetpack." +
                        "", 20.sp)
        Spacer(modifier = Modifier.height(8.dp))
        //ConstructionImage()
        Spacer(modifier = Modifier.height(25.dp))
        SecondContainedButtonExample(navController, "Regresar")
    }
}

