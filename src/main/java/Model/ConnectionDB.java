/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Hewlett Packard
 */
public class ConnectionDB {
    private Connection con = null;
    private final String password = "321.postgre";
    private final String user = "postgres";


    
    public void Connect(){
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sofka", user, password);
        } catch (SQLException e) {
        }
    }
    public void ExecuteQuery(String query){
        PreparedStatement pe = null;
        Connect();
        try {
            pe = con.prepareStatement(query);
            pe.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public List<Winner> GetWinners(){
        List <Winner> lista = null;
        try {
            Connect();
            PreparedStatement pe = con.prepareStatement("SELECT * FROM ganador");
             lista= new ArrayList();
            ResultSet rs = pe.executeQuery();
            while(rs.next()){
                String nombre = rs.getString("nombre");
                int position = Integer.parseInt(rs.getString("posicion"));
                int numberWins = Integer.parseInt(rs.getString("numerovictorias"));
                Winner obj =  new Winner(nombre, position, numberWins);
                lista.add(obj);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    return lista;}
}
