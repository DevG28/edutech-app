package com.edutech.app

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import com.edutech.app.data.Course

object AppState {
    var userName = mutableStateOf("Estudiante EduTech")
    var userEmail = mutableStateOf("estudiante@edutech.com")
    val cursosInscritos = mutableStateListOf<Course>()

    // Usuarios registrados
    val usuarios = mutableMapOf(
        "estudiante@edutech.com" to "123456"
    )

    fun registrar(email: String, password: String) {
        usuarios[email] = password
    }

    fun loginValido(email: String, password: String): Boolean {
        return usuarios[email] == password
    }

    fun inscribirse(course: Course) {
        if (!cursosInscritos.contains(course)) {
            cursosInscritos.add(course)
        }
    }

    fun estaInscrito(course: Course): Boolean {
        return cursosInscritos.contains(course)
    }
}