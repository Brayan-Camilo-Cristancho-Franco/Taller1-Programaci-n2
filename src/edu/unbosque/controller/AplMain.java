package edu.unbosque.controller;

import edu.unbosque.model.EmptyAttributeException;

import java.io.IOException;

public class AplMain {
    static Controller c;

    public static void main(String[] args) throws EmptyAttributeException, IOException {
        c = new Controller();
    }
}
