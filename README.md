# Proyecto UI Design

Este proyecto es una aplicación móvil demostrativa desarrollada con Kotlin, Jetpack Compose, minSdk 24 y targetSdk 34.

## Descripción del Proyecto

La aplicación incluye dos pantallas principales:
- **Pantalla de Login:** Permite a los usuarios ingresar con su correo electrónico y contraseña.
- **Pantalla de Signup:** Permite a los usuarios crear una nueva cuenta ingresando su correo electrónico, teléfono, contraseña y confirmando la contraseña.

### Tecnologías Utilizadas

- **Kotlin:** Lenguaje de programación utilizado para todo el desarrollo del proyecto.
- **Jetpack Compose:** Kit de herramientas de desarrollo UI utilizado para construir la interfaz de usuario.
- **ViewModel y LiveData/StateFlow:** Gestión del estado y comunicación entre UI y lógica de negocio.
- **MVVM (Model-View-ViewModel):** Patrón de arquitectura implementado para mantener el código limpio y modular.
- **Clean Architecture:** Implementada para asegurar una separación clara de responsabilidades y un diseño modular y mantenible.
- **Dagger Hilt:** Utilizado para la inyección de dependencias, principalmente para crear instancias de ViewModel mediante Singletons.
- **Código limpio:** Aplicación de principios de código limpio para asegurar que el código sea fácil de leer, mantener y extender.

### Recomendaciones
- **Navegación entre TextFields con Enter:** Implementé la navegación automática entre campos de entrada usando Enter y oculto el teclado cuando no hay más campos. Esto facilita la navegación en formularios extensos.
- **Ocultar teclado al perder el foco** Se añadió la funcionalidad para ocultar el teclado al tocar fuera de un `TextField`. Cuando un `TextField` pierde el enfoque, el teclado se oculta automáticamente, mejorando la experiencia del usuario.
- **Scrollable en Column:** Agregué soporte para desplazamiento vertical en `Column` para asegurar que todo el contenido sea accesible en pantallas de diferentes tamaños.
- **Reutilización de TextFields Personalizados:** Creé componentes de `TextField` personalizados para mantener la consistencia en el diseño y facilitar el mantenimiento.
- **Reutilización de código:** Implementación de un objeto que almacena los Strings constantes.

## PANTALLAS OBTENIDAS
| **Pantalla de LogIn** | **Pantalla de SignUp** |
|:--:|:--:|
| ![LogIn](https://github.com/user-attachments/assets/fcec59e3-956b-42b0-85e0-ab584a341186) | ![SignUp](https://github.com/user-attachments/assets/18016980-b78e-44b2-b22c-3fbdfd71f694) |

## VIDEO DE DEMOSTRACIÓN

https://github.com/user-attachments/assets/5cdec551-459a-468f-bdf7-eb769a3b96d1

