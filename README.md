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
2. **Pantalla de Cursos**
3. **Pantalla de Detalle del Curso**

---

### Mejora 1 — [Nombre de la mejora]

**Prompt usado en Gemini:**
```
[Pega aquí el prompt que usaste]
```

**Antes:**
> 📸 *[Agregar captura antes]*

**Después:**
> 📸 *[Agregar captura después]*

**Reflexión:**
[2-3 líneas sobre qué mejoró y por qué fue positivo para la experiencia del usuario]

---

### Mejora 2 — [Nombre de la mejora]

**Prompt usado en Gemini:**
```
[Pega aquí el prompt que usaste]
```

**Antes:**
> 📸 *[Agregar captura antes]*

**Después:**
> 📸 *[Agregar captura después]*

**Reflexión:**
[2-3 líneas sobre qué mejoró y por qué fue positivo para la experiencia del usuario]

---

### Mejora 3 — [Nombre de la mejora]

**Prompt usado en Gemini:**
```
[Pega aquí el prompt que usaste]
```

**Antes:**
> 📸 *[Agregar captura antes]*

**Después:**
> 📸 *[Agregar captura después]*

**Reflexión:**
[2-3 líneas sobre qué mejoró y por qué fue positivo para la experiencia del usuario]

---

## 📝 Conclusión general

[Párrafo breve sobre la experiencia de usar Gemini como herramienta de apoyo en el diseño de la app]

---

*Trabajo Grupal — Examen 02 | Sección B | Docente: Juan José León Suiyon*