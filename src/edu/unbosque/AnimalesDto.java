package edu.unbosque;

public class AnimalesDto {

    private int id;
    private long microchip;
    private String species;
    private String sex;
    private String size;
    private boolean potentDangerous;
    private String neighborhood;

    public AnimalesDto(int id, long microchip, String species, String sex, String size, boolean potentDangerous, String neighborhood) {
        this.id = id;
        this.microchip = microchip;
        this.species = species;
        this.sex = sex;
        this.size = size;
        this.potentDangerous = potentDangerous;
        this.neighborhood = neighborhood;

    }

    @Override
    public String toString() {
        return "Animal{" +
                "id='" + id + '\'' +
                ", microchip='" + microchip + '\'' +
                ", species='" + species + '\'' +
                ", sex='" + sex + '\'' +
                ", size='" + size + '\'' +
                ", potentDangerous=" + potentDangerous +
                ", neighborhood='" + neighborhood + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getMicrochip() {
        return microchip;
    }

    public void setMicrochip(Long microchip) {
        this.microchip = microchip;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean isPotentDangerous() {
        return potentDangerous;
    }

    public void setPotentDangerous(Boolean potentDangerous) {
        this.potentDangerous = potentDangerous;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
}