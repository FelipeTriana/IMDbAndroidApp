package com.example.chameleon

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chameleon.navigation.AppNavigation
import com.example.chameleon.screens.FirstScreen
import com.example.chameleon.ui.theme.ChameleonTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        //Thread.sleep(500)
        setTheme(R.style.Theme_Chameleon)
        super.onCreate(savedInstanceState)
        //Todo lo que situemos dentro de setContent seran elementos composable(Que conforman la UI de la APP)
        setContent {

            ChameleonTheme(darkTheme = true) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = MaterialTheme.colors.background)
                )
                /*Llamaremos a AppNavegation() en el MainActivity y en la Preview: Encargado de gestionar
                la navegación y que sabe cual es la primera pantalla
                */
                AppNavigation()
                //myComponent()
            }

        }
    }
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun DefaultPreview(){
    ChameleonTheme(darkTheme = true) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Black)
        )
        /*Llamaremos a AppNavegation() en el MainActivity y en la Preview: Encargado de gestionar
        la navegación y que sabe cual es la primera pantalla
        */
        AppNavigation()
        //myComponent()
    }
}

