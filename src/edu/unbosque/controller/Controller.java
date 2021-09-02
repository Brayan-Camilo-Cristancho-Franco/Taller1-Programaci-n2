package edu.unbosque.controller;

import edu.unbosque.model.EmptyAttributeException;
import edu.unbosque.persistence.ManagerDao;
import edu.unbosque.view.ViewConsola;


import java.io.IOException;
import java.util.Scanner;

public class Controller {

    private ManagerDao man;
    private ViewConsola view;

    Controller() throws EmptyAttributeException, IOException {
        man = new ManagerDao();
        view = new ViewConsola();
        ui();
    }

    public void ui() throws EmptyAttributeException, IOException {
        int opcion = 0;
        do {
            opcion = Integer.parseInt(view.leerDato("Selecione una opcion:\n" +
                    "1. Asignar id\n" +
                    "2. Buscar por microchip\n" +
                    "3. Contar por especie\n" +
                    "4. Contar por localidad\n" +
                    "5. Buscar...\n\n"));
            switch (opcion) {
                case 1:
                    man.assingId();
                    break;
                case 2:
                    long microchip = 0;
                    microchip = Long.parseLong(view.leerDato("Ingrese el microchip de su animal: "));
                    System.out.println(man.findByMicrochip(microchip));
                    break;
                case 3:
                    System.out.println("Se muestra la cantidad de especies.");
                    man.countBySpecies();
                    break;
                case 4:
                    String neighborhood = "";
                    neighborhood = view.leerDato("Escribe la localidad");
                    man.countByNeighborhood(neighborhood);
                    break;
                case 5:
                    String n = "";
                    String position = "";
                    String species = "";
                    String sex = "";
                    String size = "";
                    boolean potentDangerous;
                    String localidad = "";

                    System.out.println("Por favor rellene los campos de busqueda que considere necesarios");
                    try{
                        n = view.leerDato("Número de elementos a mostrar");

                        position = view.leerDato("Orden especifico, escriba TOP O LAST en el mismo formato ");

                        species = view.leerDato("Escriba la especie");

                        sex = view.leerDato("Escriba el sexo");

                        size = view.leerDato("Escriba el tamaño");

                        potentDangerous = Boolean.parseBoolean(view.leerDato("Escriba si es una especie peligrosa true o false en este formato"));

                        localidad = view.leerDato("Escriba la localidad");

                        man.findByMultipleFields(Integer.parseInt(n), position, species, sex, size, potentDangerous, localidad);
                    } catch (IndexOutOfBoundsException e){
                        System.out.println("No hay mas lineas que mostrar");
                    }
                    break;

            }
        } while (opcion != 0);
    }

}
