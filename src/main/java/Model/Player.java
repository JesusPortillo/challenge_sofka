/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Hewlett Packard
 */
public class Player {
    private String nombre;
    private boolean isDriver;

    public Player(String nombre, boolean isDriver) {
        this.nombre = nombre;
        this.isDriver = isDriver;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isIsDriver() {
        return isDriver;
    }

    public void setIsDriver(boolean isDriver) {
        this.isDriver = isDriver;
    }
    
    
}
