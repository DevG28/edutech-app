package com.edutech.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.edutech.app.data.courseList
import com.edutech.app.navigation.Routes
import com.edutech.app.ui.components.CourseCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoursesScreen(navController: NavHostController) {
    var selectedCategory by remember { mutableStateOf("Todos") }
    val categories = listOf("Todos", "Programación 💻", "Diseño 🎨", "Negocios 📈")

    val filteredCourses = when (selectedCategory) {
        "Programación 💻" -> courseList.filter { it.category == "Programación" }
        "Diseño 🎨" -> courseList.filter { it.category == "Diseño" }
        "Negocios 📈" -> courseList.filter { it.category == "Negocios" }
        else -> courseList
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Cursos", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Text(text = "←", fontSize = 20.sp)
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            PrimaryScrollableTabRow(
                selectedTabIndex = categories.indexOf(selectedCategory)
            ) {
                categories.forEach { category ->
                    Tab(
                        selected = selectedCategory == category,
                        onClick = { selectedCategory = category },
                        text = { Text(category) }
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            if (filteredCourses.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    contentAlignment = androidx.compose.ui.Alignment.Center
                ) {
                    Text(
                        text = "No hay cursos en esta categoría",
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            } else {
                LazyColumn {
                    items(filteredCourses) { course ->
                        CourseCard(course = course) {
                            navController.navigate("${Routes.DETAIL}/${course.id}")
                        }
                    }
                }
            }
        }
    }
}