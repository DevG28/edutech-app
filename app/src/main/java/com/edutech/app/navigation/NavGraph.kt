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

object Routes {
    const val LOGIN = "login"
    const val HOME = "home"
    const val COURSES = "courses"
    const val DETAIL = "detail"
    const val PROFILE = "profile"
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.LOGIN
    ) {
        composable(Routes.LOGIN) {
            LoginScreen(navController)
        }
        composable(Routes.HOME) {
            HomeScreen(navController)
        }
        composable(Routes.COURSES) {
            CoursesScreen(navController)
        }
        composable("${Routes.DETAIL}/{courseId}") {
            val courseId = it.arguments?.getString("courseId")
            DetailScreen(navController, courseId)
        }
        composable(Routes.PROFILE) {
            ProfileScreen(navController)
        }
    }
}