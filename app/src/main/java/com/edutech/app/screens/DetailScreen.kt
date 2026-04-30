package com.edutech.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.edutech.app.AppState
import com.edutech.app.data.courseList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavHostController, courseId: String?) {
    val course = courseList.find { it.id.toString() == courseId }
    val inscrito = course?.let { AppState.estaInscrito(it) } ?: false

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(course?.title ?: "Detalle", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Text(text = "←", fontSize = 20.sp)
                    }
                }
            )
        }
    ) { padding ->
        if (course == null) {
            Box(modifier = Modifier.padding(padding).fillMaxSize()) {
                Text("Curso no encontrado", modifier = Modifier.padding(24.dp))
            }
        } else {
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(24.dp)
            ) {
                // Imagen placeholder
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Text(
                            text = when (course.category) {
                                "Programación" -> "💻"
                                "Diseño" -> "🎨"
                                "Negocios" -> "📈"
                                else -> "📚"
                            },
                            fontSize = 64.sp,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))
                Text(text = course.title, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "👨‍🏫 ${course.instructor}", fontSize = 15.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "📊 Nivel: ${course.level}", fontSize = 15.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "🗂️ Categoría: ${course.category}", fontSize = 15.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "⏱️ Duración: ${course.duration}", fontSize = 15.sp)
                Spacer(modifier = Modifier.height(16.dp))
                HorizontalDivider()
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Descripción", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = course.description, fontSize = 14.sp, lineHeight = 22.sp)
                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = { AppState.inscribirse(course) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    enabled = !inscrito,
                    colors = if (inscrito) ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.secondary
                    ) else ButtonDefaults.buttonColors()
                ) {
                    Text(
                        text = if (inscrito) "✅ Ya estás inscrita" else "Inscribirse",
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}