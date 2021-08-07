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
public class Lane {
    private int idLane;
    private String trackName;

    public Lane(int idLane, String trackName) {
        this.idLane = idLane;
        this.trackName = trackName;
    }

    public int getIdLane() {
        return idLane;
    }

    public void setIdLane(int idLane) {
        this.idLane = idLane;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }
    
    
}
