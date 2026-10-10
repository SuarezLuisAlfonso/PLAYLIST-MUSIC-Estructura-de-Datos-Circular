# PLAYLIST-MUSIC-Estructura-de-Datos-Circular
Un trabajo de la materia Estructura de Datos. 
Hecha por:
Banda Benítez Angel Alain
García Suárez Luis Alfonso
Gayosso Silva Gustavo
Palomino González Ivan

Versión:
- Java 17 o posterior (JDK).
  
Archivos del proyecto:
- Main.java: menú y comunicación con el usuario.
- Playlist.java: lista doblemente enlazada circular y sus operaciones.
- Song.java: datos y validación de cada canción.
- SongNode.java: nodo con referencias al nodo anterior y al siguiente.



Compilar en Windows:

Abre CMD en la carpeta que contiene los cuatro archivos .java. Comprueba la ubicación actual con cd. Si necesitas cambiar a la carpeta del proyecto hazlo.
La carpeta output debe existir. Para compilar y colocar los archivos .class si es que no estan dentro de ella.
Desde la misma carpeta del proyecto, ejecuta:
java -cp output Main

Compilar y ejecutar en Visual Studio Code:

Abre Visual Studio Code y selecciona la carpeta que contiene Main.java, Playlist.java, Song.java y SongNode.java. Abre la carpeta completa, no solamente Main.java.
En la terminal integrada de VS Code, confirma que estás en la carpeta del proyecto. Si la carpeta output aún no existe, créala.
Compila desde la terminal integrada, usando las rutas dentro de src
Si no aparecen errores, los archivos .class se guardaron dentro de output.
Ejecuta el programa desde la misma terminal:
