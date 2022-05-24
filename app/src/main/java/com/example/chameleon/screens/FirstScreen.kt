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
import com.example.chameleon.navigation.AppScreens

@Composable
fun FirstScreen(navController: NavController){
    Scaffold {
        //Llama al navController y permite navegar
        bodyContent(navController)
    }
}

@Composable
fun bodyContent(navController: NavController){

    Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
        myImage()
        myComponent(navController)
        myText(text = "Ó puedes ingresar con", 20.sp)
        Spacer(modifier = Modifier.height(15.dp))
        Row(){
            loginOptions(drawable = R.mipmap.mac_icono)
            Spacer(modifier = Modifier.width(40.dp))
            loginOptions(drawable = R.mipmap.fb_icono)
            Spacer(modifier = Modifier.width(40.dp))
            loginOptions(drawable = R.mipmap.google_icono)
        }
        enterOptions(navController)

    }



}



@Composable
fun ContainedButtonExample(navController: NavController, text: String) {
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
fun loginOptions(drawable: Int){
    IconButton(onClick = {
        //Toast.makeText( this,"Clicked on Icon Button", Toast.LENGTH_SHORT).show()
    }, enabled = true) {
        myIconImage(drawable)
    }

}

@Composable
fun enterOptions(navController: NavController){
    Column( horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(15.dp))
        TextButton(
            onClick = { navController.navigate(route = AppScreens.RegisterScreen.route) },
            colors = ButtonDefaults.textButtonColors(
                contentColor = MaterialTheme.colors.primaryVariant
            )
        ) {
            Text("¿No tienes cuenta? Regístrate", fontSize = 18.sp)
        }
        Spacer(modifier = Modifier.height(8.dp))
        TextButton(
            onClick = { navController.navigate(route = AppScreens.SecondScreen.route) },
            colors = ButtonDefaults.textButtonColors(
                contentColor = MaterialTheme.colors.primary,
            )
        ) {
            Text("Continuar como invitado", fontSize = 18.sp)
        }
    }
}

@Composable
fun myText(text: String, fontSize: TextUnit){
    Text(text, fontSize = fontSize,
        color = MaterialTheme.colors.primaryVariant)
}


@Composable
fun myImage() {
    Image(
        painterResource(R.drawable.icono),
        "Test image",
        modifier = Modifier
            .size(120.dp)

    )
}

@Composable
fun myIconImage(drawable: Int) {
    Image(
        painterResource(drawable),
        "Test image",
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colors.secondary)
            .size(52.dp)

    )
}

@Composable
fun textAndPlace(text: String,){


        var textState by remember { mutableStateOf("") }

        TextField(
            value = textState,
            onValueChange = { textState = it },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.secondary
            ), shape = RoundedCornerShape(12.dp)
        )


}

@Composable
fun myComponent(navController: NavController){
    Column(modifier = Modifier
        .padding(start = 8.dp)
        ,
        verticalArrangement = Arrangement.Center) {
        Text(
            "Usuario",
            fontSize = 20.sp,
            color = MaterialTheme.colors.primaryVariant,
            textAlign = Left
            )


        textAndPlace(text = "Usuario")

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            "Contraseña",
            fontSize = 20.sp,
            color = MaterialTheme.colors.primaryVariant,
            textAlign = Left
        )


        textAndPlace(text = "Usuario")

        Spacer(modifier = Modifier.height(50.dp))
        ContainedButtonExample(navController = navController, text = "Login")

        Spacer(modifier = Modifier.height(25.dp))


    }
}





