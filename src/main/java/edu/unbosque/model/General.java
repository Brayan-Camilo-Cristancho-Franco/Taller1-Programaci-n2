package edu.unbosque.model;

public class General {
    private Pet p;
    private Manager man;

    public General(){
        p = new Pet();
        man = new Manager();
    }

    public Pet getP() {
        return p;
    }

    public void setP(Pet p) {
        this.p = p;
    }

    public Manager getMan() {
        return man;
    }

    public void setMan(Manager man) {
        this.man = man;
    }
}
