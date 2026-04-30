package com.edutech.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "EduTech Academy",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Aprende sin límites 🚀", fontSize = 14.sp)
        Spacer(modifier = Modifier.height(32.dp))

        if (!isRegisterMode) {
            // MODO LOGIN
            OutlinedTextField(
                value = email,
                onValueChange = { email = it; error = "" },
                label = { Text("Correo electrónico") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = password,
                onValueChange = { password = it; error = "" },
                label = { Text("Contraseña") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))

            if (error.isNotEmpty()) {
                Text(text = error, color = MaterialTheme.colorScheme.error)
                Spacer(modifier = Modifier.height(8.dp))
            }

            Button(
                onClick = {
                    when {
                        email.isEmpty() || password.isEmpty() ->
                            error = "⚠️ Completa todos los campos"
                        !email.contains("@") ->
                            error = "⚠️ Correo inválido"
                        !AppState.loginValido(email, password) ->
                            error = "❌ Correo o contraseña incorrectos"
                        else -> {
                            AppState.userName.value = email.substringBefore("@")
                            AppState.userEmail.value = email
                            navController.navigate(Routes.HOME)
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Ingresar", fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))
            TextButton(onClick = { isRegisterMode = true; error = "" }) {
                Text("¿No tienes cuenta? Regístrate")
            }

        } else {
            // MODO REGISTRO
            Text(text = "Crear cuenta", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))

            if (registerSuccess) {
                Text(
                    text = "✅ ¡Cuenta creada! Ya puedes iniciar sesión",
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        isRegisterMode = false
                        registerSuccess = false
                        registerEmail = ""
                        registerPassword = ""
                        registerConfirm = ""
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Ir al Login")
                }
            } else {
                OutlinedTextField(
                    value = registerEmail,
                    onValueChange = { registerEmail = it; error = "" },
                    label = { Text("Correo electrónico") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )
                Spacer(modifier = Modifier.height(12.dp))
                OutlinedTextField(
                    value = registerPassword,
                    onValueChange = { registerPassword = it; error = "" },
                    label = { Text("Contraseña") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )
                Spacer(modifier = Modifier.height(12.dp))
                OutlinedTextField(
                    value = registerConfirm,
                    onValueChange = { registerConfirm = it; error = "" },
                    label = { Text("Confirmar contraseña") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))

                if (error.isNotEmpty()) {
                    Text(text = error, color = MaterialTheme.colorScheme.error)
                    Spacer(modifier = Modifier.height(8.dp))
                }

                Button(
                    onClick = {
                        when {
                            registerEmail.isEmpty() || registerPassword.isEmpty() || registerConfirm.isEmpty() ->
                                error = "⚠️ Completa todos los campos"
                            !registerEmail.contains("@") ->
                                error = "⚠️ Correo inválido"
                            registerPassword.length < 6 ->
                                error = "⚠️ La contraseña debe tener al menos 6 caracteres"
                            registerPassword != registerConfirm ->
                                error = "⚠️ Las contraseñas no coinciden"
                            AppState.usuarios.containsKey(registerEmail) ->
                                error = "⚠️ Este correo ya está registrado"
                            else -> {
                                AppState.registrar(registerEmail, registerPassword)
                                registerSuccess = true
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Crear cuenta", fontSize = 16.sp)
                }
                Spacer(modifier = Modifier.height(16.dp))
                TextButton(onClick = { isRegisterMode = false; error = "" }) {
                    Text("¿Ya tienes cuenta? Inicia sesión")
                }
            }
        }
    }
}