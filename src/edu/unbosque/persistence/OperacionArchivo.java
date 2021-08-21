package edu.unbosque.persistence;


import java.io.*;
import java.util.ArrayList;

public class OperacionArchivo {
    private ObjectInputStream recuperar;
    private ObjectOutputStream escribir;
   
    public ArrayList<Persona> obtener() throws ClassNotFoundException{
        try {
            recuperar = new ObjectInputStream(new FileInputStream("./EjemploCSV/Data/Personas.dat"));
            ArrayList<Persona> aux = (ArrayList<Persona>)recuperar.readObject();
            recuperar.close();
            System.out.println(aux);

            return aux;
        } catch (IOException e) {
            return null;

        }

    }

    public void escribir(ArrayList<Persona> aux) {
        try {
            escribir = new ObjectOutputStream(new FileOutputStream("./EjemploCSV/Data/Personas.dat"));
            escribir.writeObject(aux);
            escribir.close();

        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public ArrayList<Persona> leerCsv() throws IOException {
        ArrayList<Persona> personas = new ArrayList<>();
        BufferedReader lectura = null ;
        try {
            lectura = new BufferedReader(new FileReader("./EjemploCSV/Data/datos.csv"));
            String linea = lectura.readLine();
            while(linea!=null){
                String temp[] = linea.split(";");
                personas.add(new Persona(temp[1],temp[2],Integer.parseInt(temp[0]),temp[4]));
                linea = lectura.readLine();
                if (personas ==null) {
                	System.out.println("no esta leyendo");
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            lectura.close();
            return personas;
        }
    }

    public ObjectInputStream getRecuperar() {
        return recuperar;
    }

    public void setRecuperar(ObjectInputStream recuperar) {
        this.recuperar = recuperar;
    }

    public ObjectOutputStream getEscribir() {
        return escribir;
    }

    public void setEscribir(ObjectOutputStream escribir) {
        this.escribir = escribir;
    }
}
