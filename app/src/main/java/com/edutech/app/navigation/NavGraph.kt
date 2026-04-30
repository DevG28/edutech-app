package com.edutech.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.edutech.app.ui.screens.CoursesScreen
import com.edutech.app.ui.screens.DetailScreen
import com.edutech.app.ui.screens.HomeScreen
import com.edutech.app.ui.screens.LoginScreen
import com.edutech.app.ui.screens.ProfileScreen
import com.edutech.app.ui.screens.MyCoursesScreen // 🔥 NUEVO

object Routes {
    const val LOGIN = "login"
    const val HOME = "home"
    const val COURSES = "courses"
    const val DETAIL = "detail"
    const val PROFILE = "profile"
    const val MY_COURSES = "my_courses" // 🔥 NUEVO
}

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Routes.LOGIN
    ) {

        // LOGIN
        composable(Routes.LOGIN) {
            LoginScreen(navController)
        }

        // HOME
        composable(Routes.HOME) {
            HomeScreen(navController)
        }

        // COURSES
        composable(Routes.COURSES) {
            CoursesScreen(navController)
        }

        // DETAIL (con parámetro)
        composable("${Routes.DETAIL}/{courseId}") {
            val courseId = it.arguments?.getString("courseId") ?: ""
            DetailScreen(navController, courseId)
        }

        // PROFILE
        composable(Routes.PROFILE) {
            ProfileScreen(navController)
        }

        // 🔥 MY COURSES (NUEVO)
        composable(Routes.MY_COURSES) {
            MyCoursesScreen(navController)
        }
    }
}