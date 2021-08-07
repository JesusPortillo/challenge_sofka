/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Hewlett Packard
 */
public class Game {
    private int idGame;
    private Track track;
    private List<Player> listPlayers = new ArrayList();

    
    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public List<Player> getListPlayers() {
        return listPlayers;
    }

    public void setListPlayers(List<Player> listPlayers) {
        this.listPlayers = listPlayers;
    }
    
    
    
    public void GameSettings(){
        
    }

    public List<Integer> ListWinnersOfTheGame(ArrayList<Integer> numberOfAttemps, List<Integer> quantity){
        ArrayList <Integer> ordered = (ArrayList<Integer>) numberOfAttemps.clone();
        List <Integer> res = new ArrayList<>();
        List<Integer> added = new ArrayList<>();
        Collections.sort(ordered);
        
        int win1 = numberOfAttemps.indexOf(ordered.get(0));
        int win2 = numberOfAttemps.indexOf(ordered.get(1));
        int win3 = numberOfAttemps.lastIndexOf(ordered.get(2));
       
        
        res.add(win1);
        res.add(win2);
        res.add(win3);
        /*for (int i = 0; i < res.size(); i++) {
            for (int j = i + 1; j < res.size(); j++) {
                if (res.get(i) == res.get(j)) {
                    if (i == res.size()-1) {
                        
                    }
             
                }
            }
        }*/
        
    return res;}
    
    public List<String> NameOfWinners(List<Integer> winnerPos, List<Car> lsCar){
        List<String> resName = new ArrayList<>();
        for (Integer pos : winnerPos) {
            Car c = lsCar.get(pos);
            resName.add(c.getDriverName());
        }
    return resName;}
}
