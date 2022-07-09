package org.sofka.software.cursoreactividadprojectreactor.model;

public class Persona {
    private Integer idPersona;
    private String nombre;
    private Integer edad;

    public Persona(Integer idPersona, String nombre, Integer edad) {
        super();
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.edad = edad;
    }

    public Integer idPersona() {
        return idPersona;
    }

    public void idPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String nombre() {
        return nombre;
    }

    public void nombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer edad() {
        return edad;
    }

    public void edad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public String toString(){
        return "Persona [idPersona= " + idPersona + ", nombres= "+ nombre + ", edad= "+ edad + "]";
    }
}


