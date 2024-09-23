package Tema1;

import java.io.*;
import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("1. Volcar los 100 primeros números pares a un fichero de texto");
                System.out.println("2. Mostrar por pantalla el contenido del fichero de texto");
                System.out.println("3. Salir");
                System.out.print("Elige una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("nombre del fichero (ejemplo: numerosPares.txt): ");
                        String nombreFichero = scanner.nextLine();
                        volcarNumerosPares(nombreFichero);
                        break;
                    case 2:
                        System.out.print("nombre del fichero para mostrar: ");
                        String nombreFicheroMostrar = scanner.nextLine();
                        mostrarContenidoFichero(nombreFicheroMostrar);
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } while (opcion != 3);

            scanner.close();
        }

        private static void volcarNumerosPares(String nombreFichero) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreFichero))) {
                for (int i = 0; i < 100; i++) {
                    writer.write(String.valueOf(i * 2));
                    writer.newLine();
                }
            } catch (IOException e) {
                System.out.println("Error al escribir el fichero." );
            }
        }

        private static void mostrarContenidoFichero(String nombreFichero) {
            try (BufferedReader reader = new BufferedReader(new FileReader(nombreFichero))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    System.out.println(linea);
                }
            } catch (IOException e) {
                System.out.println("Error al leer el fichero. ");
            }
        }
}
