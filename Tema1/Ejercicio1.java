package Tema1;

import java.io.File;

public class Ejercicio1 {
    public static void main(String[] args) {
        String dir = ".";
        File f = new File(dir);
        File[] archivos = f.listFiles();

        if (archivos != null) {
            for (File archivo : archivos) {
                System.out.println("Nombre: " + archivo.getName());
            }
        } else {
            System.out.println("No se pudo acceder al directorio o está vacío.");
        }
    }
}
