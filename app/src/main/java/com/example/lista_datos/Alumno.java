package com.example.lista_datos;

import java.io.Serializable;

public class Alumno implements Serializable {
    private String nombre, apellido, numc, genero;
    public Alumno(String nombre, String apellido, String numc, String genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numc = numc;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return getNombre()+" "+getApellido()+" "+getNumcuenta()+" "+getGenero();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumcuenta() {
        return numc;
    }

    public void setNumcuenta(String numc) {
        this.numc = numc;
    }

    public String getGenero() {

        return genero;
    }

    public void setGenero(String genero) {

        this.genero = genero;
    }

}
