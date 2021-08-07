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
public class Winner {
    private String nombre;
    private int position;
    private int numberOfWins;

    public Winner(String nombre, int position, int numberOfWins) {
        this.nombre = nombre;
        this.position = position;
        this.numberOfWins = numberOfWins;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }
    
}
