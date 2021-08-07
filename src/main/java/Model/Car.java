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
public class Car {
    private int idCar;
    private String driverName;
    private int idLane;
    private int position;
    public Car(int idCar, String driverName, int idLane, int position) {
        this.idCar = idCar;
        this.driverName = driverName;
        this.idLane = idLane;
        this.position = position;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int getIdLane() {
        return idLane;
    }

    public void setIdLane(int idLane) {
        this.idLane = idLane;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    
    
    public int move(){
        int dice = (int)(Math.random()*6+1);
        int res = dice * 100;
    return res;}
}
