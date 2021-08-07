/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import Model.Car;
import Model.ConnectionDB;
import Model.Driver;
import Model.Game;
import Model.Player;
import Model.Podium;
import Model.Track;
import Model.Winner;
import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Hewlett Packard
 */
public class Challenge_Sofka {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Code for save the entries for game settings
        int counter = 0;
        String trackName;
        int numberOfLanes;
        int distance;
        Scanner en = new Scanner(System.in);
        System.out.println("Type the name of the track: ");
        trackName = en.nextLine();
        System.out.println("Type the number of players: "); 
        numberOfLanes = en.nextInt();
        while (numberOfLanes < 3) {            
            System.out.println("The minimun number of players is 3, Type a valid entry");
            numberOfLanes = en.nextInt();
        }
        System.out.println("Type the distance of the track: "); 
        distance = en.nextInt();
        en.nextLine();
        Game objGame = new Game();
        Track tr = new Track(trackName, numberOfLanes, distance);
        ConnectionDB db = new ConnectionDB();
        List <Player> lsPlayer= new ArrayList<>();
        List <Driver> lsDriver = new ArrayList<>();
        List <Car> lsCar = new ArrayList<>();
        // getting the player's data
        while(counter != numberOfLanes){
            String playerName;
            String isDriver;
            System.out.println("Type the name of the player number "+(counter+1));
            playerName = en.nextLine();
            System.out.println("Would you like be a driver? type 1 if you want, otherwise type 0");
            isDriver = en.nextLine();
            boolean is = false;
            if (isDriver.equals("1")) {
                is = true;
                Driver objDriver = new Driver(counter, counter, playerName);
                lsDriver.add(objDriver);
            }else{
                Driver objDriver = new Driver(counter, counter, "Unknown");
                lsDriver.add(objDriver);
            }
            
            Player objPlayer = new Player(playerName, is);
            lsPlayer.add(objPlayer);
            Car objCar = new Car(counter, playerName, counter, counter);
            lsCar.add(objCar);
            counter += 1;
            
        }   
        // Starting the game
            int totRoad = distance;
            ArrayList <Integer> numberOfAttemps = new ArrayList<>();
            List <Integer> quantity = new ArrayList<>();
            int counterAttempsByCar = 0;
            for (Car car : lsCar) {
                while(totRoad > 0){
                    totRoad -= car.move();
                    counterAttempsByCar += 1;
                }
            quantity.add(totRoad);
            numberOfAttemps.add(counterAttempsByCar);
            counterAttempsByCar = 0;
            totRoad = distance;
            }
         // saving the winners and podium
            List<Integer> pos = new ArrayList<>();
            pos = objGame.ListWinnersOfTheGame(numberOfAttemps, quantity);
            List<String> names = new ArrayList<>();
            names = objGame.NameOfWinners(pos, lsCar);
            Podium pod = new Podium(names.get(0), names.get(1), names.get(2));
            Winner wi1 = new Winner(pod.getFirstPlace(), 1, 1);
            Winner wi2 = new Winner(pod.getSecondPlace(), 2, 1);
            Winner wi3 = new Winner(pod.getThirdPlace(), 3, 1);
            List<Winner> currentWinners = new ArrayList<>();
            currentWinners.add(wi1);
            currentWinners.add(wi2);
            currentWinners.add(wi3);
            
            System.out.println("Number of attemps for each player: "+numberOfAttemps);
            System.out.println("The winners are: "+ names);
            
// Here, I'm checking if the database is empty, in case that true, save all the current winners, if is false, 
// create a list with the names of the winners saved, after that go through the list and if the list contains a winner's name
// update the register if not, add to a missing list for save all the winner from this list.
            List<Winner> history2 = new ArrayList<>();
            List<Winner> missing = new ArrayList<>();
            history2 = db.GetWinners();
            if (history2.isEmpty()) {
            db.ExecuteQuery(String.format("INSERT INTO ganador VALUES('%s',%d,%d);" + "", currentWinners.get(0).getNombre(), 1, 1));
            db.ExecuteQuery(String.format("INSERT INTO ganador VALUES('%s',%d,%d);" + "", currentWinners.get(1).getNombre(), 2, 1));
            db.ExecuteQuery(String.format("INSERT INTO ganador VALUES('%s',%d,%d);" + "", currentWinners.get(2).getNombre(), 3, 1));
        } else {
                List<String> nameHistory = new ArrayList<>();
                for (Winner winner : history2) {
                    nameHistory.add(winner.getNombre());
                }
                for (int i = 0; i < names.size(); i++) {
                    if (nameHistory.contains(currentWinners.get(i).getNombre())) {
                        db.ExecuteQuery(String.format("UPDATE ganador SET numerovictorias = numerovictorias + 1 WHERE nombre = ('%s')", currentWinners.get(i).getNombre()));
                    }else{
                        missing.add(currentWinners.get(i));
                    }
                }
            for (Winner winner : missing) {
                db.ExecuteQuery(String.format("INSERT INTO ganador VALUES('%s',%d,%d);" + "", winner.getNombre(), winner.getPosition(), winner.getNumberOfWins()));
            }
        
        }
                 
    }
    
}
