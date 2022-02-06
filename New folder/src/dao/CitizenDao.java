package dao;

import domain.Citizen;
import java.util.List;

/**
 *
 * @author macmini
 */
class CitizenDao {

    protected CitizenDaoImpl citizenImpl;

    public CitizenDao() {
        citizenImpl = new CitizenDaoImpl();
    }

    public void createCitizen(Citizen c) {
        citizenImpl.insertCitizen(c);
    }

    public void deleteCitizen(Citizen c) {
        citizenImpl.deleteCitizen(c);
    }

    public void updateCitizen(Citizen c) {
        citizenImpl.updateCitizen(c);
    }

    public List<Citizen> listCitizen() {
        return citizenImpl.listCitizen();
    }

    public Citizen findCitizen(int id) {
        return citizenImpl.findCitizenById(id);
    }
}
