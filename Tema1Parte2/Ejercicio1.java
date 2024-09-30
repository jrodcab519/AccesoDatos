package Tema1Parte2;

import java.io.*;
import java.util.Scanner;

public class Ejercicio1 {
    private static final String NOMBREARCHIVO = "persona.dat";

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("1. Crear fichero");
                System.out.println("2. Mostrar contenido");
                System.out.println("3. Salir");
                System.out.print("Elige opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch(opcion) {
                    case 1:
                        crearFichero(scanner);
                        break;
                    case 2:
                        mostrarFichero();
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Opción inválida");
                        break;
                }

            } while(opcion != 3);

            scanner.close();
        }

    private static void mostrarFichero() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(NOMBREARCHIVO))) {
            String nombre = dis.readUTF();
            int edad = dis.readInt();
            String ciudad = dis.readUTF();

            System.out.println("Nombre: " + nombre);
            System.out.println("Edad: " + edad);
            System.out.println("Ciudad de nacimiento: " + ciudad);
        } catch (FileNotFoundException e) {
            System.err.println("El fichero no existe");
        } catch (IOException e) {
            System.err.println("Error al leer el fichero" );
        }
    }
        private static void crearFichero(Scanner scanner) {
            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(NOMBREARCHIVO))) {
                System.out.print("Introduce nombre: ");
                String nombre = scanner.nextLine();

                System.out.print("Introduce edad: ");
                int edad = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Introduce ciudad de nacimiento: ");
                String ciudad = scanner.nextLine();

                dos.writeUTF(nombre);
                dos.writeInt(edad);
                dos.writeUTF(ciudad);

            } catch (IOException e) {
                System.err.println("Error. ");
            }
        }
    }


