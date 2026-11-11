package com.example.module2work

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.module2work.ui.theme.Module2WorkTheme
import kotlin.random.Random
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Module2WorkTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text("--- Задание 1: Приветствие с null ---", fontWeight = FontWeight.Bold)
                        Hello("Денис Семёнов")
                        Hello(null)

                        HorizontalDivider()

                        Text("--- Задание 3: Стили текста ---", fontWeight = FontWeight.Bold)
                        Task3TextExamples()

                        HorizontalDivider()

                        Text("--- Задание 4: Кнопка ---", fontWeight = FontWeight.Bold)
                        Task4Button()

                        HorizontalDivider()

                        Text("--- Задание 5: Контейнер с инициалами ---", fontWeight = FontWeight.Bold)
                        Task5InitialsBox()

                        HorizontalDivider()

                        Text("--- Задание 6: Векторные круги ---", fontWeight = FontWeight.Bold)
                        Task6VectorCircles()

                        HorizontalDivider()

                        Text("--- Задание 7: Контакты (Column и Row) ---", fontWeight = FontWeight.Bold)
                        Task7ContactsSection()

                        HorizontalDivider()

                        Text("--- Задания 8-9: Трекер воды ---", fontWeight = FontWeight.Bold)
                        WaterTracker()

                        HorizontalDivider()

                        Text("--- Задание 10: Интернет-магазин (Исправленный) ---", fontWeight = FontWeight.Bold)
                        ShoppingCartScreen()
                    }
                }
            }
        }
    }
}

// ЗАДАНИЕ 1

@Composable
fun Hello(name: String?) {
    val text = if (!name.isNullOrBlank()) "Привет, $name!" else "Имя не задано"
    Text(text = text, fontSize = 18.sp)
}

// ЗАДАНИЕ 2 (Варианты предпросмотра)
@Preview(name = "portrait", showBackground = true)
@Composable
fun HelloPreviewPortrait() {
    Module2WorkTheme { Hello("Денис Семёнов") }
}

@Preview(name = "landscape", showBackground = true, widthDp = 640, heightDp = 360)
@Composable
fun HelloPreviewLandscape() {
    Module2WorkTheme { Hello("Денис Семёнов") }
}

@Preview(name = "round", showBackground = true, backgroundColor = 0xFFFFEB3B, widthDp = 200, heightDp = 200)
@Composable
fun HelloPreviewRound() {
    Module2WorkTheme { Hello("Денис Семёнов") }
}
// ЗАДАНИЕ 3
@Composable
fun Task3TextExamples() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(
            text = "Jetpack Compose — это современный набор инструментов для создания пользовательского интерфейса (UI) на Android, разработанный Google",
            fontSize = 24.sp,
            color = Color.Black,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier
                .padding(top = 48.dp)
                .background(Color.Green)
        )
        Text(
            text = "Jetpack Compose — это современный набор инструментов для создания пользовательского интерфейса (UI) на Android, разработанный Google",
            color = Color.Green,
            fontSize = 16.sp,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Jetpack Compose — это современный набор инструментов для создания пользовательского интерфейса (UI) на Android, разработанный Google",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}
// ЗАДАНИЕ 4

@Composable
fun Task4Button() {
    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .shadow(4.dp, RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(2.dp, Color.Gray),
        colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)
    ) {
        Text(text = "Нажми на меня", color = Color.Black, fontSize = 16.sp)
    }
}

// ЗАДАНИЕ 5
@Composable
fun Task5InitialsBox() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            shape = CircleShape,
            color = Color(0xFFFF5722),
            modifier = Modifier
                .fillMaxHeight()
                .padding(vertical = 16.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                // Инициалы: Семёнов Денис -> СД
                Text(text = "СД", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }
    }
}
// ЗАДАНИЕ 6
@Composable
fun Task6VectorCircles() {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Box(
            modifier = Modifier
                .width(240.dp)
                .height(120.dp)
                .background(Color.Black),
            contentAlignment = Alignment.TopEnd
        ) {
            Image(
                painter = painterResource(id = R.drawable.circle),
                contentDescription = null,
                modifier = Modifier.size(48.dp)
            )
        }

        Box(
            modifier = Modifier
                .width(240.dp)
                .height(120.dp)
                .background(Color.Blue),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .background(Color.Magenta, CircleShape)
            )
        }
    }
}

// ЗАДАНИЕ 7

@Composable
fun Task7ContactsSection() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(12.dp)) {
                Text(text = "Имя: Денис")
                Text(text = "Отчество: Александрович")
                Text(text = "Фамилия: Семёнов")
                Text(text = "Мобильный телефон: +7 999 123 45 67")
                Text(text = "Адрес: г. Москва, ул. Студенческая, д. 10")
            }
        }

        Card(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = "Имя: Денис")
                    Text(text = "Отчество: Александрович")
                    Text(text = "Фамилия: Семёнов")
                    Text(text = "Мобильный телефон: +7 999 123 45 67")
                    Text(text = "Адрес: г. Москва, ул. Студенческая, д. 10")
                }
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    tint = Color(0xFFFF9800),
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}

// ЗАДАНИЕ 8

@Composable
fun WaterTracker() {
    var waterCount by remember { mutableStateOf(0) }
    var successDays by remember { mutableStateOf(0) }
    val primaryColor = Color(0xFF415f91)
    val secondaryColor = Color(0xFF565f71)

    Card(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(text = "Трекер воды", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = primaryColor)
            Text(text = "$waterCount мл", fontSize = 40.sp, fontWeight = FontWeight.Bold, color = secondaryColor)
            Text(text = "Дней подряд с нормой (>=1500 мл): $successDays", fontSize = 14.sp)

            Button(
                colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
                onClick = { waterCount += 250 },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "+250 мл", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }

            OutlinedButton(
                onClick = {
                    if (waterCount >= 1500) {
                        successDays += 1
                    } else {
                        successDays = 0
                    }
                    waterCount = 0
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Завершить день", color = primaryColor)
            }
        }
    }
}

// ЗАДАНИЕ 10
data class Product(val id: Int, val name: String, val price: Int)

@Composable
fun ShoppingCartScreen() {
    val context = LocalContext.current
    var products by remember {
        mutableStateOf(
            listOf(
                Product(0, "Товар #1", 100),
                Product(1, "Товар #2", 150),
                Product(2, "Товар #3", 56)
            )
        )
    }

    val totalSum = products.sumOf { it.price }
    val productSize = products.size

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        for (product in products) {
            Text(text = "${product.name} - ${product.price} рублей")
        }

        Spacer(modifier = Modifier.height(6.dp))
        Text(text = "Товаров на сумму: $totalSum рублей", fontWeight = FontWeight.Bold)

        Button(onClick = {
            products = products + Product(
                id = products.size,
                name = "Товар #${products.size + 1}",
                price = Random.nextInt(10, 100)
            )
        }) {
            Text(text = "Добавить товар")
        }

        if (totalSum > 500) {
            LaunchedEffect(totalSum) {
                Toast.makeText(context, "Доставка бесплатная!", Toast.LENGTH_SHORT).show()
            }
        }

        if (productSize > 0) {
            OutlinedButton(onClick = {
                if (products.isNotEmpty()) {
                    products = products.dropLast(1)
                }
            }) {
                Text(text = "Удалить товар")
            }
        }
    }
}