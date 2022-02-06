package simulation;

import domain.Trend;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IEUser
 */
public class TrendSimulator {
    
    
    /****
     * 
     * 
     * @param size
     * @return List<Trend> 
     **/
    public static List<Trend> buildMultipleTrends(int size) {
        
        List<Trend> trends = new ArrayList<Trend>();
        Trend trend = buildTrendObject();
        
        for (int i = 0; i <= size; i++) {
            trend.setBusqueda(trend.getBusqueda() + i);
            trends.add(trend);
        }
        
        return trends;
    }
    
    /****
     * 
     * 
     * @return 
     ***/
    public static Trend buildTrendObject() {
        
        Trend trend = new Trend();
        trend.setBusqueda("Busqueda test");
        trend.setIncXdia(2);
        trend.setUbicacion("location test");
        trend.setTermino(2);
        trend.setInicio(2);
        trend.setIntervalo(1);
        trend.setIncXintervalo(7);
        trend.setIncXSemana(2);
        
        return trend;
    }
}
