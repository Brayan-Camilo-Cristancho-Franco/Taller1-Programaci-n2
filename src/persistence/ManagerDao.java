package persistence;

import edu.unbosque.AnimalesDto;
import edu.unbosque.model.EmptyAttributeException;
import edu.unbosque.model.IdentifierExistsException;

import java.io.IOException;
import java.util.ArrayList;

public class ManagerDao {

    public static void main(String[] args) throws IOException, EmptyAttributeException, IdentifierExistsException {

        ManagerDao ma = new ManagerDao();
        ma.assingId();

    }

    private ArrayList<AnimalesDto> animales = new ArrayList<>();

    private OperacionArchivo operacion;

    public ManagerDao() {
        animales = new ArrayList<>();
        operacion = new OperacionArchivo();
    }

    public void assingId() throws EmptyAttributeException, IOException, IdentifierExistsException {
        animales = operacion.leerCsv();
        String id = "";
        int cont = 0;
        char c, d;

        for (int i = 0; i < animales.size(); i++) {

            if (animales.get(i).getSize() == "MUY GRANDE") {
                animales.get(i).setSize("GRANDE");
            }


            id = String.valueOf(animales.get(i).getMicrochip()).charAt(String.valueOf(animales.get(i).getMicrochip()).length() - 2) + "" + String.valueOf(animales.get(i).getMicrochip()).charAt(String.valueOf(animales.get(i).getMicrochip()).length() - 1) + "-" + animales.get(i).getSpecies().charAt(0) + animales.get(i).getSex().charAt(0) + animales.get(i).getSize().charAt(0) + String.valueOf(animales.get(i).isPotentDangerous());

            if (id.charAt(7) == 't') {

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

            for (int j = 0; j < animales.size(); j++) {
                try {
                    if (animales.get(i).getId().equals(animales.get(j).getId()) == true) {
                        cont++;
                    }

                    if (cont > 1) {

                        throw new IdentifierExistsException();

                    }

                } catch (IdentifierExistsException e) {

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
