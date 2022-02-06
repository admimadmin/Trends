/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Trend;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lib.MysqlService;
import simulation.TrendSimulator;

/**
 *
 * @author macmini
 */
public class TrendDaoImpl {

    protected static List<Trend> trends;
    protected MysqlService mysqlService;
    protected Connection conn;

    public TrendDaoImpl(String shema) {
        //mysqlService = new MysqlService();
        // conn = MysqlService.connToDatabase(shema);
    }

    protected List<Object> seIectTrendRegisters() {

        String sql = "SELECT * FROM Trend";
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Object> results = new ArrayList<Object>();

        try {

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                results.add((Trend) rs.getObject("trend"));
            }

        } catch (Exception e) {

            System.out.print("Error_ " + e);
        }
        return results;
    }

    protected void mutipleTrendInsert(int cnt, List<Trend> trends) {
        try {

            PreparedStatement ps = conn
                    .prepareStatement("INSERT INTO Trend (trend) values(?)");
            Trend trend = new Trend();

            for (int i = 0; i <= cnt; i++) {

                ps.setObject(1, trend);
                ps.executeUpdate();
            }
        } catch (SQLException sqle) {

            System.out.println("Err on method mutiple insert :" + sqle.getSQLState());
        }
    }

    public static void main(String[] args) {

        Trend trend = TrendSimulator.buildTrendObject();
        List<Object> registers = new ArrayList<Object>();

        TrendDaoImpl service = new TrendDaoImpl("relational_shema");
        //service.createTrend(trend);
        //service.deleteTrend(trend);
        //service.listTrends();
        //service.findTrend(trend);
        service.updateTrend(trend);
        /**
         * 
         * registers = service.seIectTrendRegisters();
        
        System.out.println(registers);
         * 
         * 
         * Subroutine to insert multiple registers with fail handler
         **/
        //service.mutipleTrendInsert(100000, null);
    }

    void createTrend(Trend trend) {
        System.out.println("Insert Trend: " + TrendDaoImpl.class.getSimpleName());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:8889/cubetrendsproject",
                    "root", "root");

            PreparedStatement ps;
            ps = connection.prepareStatement("INSERT INTO trend (ubicacion, inicio,"
                    + " finalizacion, intervalo, busqueda, categoria, tipoBusqueda,"
                    + " incXdia, incXsemana, incXintervalo) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            ps.setString(1, trend.getUbicacion());
            ps.setInt(2, trend.getInicio());
            ps.setInt(3, trend.getTermino());
            ps.setInt(4, trend.getIntervako());
            ps.setString(5, trend.getBusqueda());
            ps.setString(6, "fdsfsd");
            ps.setString(7, "ssfsd");
            ps.setInt(8, trend.getIncXdia());
            ps.setInt(9, trend.getIncXSemana());
            ps.setInt(10, trend.getIncXintervalo());

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CityDaoImpl.class.getName())
                    .log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException cnfe) {
            Logger.getLogger(CityDaoImpl.class.getName())
                    .log(Level.SEVERE, null,
                    cnfe);
        }
    }

    void deleteTrend(Trend trend) {

        System.out.println("Delete trend: " + CityDaoImpl.class.getSimpleName());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:8889/cubetrendsproject",
                    "root", "root");

            PreparedStatement ps;
            ps = connection.prepareStatement("DELETE FROM trend WHERE id=?");

            ps.setInt(1, 1);
            
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CityDaoImpl.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException cnfe) {
            Logger.getLogger(CityDaoImpl.class.getName()).log(Level.SEVERE, null,
                    cnfe);
        }
    }

    void listTrends() {

        System.out.println("List trend: " + TrendDaoImpl.class.getSimpleName());


        try {
            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:8889/cubetrendsproject",
                            "root", "root");

            PreparedStatement ps;
            ps = connection.prepareStatement("SELECT * FROM trend");
            ResultSet rs = null;

            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Ubicacion: " + rs.getString(2));
            }


        } catch (Exception ex) {
            Logger.getLogger(CitizenDaoImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    void findTrend(Trend trend) {

        System.out.println("Find trend: " + TrendDaoImpl.class.getSimpleName());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:8889/cubetrendsproject",
                            "root", "root");

            PreparedStatement ps = connection.
                    prepareStatement("SELECT * FROM trend WHERE id=?");
            ps.setInt(1, 2);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Ubicacion: " + rs.getString(2));                
            }

        } catch (Exception ex) {
        }
    }

    void updateTrend(Trend t) {
        
         System.out.println("Update citizen: " + TrendDao.class.getSimpleName());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:8889/cubetrendsproject",
                            "root", "root");
            PreparedStatement ps;
            ps = connection.
                    prepareStatement("UPDATE trend set intervalo=? WHERE id=?");

            ps.setInt(1, 20);
            ps.setInt(2, 2);

            ps.executeUpdate();

        } catch (SQLException sqle) {
            
        } catch (ClassNotFoundException cnfe) {
            
        }
    }
}
