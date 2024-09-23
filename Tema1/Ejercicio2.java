package Tema1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Ejercicio2 {
    public static void main(String[] args) {

        String nombreArchivo = "prueba.txt";


        Main2.main(new String[]{nombreArchivo});

        }
    }
class Main2 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No se proporcionó el nombre del archivo.");
            return;
        }

        String nombreArchivo = args[0];

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo. ");
        }
    }
}

