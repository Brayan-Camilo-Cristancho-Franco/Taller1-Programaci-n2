package edu.unbosque.controller;

import edu.unbosque.model.General;
import edu.unbosque.model.Manager;

public class Controller {
    private General gen;

    public Controller(){
        gen = new General();
        gen.getMan().uploadData();
    }


}
