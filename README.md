1 Descripción breve de la práctica

Ejemplo:

En esta práctica se configuró el entorno de desarrollo utilizando Android Studio y el SDK de Android.
También se trabajó con Git para gestionar el control de versiones mediante ramas, merges y etiquetas.
Finalmente se implementó una clase TaskManager en Java que gestiona una lista de tareas sugeridas utilizando operaciones CRUD.

2 Problemas con aceleración o AVD

Ejemplo:

Durante la configuración del emulador se presentó un posible problema de rendimiento relacionado con la aceleración por hardware.
La solución fue verificar que la virtualización estuviera habilitada en la BIOS y que Android Studio utilizara correctamente el Android Emulator.

3 ¿Por qué elegiste ArrayList?

Ejemplo:

Se eligió ArrayList porque permite manejar listas dinámicas cuyo tamaño puede cambiar durante la ejecución.
Además ofrece acceso rápido por índice y operaciones simples para agregar, actualizar y eliminar elementos, lo cual es adecuado para gestionar una lista de tareas.

4 ¿Qué cambiaría si las tareas estuvieran en un servidor?

Ejemplo:

Si las tareas se almacenaran en un servidor remoto sería necesario manejar excepciones relacionadas con la comunicación en red, como errores de conexión, timeouts o respuestas inválidas del servidor.
También sería necesario implementar bloques try-catch más robustos y posiblemente mecanismos de reintento para garantizar la consistencia de los datos.
