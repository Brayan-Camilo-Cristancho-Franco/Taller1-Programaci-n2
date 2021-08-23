package P;

import edu.unbosque.model.AnimalesDto;

import java.io.*;
import java.util.ArrayList;

public class OperacionArchivo {

    public static void main(String[] args) throws IOException {




 OperacionArchivo op = new OperacionArchivo();

        System.out.println(op.leerCsv());

    }

    private ObjectInputStream recuperar;
    private ObjectOutputStream escribir;


//    public void escribir(ArrayList<AnimalesDto> aux) {
//      try {
//        escribir = new ObjectOutputStream(new FileOutputStream("./EjemploCSV/Data/Personas.dat"));
//      escribir.writeObject(aux);
//    escribir.close();
//
//    } catch (Exception e) {
//}  System.out.println("error");
//        }

    public ArrayList<AnimalesDto> leerCsv() throws IOException {
        ArrayList<AnimalesDto> animales = new ArrayList<>();
        BufferedReader lectura = null;
        try {
            lectura = new BufferedReader(new FileReader("./Taller1-Programacion2/Data/pets-citizens.csv"));
            String linea = lectura.readLine();
            long aux=0;
            while (linea != null) {
                aux++;
                System.out.println(linea+"entro"+aux);

                String temp[] = linea.split(";");
                animales.add(new AnimalesDto(Long.parseLong(temp[0]), temp[1], temp[2], temp[3], Boolean.parseBoolean(temp[4]), temp[5]));
                linea = lectura.readLine();
            }
            lectura.close();
        } catch ( IOException e) {
            System.out.println(" se va por el catch");
            e.printStackTrace();
            return null;
        }finally {
            lectura.close();
            return animales;
        }

    }
    }


