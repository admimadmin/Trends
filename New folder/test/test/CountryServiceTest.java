package test;


import dao.CityDaoImpl;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author IEUser
 */
public class CountryServiceTest {

    protected CityDaoImpl countryService;

    public CountryServiceTest() {

    }

    @Before
    public void setUp() {
        countryService = new CityDaoImpl("test_shema");
        /*class com.mysql.jdbc.JDBC4Connection        
        assertEquals("class com.mysql.jdbc.JDBC4Connection", countryService.statusConnObject());*/
    }

    @AfterClass
    public void tearDownClass() {
        /*countryService.closeConnection();
        assertNull(countryService.getConnection());*/
    }

}
