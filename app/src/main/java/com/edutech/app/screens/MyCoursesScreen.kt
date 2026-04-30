package com.edutech.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.edutech.app.AppState
import com.edutech.app.ui.components.CourseCard
import com.edutech.app.ui.components.EduAppBar
import com.edutech.app.ui.components.EmptyStateView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCoursesScreen(navController: NavHostController) {
    val cursos = AppState.cursosInscritos
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            EduAppBar(
                title = "Mis Cursos",
                onBackClick = { navController.popBackStack() },
                scrollBehavior = scrollBehavior
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        if (cursos.isEmpty()) {
            EmptyStateView(
                icon = Icons.AutoMirrored.Filled.MenuBook,
                message = "Aún no tienes cursos",
                description = "Explora el catálogo y comienza a aprender hoy mismo."
            )
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(
                    top = padding.calculateTopPadding(),
                    bottom = padding.calculateBottomPadding() + 16.dp
                )
            ) {
                items(cursos) { course ->
                    CourseCard(course = course) {
                        navController.navigate("detail/${course.id}")
                    }
                }
            }
        }
    }
}

