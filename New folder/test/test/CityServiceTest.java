/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import static junit.framework.Assert.assertNotNull;
import dao.CityDaoImpl;
import org.junit.Before;
import org.junit.Test;

public class CityServiceTest {

    protected CityDaoImpl service;

    @Before
    protected void setUp() {
        service = new CityDaoImpl("test_shema");
    }

    @Test
    protected void chechLengthRegisters() {
        assertNotNull(this.service);
    }

    @Test
    protected void createCityTest() {

    }

    @Test
    protected void listCityTest() {
        service.getCiudades();
    }
}
