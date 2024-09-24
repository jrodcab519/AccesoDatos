package Tema1;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Nombre del fichero : ");
        String nombreFichero = scanner.nextLine();

        System.out.print("Texto : ");
        String texto = scanner.nextLine();

        try (FileWriter fileWriter = new FileWriter(nombreFichero)) {
            fileWriter.write(texto);
        } catch (IOException e) {
            System.out.println("Error.");
        }

        StringBuilder contenido = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                contenido.append(linea);
            }
        } catch (IOException e) {
            System.out.println("Error.");
        }

        String cambioTexto = cambiar(contenido.toString());

        System.out.println("Texto con mayúsculas y minúsculas cambiadas:");
        System.out.println(cambioTexto);
    }

    public static String cambiar(String texto) {
        StringBuilder resultado = new StringBuilder();
        boolean cambiarAMayusculas = false;

        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            if (Character.isLetter(caracter)) {
                if (cambiarAMayusculas) {
                    resultado.append(Character.toUpperCase(caracter));
                } else {
                    resultado.append(Character.toLowerCase(caracter));
                }
                cambiarAMayusculas = !cambiarAMayusculas;
            } else {
                resultado.append(caracter);
            }
        }

        return resultado.toString();
    }
}
