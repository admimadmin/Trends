/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.City;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lib.MysqlService;
import lib.Util;
import simulation.CitySimulator;

/**
 *
 * @author macmini
 */
public class CityDaoImpl {

    private Connection connection;

    public static void main(String[] args) {

        City city = new City();
        city = CitySimulator.buildCityObject();
               
        CityDaoImpl daoImpl = new CityDaoImpl("relational_shema");
        daoImpl.insertCity(city);
        //daoImpl.deleteCity(city);
        //daoImpl.updateCity(city);
        //daoImpl.findCity(city);
       // daoImpl.listCity();
    }

    protected void insertCity(City city) {
        System.out.println("Insert City: " + CityDaoImpl.class.getSimpleName());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:8889/cubetrendsproject",
                    "root", "root");

            PreparedStatement ps;
            ps = connection.prepareStatement("INSERT INTO ciudad (nombre, capital, "
                    + "location, date, temperatura, departamento, trends, altitud, "
                    + "area, habitantes) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            ps.setString(1, city.getNombre());
            ps.setObject(2, city.getCapital());
            ps.setString(3, city.getLocation());
            ps.setDate(4, city.getFecha());
            ps.setInt(5, city.getTemperatura());
            ps.setString(6, city.getDepartamento());
            ps.setObject(7, city.getTrends());
            ps.setInt(8, city.getAltitud());
            ps.setFloat(9, city.getArea());
            ps.setInt(10, city.getHabitantes());

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CityDaoImpl.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException cnfe) {
            Logger.getLogger(CityDaoImpl.class.getName()).log(Level.SEVERE, null,
                    cnfe);
        }
    }

    protected void deleteCity(City City) {
        System.out.println("Delete City: " + CityDaoImpl.class.getSimpleName());


        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:8889/cubetrendsproject",
                            "root", "root");
            PreparedStatement ps;
            ps = connection.prepareStatement("DELETE FROM ciudad WHERE id=?");
            ps.setInt(1, 2);

            ps.executeUpdate();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CityDaoImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CityDaoImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    protected void updateCity(City City) {
        System.out.println("Update City: " + CityDaoImpl.class.getSimpleName());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:8889/cubetrendsproject",
                            "root", "root");
            PreparedStatement ps;
            ps = connection.
                    prepareStatement("UPDATE ciudad set habitantes=? WHERE id=?");

            ps.setInt(1, 20);
            ps.setInt(2, 3);

            ps.executeUpdate();

        } catch (SQLException sqle) {
            Logger.getLogger(CityDaoImpl.class.getName()).
                    log(Level.SEVERE, null, sqle);
        } catch (ClassNotFoundException cnfe) {
            Logger.getLogger(CityDaoImpl.class.getName()).
                    log(Level.SEVERE, null, cnfe);
        }
    }

    protected void findCity(City City) {
        System.out.println("Find City: " + CityDaoImpl.class.getSimpleName());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:8889/cubetrendsproject", 
                            "root", "root");

            PreparedStatement ps = connection
                    .prepareStatement("SELECT * FROM ciudad WHERE temperatura=?");
            ps.setInt(1, 25);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Nombre: " + rs.getString(2));              
            }

        } catch (SQLException ex) {
            Logger.getLogger(CityDaoImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    protected void listCity() {
        System.out.println("List City: " + CityDaoImpl.class.getSimpleName());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:8889/cubetrendsproject",
                            "root", "root");

            PreparedStatement ps = connection.
                    prepareStatement("SELECT * FROM ciudad");
           

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("id: " + rs.getInt(1));
                System.out.println("Nombre: " + rs.getString(2));
                System.out.println("Capital: " + rs.getObject(3));
                System.out.println("Ubicacion: " + (rs.getString(4)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CityDaoImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CityDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    protected Connection conn;
 
    protected City ciudad;
    protected List<City> ciudades;
    List<City> cities;
    private static final String WRITE_CITY_SQL = "INSERT INTO city (object) VALUES (?)";

    public CityDaoImpl(String shema) {

        try {
            conn = MysqlService.connToDatabase(shema);
        } catch (Exception ex) {
            Logger.getLogger(CityDao.class.getName()).log(Level.SEVERE, null, ex.getCause());
        }
    }

    public CityDaoImpl(){}//On void constructor connect to database by default
    
    /**
     * This method enable the test options
     *
     * @param enable
     */
    public CityDaoImpl(boolean enable) {

        if (enable) {
            ciudades = CitySimulator.buildMultipleCity(1000);
        }

    }

    public List<City> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<City> ciudades) {

        /**
         * *
         * Precondicion: - Read database registers if ( null ) - Ieer archivo -
         * Formatear vaIores - guardar vaIores
         *
         */
        this.ciudades = ciudades;
    }

    public void loadCurrentLocation() {
    }

    public void loadTemperatura() {
    }

    public void loadCurrentDate() {
        DateFormat dform = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        //Date obj = new Date();

        // return dform.format(dform.format(obj));
    }

    public List<City> loadCityFromDateInterval(Date date) {

        /**
         *
         *
         * INSERT INTO `datamining`.`date` (`id` ,`fechaInicial`
         * ,`fechaFin`)VALUES (NULL , '2021-11-09', '2021-11-30');
         *
         * SELECT colum_name(s) FROM tabLe_name WHERE column_name BETWEEN values
         * AND value;
         *
         * SElECT () FROM TABLE_NAME WHERE date between ? and ?
         *
         * SElECT () FROM TABLE_NAME WHERE date between ? and ?
         *
         *
         *
         * SELECT * FROM `date` WHERE `fechaInicial` = '2021-11-09' AND
         * `fechaFin` = '2021-11-30' LIMIT 0 , 30
         *
         *
         *
         */
        Util.getCurrentDateToString();

        this.cities = null;

        String sql = "SELECT * FROM  date WHERE  `fechaInicial` =  '2021-11-09' AND  `fechaFin` =  '2021-11-30'";
        sql = "SELECT fechainicial, fechaFin FROM date where fechainicial between ? and ?";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            ps = conn.prepareStatement(sql);

//            ps.setShort(1, Core.getCurrentDateToString());
//            ps.setShort(2, Core.getCurrentDateToString());
            while (rs.next()) {
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
            }

            rs = ps.executeQuery();

        } catch (SQLException ex) {
            System.out.print("Exception: " + ex);
        }

        return this.cities;
    }

    public List<City> loadCitiesFromBaseAknowledge() {

        this.cities = null;

        List<City> citys;
        String sqI = "SELECT * FROM city";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            ps = conn.prepareStatement(sqI);
            rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("Id: " + rs.getInt(1));
                System.out.println("City: " + rs.getObject("object"));
            }

        } catch (SQLException sqle) {
            System.out.print(sqle.getCause());
        }

        return cities;
    }

    /**
     *
     * This method find the trends on database save
     *
     **
     */
    protected void loadTrendsByCity(City city) {
    }

    protected void loadTrensByDepartment(List<City> department) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM department";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("Id: " + rs.getInt(1));
                System.out.println("City: " + rs.getObject("name"));
                System.out.println("Ubicacion: " + rs.getString("ubicacion"));
                System.out.println("Ciudades: " + rs.getString("cities"));
                System.out.println("Tendencias: " + rs.getObject("trends"));
                System.out.println("Habitantes: " + rs.getInt("habitantes"));
            }

        } catch (Exception ex) {
            Logger.getLogger(CityDao.class.getName()).log(Level.SEVERE, null, ex.getCause());
        }
    }

    public void createTrendByCity(City city) {
        String sql = "";
        PreparedStatement ps = null;

        try {

            sql = "INSERT INTO ciudad "
                    + "(nombre, capital, ubicacion, fecha, temperatura, departamento, trends, altitud, area, habitantes) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);

            ps.setString(1, city.getNombre());
            ps.setObject(2, city.getCapital());
            ps.setString(3, city.getLocation());
            ps.setDate(4, city.getFecha());
            ps.setInt(5, city.getTemperatura());
            ps.setString(6, city.getDepartamento());
            ps.setObject(7, city.getTrends());
            ps.setInt(8, city.getAltitud());
            ps.setFloat(9, city.getArea());
            ps.setInt(10, city.getHabitantes());

            ps.executeUpdate();

        } catch (SQLException e) {
            Logger.getLogger(CityDao.class.getName()).log(Level.SEVERE, null, e.getErrorCode());
        }
    }

    public static void test(String[] args) {
        Connection conn = null;
        int rowupdate = 0;
        PreparedStatement ps = null;
        //String sql = "UPDATE ciudad SET name=? WHERE name=?";
        String sql = "INSERT INTO city (object) VALUES (?)";

        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:8888/cubetrendstestshema");

            ps = conn.prepareStatement(sql);


            City city = new City();
            city.setNombre("nombre de ciudad test");

            ps.setObject(1, city);
            // ps.setString(2, "datatest");
            ps.executeUpdate();
        } catch (SQLException exception) {
            Logger.getLogger(CityDao.class.getName()).log(Level.SEVERE, null, exception.getErrorCode());
        } catch (ClassNotFoundException cnfe) {
            Logger.getLogger(CityDao.class.getName()).log(Level.SEVERE, null, cnfe.getCause());
        }
    }
}
