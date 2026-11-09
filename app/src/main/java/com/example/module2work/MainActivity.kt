package com.example.module2work

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.module2work.ui.theme.Module2WorkTheme

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
                    // Обычный вертикальный скролл, чтобы всё поместилось на экране
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        // Задание 1: Приветствие с null-безопасностью
                        Text("--- Задание 1: Null-безопасность ---", fontWeight = FontWeight.Bold, color = Color.Gray)
                        Hello("Денис")
                        Hello(null)

                        HorizontalDivider()

                        // Задание 3: Текстовые модификаторы
                        Text("--- Задание 3: Стили текста ---", fontWeight = FontWeight.Bold, color = Color.Gray)
                        Task3Text()

                        HorizontalDivider()

                        // Задание 4: Кнопка
                        Text("--- Задание 4: Кнопка ---", fontWeight = FontWeight.Bold, color = Color.Gray)
                        MyButton()

                        HorizontalDivider()

                        // Задание 5: Контейнер с кругом и инициалами
                        Text("--- Задание 5: Контейнер и инициалы ---", fontWeight = FontWeight.Bold, color = Color.Gray)
                        InitialsBox()

                        HorizontalDivider()

                        // Задания 6-7: Карточки контактов (Row/Column)
                        Text("--- Задания 6-7: Контакты (Row/Column) ---", fontWeight = FontWeight.Bold, color = Color.Gray)
                        ContactItem("Иван Иванов", "+7 (999) 123-45-67")
                        ContactItem("Анна Смирнова", "+7 (999) 765-43-21")

                        HorizontalDivider()

                        // Задания 8-10: Трекер воды (Состояние и логика)
                        Text("--- Задания 8-10: Трекер воды ---", fontWeight = FontWeight.Bold, color = Color.Gray)
                        WaterTrackerApp()
                    }
                }
            }
        }
    }
}

// Задание 1. Функция с проверкой на null
@Composable
fun Hello(name: String?) {
    // Если имя пришло (не null и не пустое), выводим его, иначе заглушку
    val text = if (!name.isNullOrBlank()) "Привет, $name!" else "Имя не задано"
    Text(text = text, fontSize = 18.sp)
}


// Задание 3. Примеры работы с текстом
@Composable
fun Task3Text() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        // Зеленый текст по центру
        Text(
            text = "Jetpack Compose — это современный UI для Android",
            color = Color.Green,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        // Текст в одну строку с троеточием (...) если не влезает
        Text(
            text = "Длинный текст который должен обрезаться в одну строчку без переносов на экране телефона",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        // Подчеркнутый текст с зеленым фоном
        Text(
            text = "Подчеркнутый текст",
            fontSize = 20.sp,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.background(Color.Green)
        )
    }
}


// Задание 4. Простая кнопка

@Composable
fun MyButton() {
    Button(
        onClick = { },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(text = "Нажми на меня", fontSize = 16.sp)
    }
}

// Задание 5. Контейнер с кругом и инициалами

@Composable
fun InitialsBox() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            shape = CircleShape,
            color = Color(0xFFFF5722),
            modifier = Modifier.size(60.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(text = "АБ", color = Color.White, fontWeight = FontWeight.Bold)
            }
        }
    }
}

// Задания 6-7. Элемент списка контактов (Row + Column)

@Composable
fun ContactItem(name: String, phone: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Круглая иконка слева
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.Blue, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(imageVector = Icons.Default.Person, contentDescription = null, tint = Color.White)
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Имя и телефон друг под другом (Column)
            Column(modifier = Modifier.weight(1f)) {
                Text(text = name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(text = phone, fontSize = 14.sp, color = Color.Gray)
            }

            // Иконка вызова справа
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Default.Call, contentDescription = null, tint = Color.Green)
            }
        }
    }
}

// Задания 8, 9, 10. Интерактивный трекер воды
@Composable
fun WaterTrackerApp() {
    // Состояния (mutableStateOf), которые перерисовывают экран при изменении
    var waterDrank by remember { mutableStateOf(0) } // выпито мл
    var successDays by remember { mutableStateOf(0) }  // дней с нормой >= 1500 мл

    val dailyGoal = 1500 // дневная норма

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Трекер воды", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(text = "Выпито сегодня: $waterDrank / $dailyGoal мл", fontSize = 16.sp)
            Text(text = "Дней подряд с нормой: $successDays", fontSize = 14.sp, color = Color.DarkGray)

            // Кнопка добавления воды (+250 мл)
            Button(
                onClick = { waterDrank += 250 },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Выпить стакан (+250 мл)")
            }

            // Кнопка завершения дня (проверка нормы)
            OutlinedButton(
                onClick = {
                    if (waterDrank >= dailyGoal) {
                        successDays += 1
                    }
                    waterDrank = 0 // сбрасываем на следующий день
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Завершить день")
            }
        }
    }
}