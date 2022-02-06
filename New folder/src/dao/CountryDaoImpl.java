package dao;

import domain.Country;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class CountryDaoImpl {

    protected Connection connection = null;

    public static void main(String[] args) {

        CountryDaoImpl obj = new CountryDaoImpl();
        //Country country = CountrySimulator.buildCountry();

        //obj.insertCountry(country);
        //obj.deleteCountry(country);
        //obj.updateCountry(country); 
        //obj.findCountry(country);
        obj.listCountry();
    }

    public void insertCountry(Country country) {
        System.out.println("Insert Country: "
                + CountryDaoImpl.class.getSimpleName());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:8889/cubetrendsproject",
                            "root", "root");

            PreparedStatement ps;
            ps = connection.prepareStatement("INSERT INTO country (nombre, "
                    + "capital, habitantes, trends, temperatura, area, altitud,"
                    + " location) "
                    + "VALUES (?, ?, ?, ? ,? ,? ,?, ?)");
            ps.setString(1, country.getNombre());
            ps.setString(2, country.getCapital());
            ps.setInt(3, country.getHabitantes());
            ps.setObject(4, country.getTrends());
            ps.setInt(5, country.getTemperatura());
            ps.setFloat(6, country.getArea());
            ps.setFloat(7, country.getAltitud());
            ps.setInt(8, country.getLocation());

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CountryDaoImpl.class.getName()).log(Level.SEVERE,
                    null, ex);
        } catch (ClassNotFoundException cnfe) {
            Logger.getLogger(CountryDaoImpl.class.getName()).log(Level.SEVERE,
                    null, cnfe);
        }
    }

    public void deleteCountry(Country Country) {
        System.out.println("Delete Country: "
                + CountryDaoImpl.class.getSimpleName());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:8889/cubetrendsproject",
                            "root", "root");
            PreparedStatement ps;
            ps = connection.prepareStatement("DELETE FROM country WHERE id=?");
            ps.setInt(1, 1);

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CountryDaoImpl.class.getName()).log(Level.SEVERE,
                    null, ex);
        } catch (ClassNotFoundException cnfe) {
            Logger.getLogger(CountryDaoImpl.class.getName()).log(Level.SEVERE,
                    null, cnfe);
        }
    }

    public void updateCountry(Country Country) {
        System.out.println("Update Country: "
                + CountryDaoImpl.class.getSimpleName());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = CountryDao.getConnection();
            PreparedStatement ps;
            ps = connection.prepareStatement("UPDATE country set temperatura=? "
                    + "WHERE id=?");

            ps.setInt(1, 18);
            ps.setInt(2, 2);

            ps.executeUpdate();

        } catch (SQLException sqle) {
        } catch (ClassNotFoundException cnfe) {
        }
    }

    public List<Country> findCountryById(int id) {

        List<Country> countries = new ArrayList<Country>();
        String sql = "SELECT * FROM country WHERE id=?";

        PreparedStatement ps;
        ResultSet rs;
        Connection connection = null;

        try {
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:8889/cubretrendsproject",
                            "root", "root");
        } catch (Exception sqle) {
            
        }
        return countries;
    }

    public void findCountry(Country Country) {
        System.out.println("Find Country: " + CountryDaoImpl.class.getSimpleName());

        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:8889/cubetrendsproject",
                            "root", "root");

            PreparedStatement ps = connection
                    .prepareStatement("SELECT * FROM country WHERE temperatura=?");
            ps.setInt(1, 18);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("Nombre: " + rs.getString(2));
            }
        } catch (SQLException ex) {
        }
    }

    public List<Country> listCountry() {
        System.out.println("List Country: " + CountryDaoImpl.class.getSimpleName());
        List<Country> countries = new ArrayList<Country>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:8889/cubetrendsproject",
                            "root", "root");
            PreparedStatement ps = connection.
                    prepareStatement("SELECT * FROM country");
            ResultSet rs = ps.executeQuery();
            Country country = new Country();
            while (rs.next()) {
                System.out.println("Nombre: " + rs.getString(2));
                country.setNombre(rs.getString("nombre"));
                country.setCapital("capital");
                country.setTemperatura(20);

                countries.add(country);
            }
        } catch (SQLException ex) {
        } catch (ClassNotFoundException cnfe) {
        }
        return countries;
    }
}
