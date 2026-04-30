# 📱 EduTech Academy — App Móvil de Cursos Online

Aplicación móvil desarrollada con **Kotlin + Jetpack Compose** como parte del curso de Desarrollo Móvil en TECSUP.

## 👥 Integrantes

- Angie Portocarrero Parra
- Carlos Garcia Garcia

---

## 📋 Descripción

EduTech Academy es un prototipo navegable de una plataforma de educación online donde los usuarios pueden explorar cursos de tecnología, negocios y diseño, inscribirse en ellos y gestionar su perfil.

---

## 🗂️ Pantallas

| Pantalla | Descripción |
|----------|-------------|
| **Login** | Autenticación con correo y contraseña, validación básica |
| **Home** | Dashboard con accesos rápidos a Cursos, Mis Cursos y Perfil |
| **Cursos** | Lista scrollable con filtros por categoría |
| **Detalle del Curso** | Información completa del curso, recibe ID como parámetro |
| **Perfil / Mis Cursos** | Información del usuario, cursos inscritos y progreso simulado |

---

## ⚙️ Tecnologías utilizadas

- Kotlin
- Jetpack Compose
- Material 3
- Navigation Compose (`androidx.navigation:navigation-compose:2.9.0`)
- NavHost + NavController

---

## 🗃️ Estructura del proyecto

```
com.edutech.app
├── components/
│   └── CourseCard.kt
├── data/
│   ├── Course.kt
│   └── FakeData.kt
├── navigation/
│   └── NavGraph.kt
└── ui/screens/
    ├── LoginScreen.kt
    ├── HomeScreen.kt
    ├── CoursesScreen.kt
    ├── DetailScreen.kt
    └── ProfileScreen.kt
```

---

## 🚀 Cómo ejecutar el proyecto

1. Clona el repositorio:
   ```bash
   git clone https://github.com/DevG28/edutech-app.git
   ```
2. Abre el proyecto en **Android Studio**
3. Espera que Gradle sincronice las dependencias
4. Ejecuta en un emulador o dispositivo físico con Android 8.0+ (API 26)

---

## 📦 Dependencias principales

```kotlin
implementation("androidx.navigation:navigation-compose:2.9.0")
implementation(platform(libs.androidx.compose.bom))
implementation(libs.androidx.compose.material3)
```

---

## 📌 Requisitos técnicos cubiertos

- [x] NavHost y NavController configurados
- [x] Navegación con paso de argumentos (ID del curso)
- [x] Botón flecha atrás en pantallas secundarias
- [x] Mínimo 6 cursos precargados
- [x] Diseño con Material 3
- [x] Paleta de colores personalizada
- [x] App ejecuta sin errores

---

## ✨ Mejoras con Gemini — Etapa 2

Registro de mejoras realizadas con **Gemini in Android Studio**.

### 🔍 Pantallas auditadas

1. **Pantalla de Login**
2. **Pantalla de Registro**
3. **Pantalla de Perfil / Mis Cursos**

---

### Mejora 1 — Validación de correo en Login

Se implementó validación de formato de correo electrónico en la pantalla de Login. Anteriormente era posible ingresar cualquier texto y acceder a la app sin restricciones.

**Prompt usado en Gemini:**
```
Tengo una pantalla de Login en Jetpack Compose. Actualmente el usuario puede ingresar 
cualquier texto en el campo de correo y contraseña y acceder sin validación. 
¿Cómo puedo agregar validación para que el correo tenga formato válido con @ 
antes de permitir el inicio de sesión?
```

**Antes:**

> 📸 *[Captura no disponible — se aceptaba cualquier texto sin validación]*

**Después:**

> 📸 *[Agregar captura de la pantalla de Login con validación activa]*

**Reflexión:**
Antes de esta mejora, cualquier usuario podía ingresar a la app sin tener un correo válido, lo que representaba una falla de seguridad básica. Con la validación del símbolo `@`, se garantiza que el formato del correo sea correcto antes de permitir el acceso, mejorando tanto la seguridad como la experiencia del usuario al recibir un mensaje de error claro.

---

### Mejora 2 — Persistencia del usuario registrado en Perfil

Se corrigió el flujo de registro para que el usuario recién creado se refleje correctamente en la pantalla de Perfil. Antes, el perfil siempre mostraba datos predeterminados sin importar con qué cuenta se había iniciado sesión.

**Prompt usado en Gemini:**
```
En mi app de Android con Jetpack Compose, cuando un usuario se registra e inicia sesión, 
la pantalla de Perfil sigue mostrando datos estáticos predeterminados en lugar de los 
datos del usuario registrado. ¿Cómo puedo pasar y mostrar correctamente la información 
del usuario registrado en la pantalla de Perfil?
```

**Antes:**

> 📸 *[Captura no disponible — el perfil mostraba siempre datos predeterminados]*

**Después:**

> 📸 *[Agregar captura del perfil mostrando los datos del usuario registrado]*

**Reflexión:**
El problema causaba una experiencia inconsistente, ya que el usuario veía información que no le pertenecía. Al vincular correctamente los datos del registro con la pantalla de Perfil, la app ahora refleja la identidad real del usuario autenticado, haciendo la experiencia más personalizada y confiable.

---

### Mejora 3 — Sincronización de cursos inscritos por usuario

Se implementó la actualización dinámica del estado de inscripción de los cursos. Anteriormente, los cursos marcados como inscritos en el perfil no se reflejaban en la lista general de cursos, mostrando todos como disponibles aunque el usuario ya estuviera inscrito.

**Prompt usado en Gemini:**
```
En mi app de cursos con Jetpack Compose, el perfil del usuario muestra una lista de 
cursos inscritos, pero al ver la pantalla de todos los cursos, los cursos en los que 
ya está inscrito aparecen como si no lo estuviera. ¿Cómo sincronizo el estado de 
inscripción entre la pantalla de Cursos y el Perfil del usuario?
```

**Antes:**

> 📸 *[Captura no disponible — los cursos inscritos no se reflejaban en la lista general]*

**Después:**

> 📸 *[Agregar captura mostrando los cursos inscritos correctamente marcados]*

**Reflexión:**
La falta de sincronización generaba confusión, ya que el usuario no podía distinguir visualmente qué cursos ya tenía y cuáles no. Al implementar un estado compartido, la app ahora muestra correctamente qué cursos están inscritos desde cualquier pantalla, brindando una experiencia coherente y evitando inscripciones duplicadas.

---

## 📝 Conclusión general

El uso de Gemini como herramienta de apoyo durante la Etapa 2 permitió identificar y resolver problemas de lógica y flujo de datos que no eran evidentes durante el desarrollo inicial. Gracias a las sugerencias de Gemini, logramos mejorar la validación de datos, la persistencia del usuario y la sincronización del estado de la app, obteniendo un producto más robusto y con una mejor experiencia de usuario.

---