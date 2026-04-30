# 📂 Etapa 1: Diseño y Desarrollo Propio

Este documento certifica el cumplimiento de los requerimientos técnicos base establecidos por la gerencia de **EduTech Academy**.

## ⚙️ Checklist de Requisitos Técnicos
- [x] **NavHost & NavController:** Orquestación centralizada de rutas.
- [x] **Paso de Parámetros:** Transferencia de IDs de cursos entre pantallas.
- [x] **Material 3:** Implementación de componentes `Scaffold`, `Cards` y `TopAppBars`.
- [x] **Navigation Control:** Botón de retroceso (Back arrow) en el 100% de pantallas secundarias.
- [x] **Data Loading:** Mínimo de 6 cursos precargados con metadata completa.

## 🗂️ Arquitectura de Pantallas
| Módulo | Funcionalidad | Requerimiento Cubierto |
| :--- | :--- | :--- |
| **Auth** | Login / Registro | Validación de campos y acceso al flujo. |
| **Dashboard** | Home Screen | Saludo personalizado y navegación rápida. |
| **Catalog** | Lista de Cursos | Filtros por Programación 💻, Diseño 🎨 y Negocios 📈. |
| **Course Detail** | Información Profunda | Recibe ID como parámetro y muestra descripción/duración. |
| **User Profile** | Mis Cursos | Lista de inscripciones y barra de progreso (%) funcional. |

## 🎨 Design System
Se desarrolló una paleta de colores personalizada integrada en el `Theme.kt`, aprovechando las capacidades de **Dynamic Color** y jerarquías tipográficas de Material Design 3.