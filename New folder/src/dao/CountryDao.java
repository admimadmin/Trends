package dao;

import domain.Country;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Johans Caicedo
 */
class CountryDao {

    protected CountryDaoImpl countryDaoImpl;
    protected static Connection conn;

    public CountryDao() {
        countryDaoImpl = new CountryDaoImpl();
    }

    protected static Connection getConnection() {
        try {
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:8889/cubetrendsproject",
                            "root", "root");    
            return conn;
        } catch (SQLException ex) {
            Logger.getLogger(CountryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    protected void createCountry(Country c) {
        countryDaoImpl.insertCountry(c);
    }

    protected void deleteCountry(Country c) {
        countryDaoImpl.deleteCountry(c);
    }

    protected void updateCountry(Country c) {
        countryDaoImpl.updateCountry(c);
    }

    protected List<Country> listCountry() {
        return countryDaoImpl.listCountry();
    }

    protected void findCountry(Country c) {
        //return countryDaoImpl.findCountry(c);
        countryDaoImpl.findCountry(c);
    }
}
