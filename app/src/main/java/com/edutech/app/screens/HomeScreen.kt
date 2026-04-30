package com.edutech.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.edutech.app.navigation.Routes
import com.edutech.app.ui.components.EduAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            EduAppBar(
                title = "EduTech Academy",
                showBackButton = false
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(24.dp)
        ) {
            Text(
                text = "¡Hola, Estudiante!",
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "¿Qué quieres aprender hoy?",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Accesos rápidos",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(16.dp))

            // 🔹 BOTÓN CURSOS
            HomeMenuCard(
                title = "Explorar Cursos",
                subtitle = "Encuentra tu próxima habilidad",
                icon = "📚",
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                onClick = { navController.navigate(Routes.COURSES) }
            )

            // 🔹 BOTÓN MIS CURSOS
            HomeMenuCard(
                title = "Mis Cursos",
                subtitle = "Continúa donde lo dejaste",
                icon = "🎯",
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                onClick = { navController.navigate(Routes.MY_COURSES) }
            )

            // 🔹 BOTÓN PERFIL
            HomeMenuCard(
                title = "Mi Perfil",
                subtitle = "Configura tu cuenta",
                icon = "👤",
                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                onClick = { navController.navigate(Routes.PROFILE) }
            )
        }
    }
}

@Composable
fun HomeMenuCard(
    title: String,
    subtitle: String,
    icon: String,
    containerColor: androidx.compose.ui.graphics.Color,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = containerColor
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Row(
            modifier = Modifier.padding(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(56.dp),
                shape = RoundedCornerShape(16.dp),
                color = MaterialTheme.colorScheme.surface.copy(alpha = 0.3f)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(text = icon, fontSize = 28.sp)
                }
            }
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
