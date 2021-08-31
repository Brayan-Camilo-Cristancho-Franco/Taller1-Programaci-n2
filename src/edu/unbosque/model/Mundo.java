package edu.unbosque.model;

import persistence.ManagerDao;
import persistence.OperacionArchivo;

public class Mundo {

    private ManagerDao man;
    private OperacionArchivo op;

    public ManagerDao getMan() {
        return man;
    }

    public OperacionArchivo getOp() {
        return op;
    }
}
