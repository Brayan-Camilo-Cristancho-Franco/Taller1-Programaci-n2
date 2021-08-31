package persistence;

import edu.unbosque.AnimalesDto;
import edu.unbosque.model.EmptyAttributeException;

import java.io.*;
import java.util.ArrayList;

public class OperacionArchivo {

    private static final String csvfile = "./Data/pets-citizens.csv";

    public static void main(String[] args) throws IOException, NumberFormatException {

        OperacionArchivo op = new OperacionArchivo();

        System.out.println("Los animales no registrados fueron: \n ");
        for (int j = 0; j < op.leerCsv().size(); j++) {
            System.out.println(op.leerCsv().get(j) + "\n");
        }
    }

    public ArrayList<AnimalesDto> leerCsv() throws IOException, NumberFormatException {

        ArrayList<AnimalesDto> animales = new ArrayList<>();
        BufferedReader lectura = null;
        ArrayList<String> noreg = new ArrayList<String>();
        int i = 0;
        try {


            lectura = new BufferedReader(new FileReader(csvfile));
            String linea = lectura.readLine();
            int cont = 0;

            while (linea != null) {
                try {


                    String temp[] = linea.split(";");
                    cont = linea.length();
                    if (linea.charAt((cont - 1)) == ';') {

                        throw new EmptyAttributeException();
                    }
                    if (temp[4].equals("SI")) {
                        temp[4] = "true";
                    } else {
                        temp[4] = "false";
                    }
                    animales.add(new AnimalesDto(String.valueOf(i), Long.parseLong(temp[0]), temp[1], temp[2], temp[3], Boolean.parseBoolean(temp[4]), temp[5]));

                    linea = lectura.readLine();
                    // try {


                } catch (NumberFormatException | EmptyAttributeException e) {
                    noreg.add(linea);

                    linea = lectura.readLine();

                }


                i++;

            }

            lectura.close();

            //System.out.println("Los animales no registrados fueron: \n ");
            //for (int j = 0; j < noreg.size(); j++) {
            //    System.out.println(noreg.get(j) + "\n");
            //}
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            lectura.close();
            return animales;
        }

    }

}

