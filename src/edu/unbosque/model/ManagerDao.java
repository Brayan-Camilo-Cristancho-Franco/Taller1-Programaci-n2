package edu.unbosque.model;

import edu.unbosque.AnimalesDto;

import java.io.IOException;
import java.time.Clock;
import java.util.ArrayList;

public class ManagerDao {

    public static void main(String[] args) throws IOException {

        ManagerDao ma = new ManagerDao();
        ma.assingId();

    }

    private ArrayList<AnimalesDto> animales = new ArrayList<>();

    private OperacionArchivo operacion;

    public void assingId() {
        String id;
        char c, d;
        AnimalesDto nuevo = new AnimalesDto("", "900250000596405", "CANINO", "HEMBRA", "GRANDE", "SI", "Usaquen");
        animales.add(nuevo);
        for (int i = 0; i < animales.size(); i++) {

            if (animales.get(i).getSize() == "MUY GRANDE") {
                animales.get(i).setSize("GRANDE");
            }
            id = animales.get(i).getMicrochip().charAt(13) + "" + animales.get(i).getMicrochip().charAt(14) + "-" + animales.get(i).getSpecies().charAt(0) + animales.get(i).getSex().charAt(0) + animales.get(i).getSize().charAt(0) + animales.get(i).isPotentDangerous();

            if (id.charAt(7) == 'I') {

                id = id.replace("S", "T");
                id = id.replace("I", "");
            } else {
                id = id.replace("N", "F");
                id = id.replace("O", "");
            }
            animales.get(i).setId(id);
            for (int j = 0; j < animales.size(); j++) {
                try {
                    //  if (animales.get(i).getId() == animales.get(j).getId()) {
                    //   nuevoid= animales.get(i).get
                    throw new IdentifierExistsException();
                } catch (IdentifierExistsException e) {
                    e.printStackTrace();
                    System.out.println("El id ya ha sido generado");

                }

            }
            System.out.println(id);


        }
    }

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
