import java.util.Scanner;

public class Main {
    private static Scanner entrada = new Scanner(System.in);
    private static Playlist playlist = new Playlist();
    
    private static String leerTexto(String mensaje) {
    while (true) {
        System.out.print(mensaje);
        String texto = entrada.nextLine().trim();

        if (!texto.isEmpty()) {
        return texto;
        }

        System.out.println("El texto no puede estar vacío.");
        }
    }

    private static int leerEntero(String mensaje) {
        while (true) {
        System.out.print(mensaje);

        try {
        return Integer.parseInt(entrada.nextLine().trim());
        } catch (NumberFormatException e) {
        System.out.println("Escribe un número entero válido.");
        }
        }
    }

    private static long leerId() {
        while (true) {
        System.out.print("ID de la canción: ");

        try {
        return Long.parseLong(entrada.nextLine().trim());
        } catch (NumberFormatException e) {
        System.out.println("Escribe un ID válido.");
        }
        }
    }

    private static void mostrarCancion(Song song) {
        if (song == null) {
        System.out.println("La lista está vacía o no se encontró la canción.");
        } else {
        System.out.println(song);
        }
    
    }
    private static void menu() {
        System.out.println("1. Agregar cancion al inicio");
        System.out.println("2. Agregar cancion al final");
        System.out.println("3. Mostrar cancion actual");
        System.out.println("4. Siguiente cancion");
        System.out.println("5. Anterior cancion");
        System.out.println("6. Mostrar todas las canciones");
        System.out.println("7. Eliminar id");
        System.out.println("8. Eliminar actual");
        System.out.println("9. Buscar id");
        System.out.println("10. Reproducir k canciones");
        System.out.println("11. Cantidad de canciones");
        System.out.println("12. Salir");
    }

    private static void agregarCancion(boolean alInicio) {
        String titulo = leerTexto("Título: ");
        String artista = leerTexto("Artista: ");
        int duracion = leerEntero("Duración en segundos: ");

        if (duracion <= 0) {
            System.out.println("La duración debe ser mayor que cero.");
            return;
        }

        Song song;
        if (alInicio) {
            song = playlist.addcabeza(titulo, artista, duracion);
        } else {
            song = playlist.addcola(titulo, artista, duracion);
        }

        System.out.println("Canción agregada: " + song);
    }

    public static void main(String[] args) {
        boolean ejecutando = true;

        while (ejecutando) {
            menu();
            int opcion = leerEntero("Elige una opción: ");

            switch (opcion) {
                case 1:
                    agregarCancion(true);
                    break;

                case 2:
                    agregarCancion(false);
                    break;

                case 3:
                    mostrarCancion(playlist.currentSong());
                    break;

                case 4:
                    mostrarCancion(playlist.nextSong());
                    break;

                case 5:
                    mostrarCancion(playlist.prevSong());
                    break;

                case 6:
                    if (playlist.isEmpty()) {
                        System.out.println("La lista está vacía.");
                    } else {
                        System.out.println("Canciones de inicio a fin:");
                        playlist.forEachForward(System.out::println);

                        System.out.println("Canciones de fin a inicio:");
                        playlist.forEachBackward(System.out::println);
                    }
                    break;

                case 7: {
                    long id = leerId();
                    if (playlist.remove(id)) {
                        System.out.println("Canción eliminada.");
                    } else {
                        System.out.println("No existe una canción con ese ID.");
                    }
                    break;
                }

                case 8:
                    if (playlist.removeCurrent()) {
                        System.out.println("Se eliminó la canción actual.");
                    } else {
                        System.out.println("La lista está vacía.");
                    }
                    break;

                case 9: {
                    long id = leerId();
                    mostrarCancion(playlist.find(id));
                    break;
                }

                case 10: {
                    int cantidad = leerEntero("¿Cuántas canciones quieres reproducir?: ");

                    if (cantidad <= 0) {
                        System.out.println("La cantidad debe ser mayor que cero.");
                    } else if (playlist.isEmpty()) {
                        System.out.println("La lista está vacía.");
                    } else {
                        playlist.play(cantidad,
                                song -> System.out.println("Reproduciendo: " + song));

                        System.out.println("La siguiente canción será:");
                        mostrarCancion(playlist.currentSong());
                    }
                    break;
                }

                case 11:
                    System.out.println("Cantidad de canciones: " + playlist.size());
                    break;

                case 12:
                    ejecutando = false;
                    System.out.println("Hasta luego.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }

        entrada.close();
    }
}