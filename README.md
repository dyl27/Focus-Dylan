# Pomodoro Timer App

## Descripción de la práctica

Esta práctica consiste en el desarrollo de una aplicación móvil en Android que implementa la técnica Pomodoro para mejorar la productividad del usuario.

La aplicación permite gestionar ciclos de trabajo (Focus), descansos cortos (Break) y descansos largos (Rest), automatizando el flujo de sesiones y proporcionando retroalimentación visual y sensorial.

Entre sus principales funcionalidades se encuentran:

* Temporizador basado en CountDownTimer
* Cambio automático entre modos (Focus, Break, Rest)
* Indicador dinámico de sesiones completadas
* Botones de control (Start, Reset, Skip)
* Vibración y mensajes al finalizar cada sesión

---

## Preguntas

### 1. ¿Cuál fue el mayor reto al gestionar el CountDownTimer y cómo evitaste que se crearan múltiples instancias al presionar el botón repetidamente?

El mayor reto fue evitar que se crearan múltiples instancias del CountDownTimer al presionar repetidamente el botón de inicio, lo cual podía provocar comportamientos incorrectos como múltiples conteos simultáneos.

Para solucionar esto, se implementó una validación previa que cancela cualquier temporizador existente antes de iniciar uno nuevo:

```java
if(timer != null){
    timer.cancel();
}
```

De esta manera, se garantiza que solo exista una instancia activa del temporizador en todo momento.

---

### 2. ¿Por qué es preferible usar un LinearLayout con addView para los puntos de progreso en lugar de declarar 4 ImageViews estáticos en el XML?

El uso de un LinearLayout junto con el método addView permite generar dinámicamente los indicadores de progreso (puntos de sesión), lo cual aporta mayor flexibilidad al diseño.

Las principales ventajas son:

* Permite adaptar el número de sesiones sin modificar el XML
* Hace el código más escalable y reutilizable
* Reduce la duplicación de componentes en la interfaz
* Facilita cambios futuros en la lógica de sesiones

En contraste, utilizar ImageViews estáticos limita la interfaz a un número fijo de elementos, haciendo más difícil su mantenimiento y extensión.

---

### 3. Si quisiéramos añadir una función para que el usuario personalice sus propios tiempos de enfoque, ¿qué parte de tu lógica actual tendría que cambiar y cómo lo abordarías?

Actualmente, los tiempos de enfoque, descanso corto y descanso largo están definidos como valores fijos dentro del código:

```java
private long focusTime;
private long breakTime;
private long restTime;
```

Para permitir la personalización, sería necesario:

1. Crear una interfaz de usuario donde el usuario pueda ingresar sus tiempos.
2. Almacenar esos valores usando SharedPreferences.
3. Recuperar esos valores al iniciar la aplicación.

Por ejemplo:

```java
SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
focusTime = prefs.getLong("focusTime", 25 * 60 * 1000);
```

De esta forma, el temporizador se adaptaría dinámicamente a las preferencias del usuario.

---

### 4. ¿Cómo harían para que el tiempo del temporizador se mantenga si el usuario minimiza la app?

Para mantener el estado del temporizador cuando la aplicación se minimiza, se pueden implementar varias estrategias:

* Guardar el tiempo restante utilizando onSaveInstanceState
* Utilizar un ViewModel para preservar el estado durante cambios de configuración
* Implementar un Foreground Service para mantener el temporizador activo en segundo plano

La opción más robusta es el uso de un Foreground Service, ya que permite que el temporizador continúe ejecutándose incluso cuando la aplicación no está en primer plano.

---

## Autor
Dylan Enrique Juarez Martinez

Dylan Enrique Juárez Martínez
