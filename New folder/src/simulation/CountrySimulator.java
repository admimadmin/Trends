package simulation;

import domain.Country;
import domain.Trend;
import java.util.List;

/**
 *
 * @author macmini
 */
public class CountrySimulator {

    protected static List<Trend> trends;

    protected static void init() {
        trends = TrendSimulator.buildMultipleTrends(100);
    }

    public List<Country> buildMultipleCountry() {
        return null;
    }

    public static Country buildCountry() {

        init();

        Country country = new Country();
        country.setAltitud(15000);
        country.setArea(1000000);
        country.setCapital("Capital");
        country.setTemperatura(20);
        country.setLocation(1);
        country.setTrends(trends);
        country.setNombre("Colombia");
        country.setHabitantes(1000000);
        return country;
    }
}
