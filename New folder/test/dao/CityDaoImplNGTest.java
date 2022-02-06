/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.City;
import java.util.Date;
import java.util.List;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author IEUser
 */
public class CityDaoImplNGTest {
    
    public CityDaoImplNGTest() {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    /**
     * Test of main method, of class CityDaoImpl.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        CityDaoImpl.main(args);
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertCity method, of class CityDaoImpl.
     */
    @Test
    public void testInsertCity() {
        System.out.println("insertCity");
        City city = null;
        CityDaoImpl instance = new CityDaoImpl();
        instance.insertCity(city);
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCity method, of class CityDaoImpl.
     */
    @Test
    public void testDeleteCity() {
        System.out.println("deleteCity");
        City City = null;
        CityDaoImpl instance = new CityDaoImpl();
        instance.deleteCity(City);
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCity method, of class CityDaoImpl.
     */
    @Test
    public void testUpdateCity() {
        System.out.println("updateCity");
        City City = null;
        CityDaoImpl instance = new CityDaoImpl();
        instance.updateCity(City);
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCity method, of class CityDaoImpl.
     */
    @Test
    public void testFindCity() {
        System.out.println("findCity");
        City City = null;
        CityDaoImpl instance = new CityDaoImpl();
        instance.findCity(City);
        fail("The test case is a prototype.");
    }

    /**
     * Test of listCity method, of class CityDaoImpl.
     */
    @Test
    public void testListCity() {
        System.out.println("listCity");
        CityDaoImpl instance = new CityDaoImpl();
        instance.listCity();
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCiudades method, of class CityDaoImpl.
     */
    @Test
    public void testGetCiudades() {
        System.out.println("getCiudades");
        CityDaoImpl instance = new CityDaoImpl();
        List expResult = null;
        List result = instance.getCiudades();
        assertEquals(result, expResult);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCiudades method, of class CityDaoImpl.
     */
    @Test
    public void testSetCiudades() {
        System.out.println("setCiudades");
        List<City> ciudades = null;
        CityDaoImpl instance = new CityDaoImpl();
        instance.setCiudades(ciudades);
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadCurrentLocation method, of class CityDaoImpl.
     */
    @Test
    public void testLoadCurrentLocation() {
        System.out.println("loadCurrentLocation");
        CityDaoImpl instance = new CityDaoImpl();
        instance.loadCurrentLocation();
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadTemperatura method, of class CityDaoImpl.
     */
    @Test
    public void testLoadTemperatura() {
        System.out.println("loadTemperatura");
        CityDaoImpl instance = new CityDaoImpl();
        instance.loadTemperatura();
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadCurrentDate method, of class CityDaoImpl.
     */
    @Test
    public void testLoadCurrentDate() {
        System.out.println("loadCurrentDate");
        CityDaoImpl instance = new CityDaoImpl();
        instance.loadCurrentDate();
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadCityFromDateInterval method, of class CityDaoImpl.
     */
    @Test
    public void testLoadCityFromDateInterval() {
        System.out.println("loadCityFromDateInterval");
        Date date = null;
        CityDaoImpl instance = new CityDaoImpl();
        List expResult = null;
        List result = instance.loadCityFromDateInterval(date);
        assertEquals(result, expResult);
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadCitiesFromBaseAknowledge method, of class CityDaoImpl.
     */
    @Test
    public void testLoadCitiesFromBaseAknowledge() {
        System.out.println("loadCitiesFromBaseAknowledge");
        CityDaoImpl instance = new CityDaoImpl();
        List expResult = null;
        List result = instance.loadCitiesFromBaseAknowledge();
        assertEquals(result, expResult);
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadTrendsByCity method, of class CityDaoImpl.
     */
    @Test
    public void testLoadTrendsByCity() {
        System.out.println("loadTrendsByCity");
        City city = null;
        CityDaoImpl instance = new CityDaoImpl();
        instance.loadTrendsByCity(city);
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadTrensByDepartment method, of class CityDaoImpl.
     */
    @Test
    public void testLoadTrensByDepartment() {
        System.out.println("loadTrensByDepartment");
        List<City> department = null;
        CityDaoImpl instance = new CityDaoImpl();
        instance.loadTrensByDepartment(department);
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTrendByCity method, of class CityDaoImpl.
     */
    @Test
    public void testCreateTrendByCity() {
        System.out.println("createTrendByCity");
        City city = null;
        CityDaoImpl instance = new CityDaoImpl();
        instance.createTrendByCity(city);
        fail("The test case is a prototype.");
    }

    /**
     * Test of test method, of class CityDaoImpl.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        String[] args = null;
        CityDaoImpl.test(args);
        fail("The test case is a prototype.");
    }
    
}
