package com.edutech.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.edutech.app.navigation.NavGraph
import com.edutech.app.ui.theme.EdutechAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EdutechAppTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}