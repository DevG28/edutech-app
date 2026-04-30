package com.edutech.app.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SearchOff
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.edutech.app.data.courseList
import com.edutech.app.navigation.Routes
import com.edutech.app.ui.components.CourseCard
import com.edutech.app.ui.components.EduAppBar
import com.edutech.app.ui.components.EmptyStateView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoursesScreen(navController: NavHostController) {
    var selectedCategory by remember { mutableStateOf("Todos") }
    val categories = listOf("Todos", "Programación 💻", "Diseño 🎨", "Negocios 📈")
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    val filteredCourses = remember(selectedCategory) {
        if (selectedCategory == "Todos") courseList
        else courseList.filter { it.category == selectedCategory.dropLast(2).trim() }
    }

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            EduAppBar(
                title = "Explorar Cursos",
                onBackClick = { navController.popBackStack() },
                scrollBehavior = scrollBehavior
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            // Selector de categorías mejorado
            ScrollableTabRow(
                selectedTabIndex = categories.indexOf(selectedCategory),
                edgePadding = 16.dp,
                containerColor = MaterialTheme.colorScheme.background,
                contentColor = MaterialTheme.colorScheme.primary,
                divider = {},
                indicator = { tabPositions ->
                    if (categories.indexOf(selectedCategory) < tabPositions.size) {
                        TabRowDefaults.SecondaryIndicator(
                            Modifier.tabIndicatorOffset(tabPositions[categories.indexOf(selectedCategory)]),
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            ) {
                categories.forEach { category ->
                    Tab(
                        selected = selectedCategory == category,
                        onClick = { selectedCategory = category },
                        text = { 
                            Text(
                                text = category,
                                style = if (selectedCategory == category) 
                                    MaterialTheme.typography.labelLarge 
                                else 
                                    MaterialTheme.typography.labelMedium
                            ) 
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Animación de entrada para la lista
            AnimatedContent(
                targetState = filteredCourses,
                transitionSpec = {
                    fadeIn() togetherWith fadeOut()
                },
                label = "ListAnimation"
            ) { courses ->
                if (courses.isEmpty()) {
                    EmptyStateView(
                        icon = Icons.Default.SearchOff,
                        message = "No hay cursos disponibles",
                        description = "Prueba seleccionando otra categoría o vuelve más tarde."
                    )
                } else {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(bottom = 16.dp)
                    ) {
                        items(courses, key = { it.id }) { course ->
                            CourseCard(course = course) {
                                navController.navigate("${Routes.DETAIL}/${course.id}") {
                                    launchSingleTop = true
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

