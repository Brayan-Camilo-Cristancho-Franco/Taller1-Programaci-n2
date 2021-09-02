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

                    System.out.println("Por favor rellene los campos de busqueda que considere necesarios");
                    System.out.println("Número de elementos a mostrar");
                    String n = "";
                    n = view.leerDato(n);

                    System.out.println("Orden especifico, escriba TOP O LAST en el mismo formato ");
                    String position = "";
                    position = view.leerDato(position);

                    System.out.println("Escriba la especie");
                    String species = "";
                    species = view.leerDato(species);

                    System.out.println("Escriba el sexo");
                    String sex = "";
                    sex = view.leerDato(sex);

                    System.out.println("Escriba el tamaño");
                    String size = "";
                    size = view.leerDato(size);

                    System.out.println("Escriba si es una especie peligrosa true o false en este formato");
                    String potentDangerous = "";
                    potentDangerous = view.leerDato(potentDangerous);

                    System.out.println("Escriba la localidad");
                    String localidad = "";
                    localidad = view.leerDato(localidad);

                    man.findByMultipleFields(Integer.parseInt(n), position, species, sex, size, Boolean.parseBoolean(potentDangerous), localidad);
                    break;

            }
        } while (opcion != 0);
    }

}
