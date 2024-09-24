package Tema1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio6 {
        public static void main(String[] args) {
            String nombreArchivo = "numeros.txt";
            int suma = 0;

            try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    try {
                        int numero = Integer.parseInt(linea);
                        suma += numero;
                    } catch (NumberFormatException e) {
                        System.out.println("Formato incorrecto: " + linea);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error. " + e.getMessage());
            }

            System.out.println("La suma es: " + suma);
        }
    }


