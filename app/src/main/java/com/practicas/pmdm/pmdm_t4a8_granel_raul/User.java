package com.practicas.pmdm.pmdm_t4a8_granel_raul;

public class User {

    private Integer id;
    private String name;
    private String firsSurname;
    private String secondSurname;

    public User() {
    }

    public User(Integer id, String name, String firsSurname, String secondSurname) {
        this.id = id;
        this.name = name;
        this.firsSurname = firsSurname;
        this.secondSurname = secondSurname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirsSurname() {
        return firsSurname;
    }

    public void setFirsSurname(String firsSurname) {
        this.firsSurname = firsSurname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    @Override
    public String toString() {
        return "¡Hola! Me llamo "
                + name + " "
                + firsSurname
                + " "
                + secondSurname;
    }

}

