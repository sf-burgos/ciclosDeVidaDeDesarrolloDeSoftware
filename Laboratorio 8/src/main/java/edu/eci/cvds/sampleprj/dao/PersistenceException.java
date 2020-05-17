
package edu.eci.cvds.sampleprj.dao;

public class PersistenceException extends Exception{

    public PersistenceException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
