package edu.eci.cvds.samples.services;

public class ExcepcionServiciosAlquiler extends Exception {
    public ExcepcionServiciosAlquiler(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

    public ExcepcionServiciosAlquiler(String mensaje) {
        super(mensaje);
    }
}