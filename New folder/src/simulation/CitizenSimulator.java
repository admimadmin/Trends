package simulation;

import dao.CityDaoImpl;
import domain.Citizen;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IEUser
 */
public class CitizenSimulator extends Simulator {

    protected Connection connection;

    public CitizenSimulator() {
        connection = getConnection();
    }

    public List<Citizen> builMultipleCitizen(int cnt) {
        List<Citizen> citizen_s = new ArrayList<Citizen>();
        Citizen citizen = buildCitizenObject();

        try {     
            for (int i = 0; i <= cnt; i++) {               
                citizen_s.add(citizen);                
            }
        } catch (Exception ex) {
            Logger.getLogger(CityDaoImpl.class.getName()).log(Level.SEVERE, null,
                    ex.getCause());
        }
        return citizen_s;
    }

    public Citizen buildCitizenObject() {
        Citizen citizen = new Citizen();
         citizen.setNombre("Nombre example");
        citizen.setCompensacion("caja compensacion familiar");
        citizen.setEdad(50);
        citizen.setEmpleo("empleo test 1");
        citizen.setEps("EPS familiar");
        citizen.setSexo("hombre");
        return citizen;
    }
}
