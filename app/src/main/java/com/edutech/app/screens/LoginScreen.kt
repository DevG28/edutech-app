package com.edutech.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.edutech.app.AppState
import com.edutech.app.navigation.Routes

@Composable
fun LoginScreen(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }
    var isRegisterMode by remember { mutableStateOf(false) }
    var registerEmail by remember { mutableStateOf("") }
    var registerPassword by remember { mutableStateOf("") }
    var registerConfirm by remember { mutableStateOf("") }
    var registerSuccess by remember { mutableStateOf(false) }
    var passwordVisible by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Header Area con un toque visual
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(
                        MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
                        RoundedCornerShape(32.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text("🎓", fontSize = 48.sp)
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "EduTech Academy",
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Tu futuro comienza aquí 🚀",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(48.dp))

            if (!isRegisterMode) {
                // MODO LOGIN
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it; error = "" },
                    label = { Text("Correo electrónico") },
                    leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it; error = "" },
                    label = { Text("Contraseña") },
                    leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
                    trailingIcon = {
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                contentDescription = null
                            )
                        }
                    },
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    )
                )

                if (error.isNotEmpty()) {
                    Text(
                        text = error,
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(top = 8.dp).fillMaxWidth(),
                        textAlign = TextAlign.Start
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                com.edutech.app.ui.components.EduButton(
                    text = "Iniciar Sesión",
                    onClick = {
                        val cleanEmail = email.trim()
                        when {
                            cleanEmail.isEmpty() || password.isEmpty() ->
                                error = "⚠️ Completa todos los campos"
                            !android.util.Patterns.EMAIL_ADDRESS.matcher(cleanEmail).matches() ->
                                error = "⚠️ Formato de correo inválido"
                            !AppState.loginValido(cleanEmail, password) -> {
                                error = "❌ Credenciales incorrectas"
                                password = "" // Limpieza de seguridad
                            }
                            else -> {
                                AppState.userName.value = cleanEmail.substringBefore("@").replaceFirstChar { it.uppercase() }
                                AppState.userEmail.value = cleanEmail
                                navController.navigate(Routes.HOME) {
                                    popUpTo(Routes.LOGIN) { inclusive = true }
                                    launchSingleTop = true
                                }
                            }
                        }
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))
                TextButton(onClick = { isRegisterMode = true; error = ""; email = ""; password = "" }) {
                    Text("¿Nuevo por aquí? Crea una cuenta", style = MaterialTheme.typography.labelLarge)
                }

            } else {
                // MODO REGISTRO
                Text(
                    text = "Crea tu cuenta",
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(24.dp))

                if (registerSuccess) {
                    Card(
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "✅ ¡Registro completado!",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                            Text(
                                text = "Ya puedes acceder a todos nuestros cursos.",
                                style = MaterialTheme.typography.bodySmall,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    com.edutech.app.ui.components.EduButton(
                        text = "Ir al Login",
                        onClick = {
                            isRegisterMode = false
                            registerSuccess = false
                            email = registerEmail
                            registerEmail = ""
                            registerPassword = ""
                            registerConfirm = ""
                        }
                    )
                } else {
                    OutlinedTextField(
                        value = registerEmail,
                        onValueChange = { registerEmail = it; error = "" },
                        label = { Text("Correo electrónico") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(focusedContainerColor = Color.White, unfocusedContainerColor = Color.White)
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    OutlinedTextField(
                        value = registerPassword,
                        onValueChange = { registerPassword = it; error = "" },
                        label = { Text("Contraseña (mín. 6 caracteres)") },
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(focusedContainerColor = Color.White, unfocusedContainerColor = Color.White)
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    OutlinedTextField(
                        value = registerConfirm,
                        onValueChange = { registerConfirm = it; error = "" },
                        label = { Text("Confirmar contraseña") },
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(focusedContainerColor = Color.White, unfocusedContainerColor = Color.White)
                    )

                    if (error.isNotEmpty()) {
                        Text(
                            text = error,
                            color = MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.labelMedium,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(32.dp))

                    com.edutech.app.ui.components.EduButton(
                        text = "Registrarme",
                        onClick = {
                            val cleanEmail = registerEmail.trim()
                            when {
                                cleanEmail.isEmpty() || registerPassword.isEmpty() || registerConfirm.isEmpty() ->
                                    error = "⚠️ Completa todos los campos"
                                !android.util.Patterns.EMAIL_ADDRESS.matcher(cleanEmail).matches() ->
                                    error = "⚠️ Formato de correo inválido"
                                registerPassword.length < 6 ->
                                    error = "⚠️ Contraseña demasiado corta"
                                registerPassword != registerConfirm ->
                                    error = "⚠️ Las contraseñas no coinciden"
                                AppState.usuarios.containsKey(cleanEmail) ->
                                    error = "⚠️ Este correo ya está registrado"
                                else -> {
                                    AppState.registrar(cleanEmail, registerPassword)
                                    registerSuccess = true
                                }
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    TextButton(onClick = { isRegisterMode = false; error = "" }) {
                        Text("¿Ya tienes cuenta? Inicia sesión", style = MaterialTheme.typography.labelLarge)
                    }
                }
            }
        }
    }
}
