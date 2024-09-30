package Tema1Parte2;

import java.io.*;

class Becario implements Serializable {
    private String nombre;
    private char sexo;
    private int edad;
    private int Suspensos;
    private boolean residenciaFamiliar;
    private double ingresosAnuales;


    public Becario(String nombre, char sexo, int edad, int Suspensos, boolean residenciaFamiliar, double ingresosAnuales) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.Suspensos = Suspensos;
        this.residenciaFamiliar = residenciaFamiliar;
        this.ingresosAnuales = ingresosAnuales;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" +
                "Sexo: " + sexo + "\n" +
                "Edad: " + edad + "\n" +
                "suspensos: " + Suspensos + "\n" +
                "Residencia familiar: " + (residenciaFamiliar ? "Sí" : "No") + "\n" +
                "Ingresos anuales: " + ingresosAnuales + "€";
    }
}