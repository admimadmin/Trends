package dao;

import domain.City;

/**
 *
 * @author Johans Caicedo
 */
class CityDao {

    protected CityDaoImpl cityDaoImpl;

    public CityDao() {
        cityDaoImpl = new CityDaoImpl();
    }

    public void insertCity(City c) {
        cityDaoImpl.insertCity(c);
    }

    public void deleteCity(City c) {
        cityDaoImpl.deleteCity(c);
    }

    public void updateCity(City c) {
        cityDaoImpl.updateCity(c);
    }

    public void listCity() {
        cityDaoImpl.listCity();
    }

    public void findCity(City c) {
        cityDaoImpl.findCity(c);
    }
}
