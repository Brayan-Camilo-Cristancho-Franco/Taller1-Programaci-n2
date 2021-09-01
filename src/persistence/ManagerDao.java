package persistence;

import edu.unbosque.AnimalesDto;
import edu.unbosque.model.EmptyAttributeException;
import edu.unbosque.model.IdentifierExistsException;

import java.io.IOException;
import java.util.ArrayList;

public class ManagerDao {

    public static void main(String[] args) throws IOException, EmptyAttributeException {

        ManagerDao ma = new ManagerDao();
        //System.out.println("las localidades correctas son: USAQUEN");
        //ma.countByNeighborhoo("USAQUEN");
        //ma.countBySpecies();
        //ma.assingId();
        ma.findByMultipleFields(20, null, null, null, null, Boolean.parseBoolean(""), null);
        //  System.out.println(ma.findByMicrochip(97810108191876l));

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
            cont = 0;
        }
        System.out.println("Proceso terminado");

        for (int i = 0; i < animales.size(); i++) {
            System.out.println(animales.get(i).getId());
        }
    }


    public AnimalesDto findByMicrochip(long microchip) throws EmptyAttributeException, IOException {

        animales = operacion.leerCsv();

        AnimalesDto mascota = null;
        boolean aux = false;

        for (int i = 0; i < animales.size(); i++) {
            if (microchip == animales.get(i).getMicrochip()) {
                mascota = animales.get(i);
                i = animales.size();
                aux = true;
            }

        }
        if (aux == false) {
            System.out.println("Mascota no encontrada");
        }


        return mascota;
    }

    public void countBySpecies() throws EmptyAttributeException, IOException {
        animales = operacion.leerCsv();
        String especie = null;
        int contcan = 0, contfel = 0;
        especie = animales.get(0).getSpecies();
        for (int i = 0; i < animales.size(); i++) {

            if (animales.get(i).getSpecies().equals(especie) == true) {

                contfel++;
            } else {
                especie = animales.get(i).getSpecies();
                contcan++;
            }
        }

        System.out.println("Los " + especie + "S son: " + contcan);
        System.out.println("Los " + animales.get(0).getSpecies() + "S son: " + contfel);
    }

    public void countByNeighborhoo(String neighborhoo) throws EmptyAttributeException, IOException {

        animales = operacion.leerCsv();
        int cont = 0;
        boolean aux = false;


        for (int i = 0; i < animales.size(); i++) {

            if (neighborhoo.equals(animales.get(i).getNeighborhood()) == true) {
                aux = true;
                cont++;
            }
        }
        if (aux == false) {

            System.out.println("La localidad no está bien escrita o no está dentro de la lista");
        } else {

            System.out.println(neighborhoo + " son:" + cont);
        }


    }

    public void findByMultipleFields(int n, String position, String species, String sex, String size, boolean potentDangerous, String neighborhood) throws EmptyAttributeException, IOException {
        animales = operacion.leerCsv();
        ArrayList<AnimalesDto> busqueda = new ArrayList<>();


        if (species != null) {
            for (int i = 0; i < animales.size(); i++) {
                if (species.equals(animales.get(i).getSpecies()) == true) {
                    busqueda.add(animales.get(i));
                }
            }
        }
        if (sex != null) {
            if (species == null) {
                for (int i = 0; i < animales.size(); i++) {
                    if (sex.equals(animales.get(i).getSex()) == true) {
                        busqueda.add(animales.get(i));
                    }
                }

            } else {
                for (int i =busqueda.size()-1; i>=0; i--) {
                    if (sex.equals(busqueda.get(i).getSex()) == false) {
                        busqueda.remove(i);
                    }
                }
            }
        }
        if (size != null) {
            if (species == null && sex == null) {
                for (int i = 0; i < animales.size(); i++) {
                    if (size.equals(animales.get(i).getSize()) == true) {
                        busqueda.add(animales.get(i));
                    }
                }
            } else {
                for (int i =busqueda.size()-1; i>=0; i--) {
                    if (size.equals(busqueda.get(i).getSize()) == false) {
                        busqueda.remove(i);
                    }
                }
            }
        }
        if (String.valueOf(potentDangerous).isBlank() != true) {
            if (species == null && sex == null && size == null) {
                for (int i = 0; i < animales.size(); i++) {
                    if (potentDangerous == animales.get(i).isPotentDangerous()) {
                        busqueda.add(animales.get(i));
                    }
                }
            } else {
                for (int i =busqueda.size()-1; i>=0; i--) {
                    if (potentDangerous != busqueda.get(i).isPotentDangerous()) {
                        busqueda.remove(i);
                    }
                }
            }
        }
        if (neighborhood != null) {
            if (species == null && sex == null && size == null && neighborhood == null) {
                for (int i = 0; i < animales.size(); i++) {
                    if (neighborhood.equals(animales.get(i).getNeighborhood()) == true) {
                        busqueda.add(animales.get(i));
                    }
                }
            } else {

                for (int i =busqueda.size()-1; i>=0; i--) {

                    if (neighborhood.equals(busqueda.get(i).getNeighborhood()) == false) {

                        busqueda.remove(i);


                    }
                }
            }
        }
        if (position != null) {

            if (position.equals("TOP") == true) {

                for (int i = 0; i < busqueda.size(); i++) {
                    System.out.println(busqueda.get(i));
                }

            } else {
                for (int i = busqueda.size() - 1; i >= 0; i--) {

                    System.out.println(busqueda.get(i));
                    ;

                }

            }
        } else {
            System.out.println("Debe indicar el orden para mostrar los datos: TOP| LAST");
        }


    }


}
