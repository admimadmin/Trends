/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mokitotest;

import dao.CountryDaoImpl;
import domain.Country;
import domain.Department;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import lib.MysqlService;
import org.junit.Before;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 *
 * @author IEUser
 */
public class MokitoTest extends TestCase {

    @Mock
    Connection connection;

    @Mock
    ResultSet resultSet;

    @Mock
    PreparedStatement preparedStatement;

    private Country country;
    private CountryDaoImpl daoImpl;

    //private MysqlService mysqlService;
    @Before
    public void setup() {

        initMocks(this);

        when(MysqlService.getConnectionShema()).thenReturn(connection);

        daoImpl = mock(CountryDaoImpl.class);

        List<Country> arr = new ArrayList<Country>();
        when(daoImpl.listCountry()).thenReturn(arr);

        verify(daoImpl).listCountry();

    }
}
