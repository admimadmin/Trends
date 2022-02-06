package simulation;

import dao.CityDaoImpl;
import domain.City;
import domain.Trend;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Johans Caicedo
 */
public class CitySimulator extends Simulator {

    protected Connection connection;

    public CitySimulator() {
        connection = getConnection();
    }

    /**
     * *
     *
     *
     *
     *
     *
     * @param size
     * @return *
     */
    public static List<City> buildMultipleCity(int size) {

        List<City> cities = new ArrayList<City>();
        City city = buildCityObject();

        for (int i = 0; i < 10; i++) {
            cities.add(city);
        }
        return cities;
    }

    /**
     * *
     * @return <h4>City: The values by default set are:</h4>
     * <h5>Nombre: Nombre de ciudad test: </h5>
     * <h5>Location: Ubicacion de ciudad test: </h5>
     * <h5>Fecha: new Date() java.sql.Date  </h5>
     * <h5>Temperatura: 25  </h5>
     * <h5>Departamento: Departamento test:  </h5>
     * <h5>Trends: List<Trend> size(n=userinput)</h5>
     * <h5>Altitud: 120 </h5>
     * <h5>Area: 500000 </h5>
     * <h5>Habitantes: 2500000 </h5>
     *
     * @abstract
     *
     *
     */
    public static City buildCityObject() {
        List<Trend> trends = TrendSimulator.buildMultipleTrends(1000);

        City city = new City();
        city.setNombre("Nombre de ciudad test: ");
        city.setLocation("Ubicacion de ciudad test: ");
        city.setFecha(new Date(10));
        city.setTemperatura(25);
        city.setDepartamento("Departamento test: ");
        city.setTrends(trends);
        city.setAltitud(120);
        city.setArea(500000);
        city.setHabitantes(2500000);

        City capital = new City();
        capital.setNombre("capital de: " + city.toString());
        capital.setLocation("Ubicacion de capital test: ");
        capital.setFecha(new Date(10));
        capital.setTemperatura(25);
        capital.setDepartamento("Departamento capital: ");
        capital.setTrends(trends);
        capital.setAltitud(120);
        capital.setArea(500000);
        capital.setHabitantes(2500000);

        city.setCapital(capital);
        capital.setCapital(capital); // The current object is the same capital, 
        //then is capital

        return city;
    }

    public void multipleInsert(int cnt, City obj) throws
            ClassNotFoundException {

        try {
            PreparedStatement pstmt = connection.prepareStatement("INSER INTO ciudad ");
            for (int i = 0; i <= cnt; i++) {
                pstmt.setObject(1, obj);
                pstmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CityDaoImpl.class.getName()).log(Level.SEVERE, null,
                    ex.getCause());
        }
    }
}
