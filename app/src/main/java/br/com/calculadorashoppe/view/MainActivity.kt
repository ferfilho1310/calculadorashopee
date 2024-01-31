package br.com.calculadorashoppe.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.calculadorashoppe.ui.theme.CalculadoraShoppeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraShoppeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Calculador de Preços - Shopee",
            modifier = Modifier.padding(20.dp),
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic
        )

        val price = priceProductField()
        val feeShopee = feeShopee()
        val add = addForProduct()
        val marginProfit = sliderMarginProfit()

        PriceSell(price, feeShopee, add, marginProfit)
    }
}

@Composable
fun PriceSell(
    price: String,
    feeShopee: String,
    add: String,
    marginProfit: Float
) {
    Button(
        onClick = {

        },
        colors = ButtonDefaults.buttonColors(Color.Red),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier.size(width = 300.dp, height = 50.dp)
    ) {
        Text(text = "Calcular")
    }
}

@Composable
fun sliderMarginProfit(): Float {
    var sliderPosition by remember { mutableStateOf(0f) }
    Column(
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
        )
        Text(text = sliderPosition.toString())
    }
    return sliderPosition
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun priceProductField(): String {
    var priceProduct by remember {
        mutableStateOf("")
    }

    TextField(
        value = priceProduct,
        onValueChange = { priceProduct = it },
        label = { Text(text = "Preço do produto") },
        maxLines = 1,
        textStyle = TextStyle(color = Color.Blue, fontWeight = FontWeight.Bold),
        modifier = Modifier
            .padding(20.dp),
    )
    return priceProduct
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun feeShopee(): String {
    var feeShopee by remember { mutableStateOf("") }

    TextField(
        value = feeShopee,
        onValueChange = { feeShopee = it },
        label = { Text(text = "Taxa da Shopee") },
        maxLines = 1,
        textStyle = TextStyle(color = Color.Blue, fontWeight = FontWeight.Bold),
        modifier = Modifier
            .padding(20.dp)
    )
    return feeShopee
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun addForProduct(): String {
    var addForProduct by remember { mutableStateOf("") }

    TextField(
        value = addForProduct,
        onValueChange = { addForProduct = it },
        label = { Text(text = "Acréscimo por produto") },
        maxLines = 1,
        textStyle = TextStyle(color = Color.Blue, fontWeight = FontWeight.Bold),
        modifier = Modifier
            .padding(20.dp)
    )
    return addForProduct
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculadoraShoppeTheme {
        Greeting()
    }
}