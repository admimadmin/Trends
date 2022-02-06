/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import dao.CitizenDaoImpl;
import domain.Citizen;

/**
 *
 * @author macmini
 */
class CityzenCore extends Service implements Runnable {

    protected CitizenDaoImpl dao;

    public void init() {
        dao = new CitizenDaoImpl();
    }

    public void createCitizen(Citizen citizen) {
        dao.insertCitizen(citizen);
    } 
}