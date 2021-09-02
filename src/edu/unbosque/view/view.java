package edu.unbosque.view;

import java.util.Scanner;

public class view {
    public Scanner leer;
    public view(){

        leer = new Scanner(System.in);

    }

    public void mostrarInfo(String mensaje){

        System.out.println(mensaje);

    }

    public String leerDato(String mensaje){

        mostrarInfo(mensaje);
        String dato = "";
        dato = leer.nextLine();
        return dato;

    }
}
