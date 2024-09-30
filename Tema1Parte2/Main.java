package Tema1Parte2;

import java.io.*;
import java.util.Scanner;

public class Main {
    private static final String NOMBREARCHIVO = "datosbeca.bin";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("nombre y apellido : ");
        String nombre = scanner.nextLine();

        char sexo;
        do {
            System.out.print("sexo (H/M): ");
            sexo = scanner.next().toUpperCase().charAt(0);
        } while (sexo != 'H' && sexo != 'M');

        int edad;
        do {
            System.out.print("edad: (20 a 60): ");
            edad = scanner.nextInt();
        } while (edad < 20 || edad > 60);

        int suspensos;
        do {
            System.out.print("número de suspensos: (0 a 4): ");
            suspensos = scanner.nextInt();
        } while (suspensos < 0 || suspensos > 4);

        boolean residenciaFamiliar;
        System.out.print("¿Tiene residencia familiar? (Sí/No): ");
        String residenciaRespuesta = scanner.next().toLowerCase();
        residenciaFamiliar = residenciaRespuesta.equals("sí") || residenciaRespuesta.equals("si");

        System.out.print("Ingresos anuales de la familia: ");
        double ingresosAnuales = scanner.nextDouble();


        Becario becario = new Becario(nombre, sexo, edad, suspensos, residenciaFamiliar, ingresosAnuales);

        guardarBecario(becario);

        mostrarBecario();

        scanner.close();
    }


    private static void guardarBecario(Becario becario) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOMBREARCHIVO))) {
            oos.writeObject(becario);
        } catch (IOException e) {
            System.err.println("Error. ");
        }
    }


    private static void mostrarBecario() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(NOMBREARCHIVO))) {
            Becario becario = (Becario) ois.readObject();
            System.out.println(becario);
        } catch (FileNotFoundException e) {
            System.err.println("El archivo no existe. ");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error. ");
        }
    }
}