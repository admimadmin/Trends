package lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

class Mysql {

    protected static Connection connection = null;

    static Connection connSimulatorShema() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cubetrendsimulator", "backmachine", "");
        } catch (SQLException ex) {
            Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, e);
        }
        return connection;
    }

    static Connection getConnObjectShema() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cubetrendsobject", "backmachine", "");
        } catch (SQLException e) {
            Logger.getLogger(MysqlService.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException cex) {
            Logger.getLogger(MysqlService.class.getName()).log(Level.SEVERE, null, cex);
        }
        return connection;
    }

    static Connection getConnShema() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cubetrendsproject", "backmachine", "");
        } catch (SQLException e) {
            Logger.getLogger(MysqlService.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException cex) {
            Logger.getLogger(MysqlService.class.getName()).log(Level.SEVERE, null, cex);
        }
        return connection;
    }

    static Connection getConnShemaTest() {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cubetrendstestshema", "backmachine", "");
        } catch (SQLException e) {
            Logger.getLogger(MysqlService.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException cex) {
            Logger.getLogger(MysqlService.class.getName()).log(Level.SEVERE, null, cex);
        }

        return connection;
    }
}
