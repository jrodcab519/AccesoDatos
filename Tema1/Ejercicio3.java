package Tema1;

import java.io.*;
import java.util.Scanner;

public class Ejercicio3 {
    private static final String NOMBRE_ARCHIVO = "Datospersonales.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1. Crear un fichero de texto");
            System.out.println("2. Mostrar el contenido del fichero de texto");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearFichero(scanner);
                    break;
                case 2:
                    mostrarFichero();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);

        scanner.close();
    }

    private static void crearFichero(Scanner scanner) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO))) {
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Apellidos: ");
            String apellidos = scanner.nextLine();
            System.out.print("Ciudad de nacimiento: ");
            String ciudad = scanner.nextLine();

            writer.write("Nombre: " + nombre);
            writer.newLine();
            writer.write("Apellidos: " + apellidos);
            writer.newLine();
            writer.write("Ciudad de Nacimiento: " + ciudad);
            writer.newLine();

        } catch (IOException e) {
            System.out.println("Error al crear el fichero." );
        }
    }

    private static void mostrarFichero() {
        try (BufferedReader reader = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            String linea;
            System.out.println("Contenido del fichero:");
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
    }
}

