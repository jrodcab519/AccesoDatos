package Tema1Parte2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio3 {

    private static final String NOMBREARCHIVO = "persona.dat";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1) Añadir persona");
            System.out.println("2) Editar persona ");
            System.out.println("3) Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            switch(opcion) {
                case 1:
                    anadirPersona(scanner);
                    break;
                case 2:
                    editarPersona(scanner);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }

        } while(opcion != 3);

        scanner.close();
    }


    private static List<Persona> leerPersonas() {
        List<Persona> personas = new ArrayList<>();
        File file = new File(NOMBREARCHIVO);
        if (!file.exists()) {
            return personas;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(NOMBREARCHIVO))) {
            personas = (List<Persona>) ois.readObject();
        } catch (EOFException e) {
            System.out.println("El archivo está vacío. ");
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe. ");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return personas;
    }


    private static void guardarPersonas(List<Persona> personas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOMBREARCHIVO))) {
            oos.writeObject(personas);
            System.out.println("Datos guardados correctamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar los datos. " );
        }
    }


    private static void anadirPersona(Scanner scanner) {
        List<Persona> personas = leerPersonas();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        scanner.nextLine();

        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ciudad : ");
        String ciudad = scanner.nextLine();

        Persona nuevaPersona = new Persona(nombre, edad, ciudad);
        personas.add(nuevaPersona);

        guardarPersonas(personas);
    }


    private static void editarPersona(Scanner scanner) {
        List<Persona> personas = leerPersonas();

        if (personas.isEmpty()) {
            System.out.println("Archivo vacío.");
            return;
        }

        for (int i = 0; i < personas.size(); i++) {
            System.out.println((i + 1) + ") " + personas.get(i));
        }

        System.out.print("Número de la persona a editar: ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine();

        if (indice < 0 || indice >= personas.size()) {
            System.out.println("Índice inválido.");
            return;
        }

        Persona persona = personas.get(indice);

        System.out.print("Introduce nuevo nombre : ");
        String nuevoNombre = scanner.nextLine();
        if (!nuevoNombre.isEmpty()) {
            persona.setNombre(nuevoNombre);
        }

        System.out.print("Introduce nueva edad : ");
        int nuevaEdad = scanner.nextInt();
        scanner.nextLine();
        persona.setEdad(nuevaEdad);

        System.out.print("Introduce nueva ciudad  + ");
        String nuevaCiudad = scanner.nextLine();
        if (!nuevaCiudad.isEmpty()) {
            persona.setCiudad(nuevaCiudad);
        }

        guardarPersonas(personas);
    }
}