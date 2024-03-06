package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MostrarContenido()
                }
            }
        }
    }
}

@Composable
fun MostrarContenido(modifier: Modifier = Modifier) {

    var tarjeta by remember { mutableStateOf(1) }

    val imageResource = when (tarjeta) {
        1 -> R.drawable.creaci_n_de_ad_n
        2 -> R.drawable.mona_lisa
        3 -> R.drawable.la_ultima_sena
        else -> R.drawable.la_noche_estrella
    }
    val stringResourceTitle = when (tarjeta) {
        1 -> R.string.titulo_CreacioAdan
        2 -> R.string.titulo_mona_lisa
        3 -> R.string.titulo_LaUltimaCena
        else -> R.string.titulo_NocheEstrella
    }
    val stringResourceArtist = when (tarjeta) {
        1 -> R.string.artista_Miguel_qngel
        2 -> R.string.artista_LeoVinci
        3 -> R.string.artista_LeVinci
        else -> R.string.artista_Vicente
    }

    Column(
        modifier = modifier
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = imageResource),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(500.dp)
                .width(350.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column (
            modifier = Modifier
                .background(Color.LightGray)
                .height(60.dp)
                .width(300.dp),
            horizontalAlignment = Alignment.Start
        ){
                Text(text = stringResource(stringResourceTitle),
                    fontFamily = FontFamily.Monospace,
                    fontSize = 20.sp)
                Text(text = stringResource(stringResourceArtist),
                    fontWeight = FontWeight.Bold
                )
        }

        Spacer(modifier = Modifier.height(32.dp))


        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ){
            Button(modifier = Modifier
                .size(width = 120.dp, height = 40.dp),
                onClick = {
                tarjeta = (1..4).random()
            }) {
                Text(text = stringResource(R.string.button_previous))
            }
            Spacer(modifier = Modifier.width(24.dp))
            Button(modifier = Modifier
                .size(width = 120.dp, height = 40.dp),onClick = {
                tarjeta = (1..4).random()
            }) {
                Text(text = stringResource(R.string.button_next))
            }
        }
    }

}


@Composable
@Preview
fun ContentPreview() {
    ArtSpaceTheme {
        MostrarContenido()
    }
}