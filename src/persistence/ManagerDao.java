package persistence;

import edu.unbosque.AnimalesDto;
import edu.unbosque.model.EmptyAttributeException;
import edu.unbosque.model.IdentifierExistsException;

import java.io.IOException;
import java.util.ArrayList;

public class ManagerDao {

    public static void main(String[] args) throws IOException, EmptyAttributeException {

        ManagerDao ma = new ManagerDao();
        ma.assingId();

    }

    private ArrayList<AnimalesDto> animales = new ArrayList<>();

    private OperacionArchivo operacion;

    public ManagerDao() {
        animales = new ArrayList<>();
        operacion = new OperacionArchivo();
    }

    public void assingId() throws EmptyAttributeException, IOException {
        animales = operacion.leerCsv();
        String id = "";
        String newid;
        int cont = 0;
        char c, d;
        System.out.println("Asignando id");
        for (int i = 0; i < animales.size(); i++) {

            if (animales.get(i).getSize() == "MUY GRANDE") {
                animales.get(i).setSize("GRANDE");
            }


            id = String.valueOf(animales.get(i).getMicrochip()).charAt(String.valueOf(animales.get(i).getMicrochip()).length() - 2) + "" + String.valueOf(animales.get(i).getMicrochip()).charAt(String.valueOf(animales.get(i).getMicrochip()).length() - 1) + "-" + animales.get(i).getSpecies().charAt(0) + animales.get(i).getSex().charAt(0) + animales.get(i).getSize().charAt(0) + String.valueOf(animales.get(i).isPotentDangerous());

            if (id.charAt(6) == 't') {

                id = id.replace("t", "T");
                id = id.replace("r", "");
                id = id.replace("u", "");
                id = id.replace("e", "");
            } else {
                id = id.replace("f", "F");
                id = id.replace("a", "");
                id = id.replace("l", "");
                id = id.replace("s", "");
                id = id.replace("e", "");


            }
            animales.get(i).setId(id);
            cont = 0;
        }
        System.out.println(id);
        for (int a = 1; a < animales.size(); a++) {
            for (int j = a - 1; j >= 0; j--) {
                try {

                    if (animales.get(a).getId().equals(animales.get(j).getId()) == true) {
                        cont++;
                        throw new IdentifierExistsException();

                    }


                } catch (IdentifierExistsException e) {

                    newid = String.valueOf(animales.get(j).getMicrochip()).charAt(String.valueOf(animales.get(j).getMicrochip()).length() - (cont + 2)) + animales.get(j).getId();
                    animales.get(j).setId(newid);
                }

            }
            cont=0;
        }
        System.out.println("Proceso terminado");

        for (int i=0;i<animales.size();i++){
            System.out.println(animales.get(i).getId());
        }
    }
    //for (int i = 0; i < animales.size(); i++) {
    //  for (int j = i + 1; j < animales.size(); j++) {
    //    try {
    //      System.out.println(cont + "eeeeeeeeeeeeeeee");
    //    if (animales.get(i).getId().equals(animales.get(j).getId()) == true) {
    //      cont++;
    //}

    //if (cont > 1) {
    //  cont = 0;
    //throw new IdentifierExistsException();

    //}


    //} catch (IdentifierExistsException e) {

    //  System.out.println(animales.get(i).getId() + "El id ya ha sido generado" + animales.get(j).getId());


    //}
    //}

    //}


    public ArrayList<AnimalesDto> buscarMascota(String alias) {

        return animales;
    }

    public void modificarMicrochip(String id, String nuevoChip) {


    }

    public void modificarSpecies(String id, String nuevoEs) {


    }

    public void modificarSex(String id, String nuevoSex) {


    }

    public void modificarSize(String id, String nuevoSize) {


    }

    public void modificarPotentDangerous(String id, String nuevoPt) {


    }

    public void eliminarMascota(String id) {

    }

    public void añadirMascota(String id) {

    }


}
