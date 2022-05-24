package com.example.chameleon.screens

import android.widget.TextView
import android.widget.Toast
import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.*
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.text.style.TextAlign.Companion.Left
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.chameleon.R
import com.example.chameleon.navigation.AppNavigation
import com.example.chameleon.navigation.AppScreens
import com.example.chameleon.ui.theme.ChameleonTheme

@Composable
fun RegisterScreen(navController: NavController){
    Scaffold {

        ChameleonTheme(darkTheme = true) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colors.secondary)
            )
            bodyContentRegister(navController)
        }

    }
}

@Composable
fun bodyContentRegister(navController: NavController){
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        myComponentRegister(navController)



    }



}



@Composable
fun ContainedButtonRegister(navController: NavController, text: String) {
    val WIDTH1 = 150.dp
    val WIDTH2 = 200.dp
    val WIDTH3 = 300.dp

    var width by remember { mutableStateOf(WIDTH1) }


    Button(
        onClick = {
            navController.navigate(route = AppScreens.SecondScreen.route)
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
fun myTextRegister(text: String, fontSize: TextUnit){
    Text(text, fontSize = fontSize,
        color = MaterialTheme.colors.primaryVariant)
}


@Composable
fun myImageRegister() {
    Image(
        painterResource(R.drawable.secundaryicon),
        "Test image",
        modifier = Modifier
            .size(120.dp)

    )
}



@Composable
fun textAndPlaceRegister(text: String,){


    var textState by remember { mutableStateOf("") }

    OutlinedTextField(
        value = textState,
        onValueChange = { textState = it },
        shape = RoundedCornerShape(12.dp),
        label = { Text( text = text) },
        enabled = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = MaterialTheme.colors.primaryVariant)
    )


}

@Composable
fun myComponentRegister(navController: NavController){
    Column(modifier = Modifier
        .padding(start = 8.dp)
        ,
        verticalArrangement = Arrangement.Center) {
        myImageRegister()
        Text(
            "Crear una cuenta",
            fontSize = 23.sp,
            color = MaterialTheme.colors.primary,
            textAlign = Left
        )
        Spacer(modifier = Modifier.height(25.dp))

        textAndPlaceRegister(text = "Nombre")

        Spacer(modifier = Modifier.height(25.dp))

        textAndPlaceRegister(text = "Correo electrónico")

        Spacer(modifier = Modifier.height(25.dp))

        textAndPlaceRegister(text = "Contraseña")

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            "La contraseña debe contener 8 caracteres",
            fontSize = 15.sp,
            color = MaterialTheme.colors.primaryVariant,
            textAlign = Left
        )


        Spacer(modifier = Modifier.height(50.dp))

        ContainedButtonRegister(navController = navController, text = "Aceptar")



    }
}

