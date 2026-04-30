# 📂 Etapa 1: Diseño y Desarrollo Propio

[cite_start]Este documento detalla la construcción inicial de la aplicación "EduTech Academy" utilizando **Kotlin** y **Jetpack Compose**[cite: 3, 15].

---

## 🛠️ Requisitos Técnicos Cubiertos
De acuerdo a lo solicitado en la evaluación, la app incluye:
* [cite_start]**Navegación Robusta:** Implementación de `NavHost` y `NavController` para gestionar el flujo entre pantallas[cite: 17, 54, 55].
* [cite_start]**Paso de Argumentos:** Navegación hacia el detalle de cursos utilizando el **ID del curso** como parámetro[cite: 42, 57].
* [cite_start]**UI Moderna:** Diseño basado en **Material 3** con una paleta de colores personalizada[cite: 60, 61].
* [cite_start]**Control de Navegación:** Inclusión del botón de retroceso (←) en todas las pantallas secundarias[cite: 58].

---

## 📱 Pantallas Obligatorias Implementadas
1. [cite_start]**Login / Registro:** Validación básica de campos de correo y contraseña[cite: 19, 21].
2. [cite_start]**Home (Dashboard):** Saludo personalizado y acceso directo a las secciones principales[cite: 24, 25, 26].
3. [cite_start]**Cursos:** Lista con scroll de cursos filtrables por categorías (Programación, Diseño, Negocios)[cite: 30, 31, 37].
4. [cite_start]**Detalle del Curso:** Muestra imagen extendida, descripción, duración y botón de inscripción[cite: 41, 44, 45, 47].
5. [cite_start]**Perfil / Mis Cursos:** Información del usuario autenticado y visualización de progreso simulado (%)[cite: 48, 51].

---

## 📊 Datos Precargados
[cite_start]La aplicación cuenta con un mínimo de **6 cursos precargados** en el sistema, cada uno con instructor, nivel y descripción técnica completa[cite: 59, 32].