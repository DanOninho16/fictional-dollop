package com.github.danoninho16.crispygoggles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.danoninho16.crispygoggles.ui.theme.JetpackComposebasicoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposebasicoTheme {
                // A surface container using the 'background' color from the theme
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {

    Surface(modifier) {
        Greetings()
    }
}

@Composable
private fun Greetings(
    modifier: Modifier = Modifier,
    names: List<ItemCompra> = listaCompra
) {
    Column(modifier = modifier.padding(vertical = 4.dp)) {
        for (name in names) {
            Greeting(nome = name.nome, quant = name.quant, desc = name.desc)
        }
    }
}

@Composable
private fun Greeting(nome: String, quant: Int, desc: String) {

    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier
                .weight(1f)
            ) {
                Text(text = nome)
                Text(if (expanded.value) "Quantidade: $quant" else " ")
                Text(if (expanded.value) "$desc" else " ")
            }
            Button(
                onClick = { expanded.value = !expanded.value }
            ) {
                Text(if (expanded.value) "Mostrar menos" else "Mostrar mais")
            }

            }
        }
    }


@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    JetpackComposebasicoTheme {
        Greetings()
    }
}

@Preview
@Composable
fun MyAppPreview() {
    JetpackComposebasicoTheme {
        MyApp(Modifier.fillMaxSize())
    }
}


data class ItemCompra(
    val nome: String,
    val quant: Int,
    val desc: String
)

val listaCompra = listOf(
    ItemCompra(nome = "Batata",
    quant = 12,
    desc = "Tubérculo, ótima fonte de potássio."),
    ItemCompra(nome = "Caixa Misteriosa",
    quant = 506,
    desc = "é um mistério, descubra."),
    ItemCompra(nome = "Chacolaite",
        quant = 3,
        desc = "Chocolate Garoto, meio amargo."),
    ItemCompra(nome = "Sabão em pó",
        quant = 1,
        desc = "para lavar roupas."),
    ItemCompra(nome = "Suco de Laranja.",
        quant = 2,
        desc = "Del Valle é suco.")
)
