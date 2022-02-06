/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import domain.Citizen;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author macmini
 */
public class CitizenDaoImpl {

    protected Connection connection = null;

    public static void main(String[] args) {

        CitizenDaoImpl obj = new CitizenDaoImpl();
        Citizen citizen = new Citizen();
             
        //obj.listCitizen();
         obj.insertCitizen(citizen);
        //obj.deleteCitizen(citizen);
        //obj.updateCitizen(citizen); 
        //obj.findCitizen(citizen);
    }

    public void insertCitizen(Citizen citizen) {
        System.out.println("Insert citizen: " + CitizenDaoImpl.class.getSimpleName());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:8889/cubetrendsproject",
                            "root", "root");

            PreparedStatement ps;
            ps = connection.prepareStatement("INSERT INTO citizen (edad, sexo, "
                    + "nombre, empleo, salario, eps, compensacion) "
                    + "VALUES (?, ?, ?, ? ,? ,? ,?)");
            ps.setInt(1, citizen.getEdad());
            ps.setString(2, citizen.getSexo());
            ps.setString(3, citizen.getNombre());
            ps.setString(4, citizen.getEmpleo());
            ps.setInt(5, citizen.getSalario());
            ps.setString(6, citizen.getEps());
            ps.setString(7, citizen.getCompensacion());

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CitizenDaoImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException cnfe) {
            Logger.getLogger(CitizenDaoImpl.class.getName())
                    .log(Level.SEVERE, null, cnfe);
        }
    }

    protected void deleteCitizen(Citizen citizen) {
        System.out.println("Delete citizen: " + CitizenDaoImpl.class.getSimpleName());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:8889/cubetrendsproject",
                            "root", "root");
            PreparedStatement ps;
            ps = connection.prepareStatement("DELETE FROM citizen WHERE id=?");
            ps.setInt(1, 1);

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CitizenDaoImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CitizenDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateCitizen(Citizen citizen) {
        System.out.println("Update citizen: " + CitizenDaoImpl.class.getSimpleName());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:8889/cubetrendsproject",
                            "root", "root");
            PreparedStatement ps;
            ps = connection.prepareStatement("UPDATE citizen set edad=? WHERE id=?");
            ps.setInt(1, 20);
            ps.setInt(2, 2);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            Logger.getLogger(CitizenDaoImpl.class.getName()).log(Level.SEVERE,
                    null, sqle);
        } catch (ClassNotFoundException cnfe) {
            Logger.getLogger(CitizenDaoImpl.class.getName()).log(Level.SEVERE,
                    null, cnfe);
        }
    }

    public void findCitizen(Citizen citizen) {
        System.out.println("Find citizen: " + CitizenDaoImpl.class.getSimpleName());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:8889/cubetrendsproject",
                            "root", "root");

            PreparedStatement ps = connection.
                    prepareStatement("SELECT * FROM citizen WHERE edad=?");
            ps.setInt(1, 20);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("Edad: " + rs.getInt(2));
                System.out.println("Nombre: " + rs.getString(4));
                System.out.println("Empleo: " + rs.getInt(5));
                System.out.println("Salario: " + (rs.getInt(6)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CitizenDaoImpl.class.getName()).log(Level.SEVERE,
                    null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CitizenDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Citizen> listCitizen() {
        System.out.println("List citizen: " + CitizenDaoImpl.class.getSimpleName());
        List<Citizen> citizen_s = new ArrayList<Citizen>();
        Citizen citizen = new Citizen();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:8889/cubetrendsproject",
                            "root", "root");

            PreparedStatement ps
                    = connection.prepareStatement("SELECT * FROM citizen");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                citizen.setNombre(rs.getString("nombre"));
                citizen.setEmpleo(rs.getString("empleo"));
                citizen_s.add(citizen);
//                System.out.println("Edad: " + rs.getInt(2));
//                System.out.println("Nombre: " + rs.getString(4));
//                System.out.println("Empleo: " + rs.getInt(5));
//                System.out.println("Salario: " + (rs.getInt(6)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CitizenDaoImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CitizenDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return citizen_s;
    }
}
