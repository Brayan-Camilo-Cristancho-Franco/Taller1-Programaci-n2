package edu.unbosque.controller;

import edu.unbosque.model.EmptyAttributeException;
import edu.unbosque.model.Mundo;
import edu.unbosque.view.ViewConsola;
import persistence.ManagerDao;

import java.io.IOException;

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
        do{
            opcion = Integer.parseInt(view.leerDato("Selecione una opcion:\n" +
                    "1. Buscar por microchip\n" +
                    "2. Contar por especie\n" +
                    "3. Contar por localidad\n" +
                    "4. Buscar...\n\n"));
            switch (opcion){
                case 1:
                    long microchip = 0;
                    microchip = Long.parseLong(view.leerDato("Ingrese el microchip de su animal: "));
                    man.findByMicrochip(microchip);
                    break;
                case 2:
                    System.out.println("Se muestra la cantidad de especies.");
                    man.countBySpecies();
                    break;
                case 3:
                    String neighborhood = "";
                    neighborhood = view.leerDato("Escribe la localidad");
                    man.countByNeighborhood(neighborhood);
                    break;
                case 4:
                    break;
            }
        } while (opcion != 0);
    }

}
