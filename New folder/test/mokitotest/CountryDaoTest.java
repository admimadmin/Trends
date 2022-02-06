package mokitotest;

import dao.CountryDaoImpl;
import domain.Country;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


/**
 *
 * @author IEUser
 */
public class CountryDaoTest {

    @Mock
    Connection connection;

    @Mock
    ResultSet resultSet;

    @Mock
    PreparedStatement preparedStatement;

    private Country country;
    private CountryDaoImpl dao;

    @Before
    public void setup() {
        dao = new CountryDaoImpl();
        initMocks(this);

    }

    @Test
    private void testListCountry() {
        List<Country> arr = new ArrayList<Country>();
        when(dao.listCountry()).thenReturn(arr);
    }

    @Test
    private void testDontFoundId(){
        dao.deleteCountry(country);
        List<Country> ls = dao.findCountryById(0);
        assertEquals(0, ls.size());
    }
    
    @Test   
    public void tetsConnection(){            
       // CountryDaoImpl.getconnection();        
    }
}
