package edu.unbosque.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class Manager {

    private static final String csvfile = "./data/pets-citizens.csv";
    private String line;
    private Object NumberFormatException;
    private List<Pet> pets;
    private Pet pet;

    public Manager() {
        pets = new ArrayList<>();
        pet = new Pet();
    }

    public void assignID() {

    }

    private Function<String, Pet> mapToItem = line -> {

        String[] p = line.split(";");
        Scanner scn = new Scanner(String.valueOf(pet));
        try{
            //pet.setId(p[0]);
            pet.setMicrochip(Long.parseLong(p[0]));
            pet.setSpecies(p[1]);
            pet.setSex(p[2]);
            pet.setSize(p[3]);
            pet.setPotentDangerous(Boolean.parseBoolean(p[4]));
            pet.setNeighborhood(p[5]);
        }catch (NumberFormatException e) {
            while (String.valueOf(pet.getMicrochip()).contains("^[a-zA-Z]+$")){
                continue;
            }
        }
        return pet;
    };

    public void uploadData() {

    }

}
