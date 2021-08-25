package edu.unbosque.model;

import edu.unbosque.AnimalesDto;

import java.io.*;
import java.util.ArrayList;

public class OperacionArchivo {

    public static void main(String[] args) throws IOException {

        OperacionArchivo op = new OperacionArchivo();

        System.out.println(op.leerCsv());

    }

    private ObjectInputStream recuperar;
    private ObjectOutputStream escribir;


    //public void escribir(ArrayList<AnimalesDto> aux) {
    //  try {
    //    escribir = new ObjectOutputStream(new FileOutputStream("./EjemploCSV/Data/Personas.dat"));
    //  escribir.writeObject(aux);
    //escribir.close();

    //} catch (Exception e) {
//}  System.out.println("error");
    //    }
    //  }
    public ArrayList<AnimalesDto> leerCsv() throws IOException {
        ArrayList<AnimalesDto> animales = new ArrayList<>();
        BufferedReader lectura = null;
        try {
            lectura = new BufferedReader(new FileReader("./Data/pets-citizens.csv"));
            String linea = lectura.readLine();
            while (linea != null) {
                String temp[] = linea.split(";");
                animales.add(new AnimalesDto("d", temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]));
                linea = lectura.readLine();
            }
            lectura.close();
        } catch (

                IOException e) {
            e.printStackTrace();
            return null;
        }
        return animales;
    }

}

