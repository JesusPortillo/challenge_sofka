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
public class Track {
    private String trackName;
    private int nummberOfLanes;
    private int distance;

    public Track(String trackName, int nummberOfLanes, int distance) {
        this.trackName = trackName;
        this.nummberOfLanes = nummberOfLanes;
        this.distance = distance;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public int getNummberOfLanes() {
        return nummberOfLanes;
    }

    public void setNummberOfLanes(int nummberOfLanes) {
        this.nummberOfLanes = nummberOfLanes;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    
    
    
}
