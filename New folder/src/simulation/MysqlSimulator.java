package simulation;

import domain.City;
import domain.Department;
import java.io.IOException;
import dao.CityDaoImpl;
import dao.DepartmentDaoImpl;
import lib.Util;

public class MysqlSimulator {

    protected DepartmentDaoImpl departmentService;
    protected CityDaoImpl cityService;

    /**
     * Definir el tipo de dato a crear
     */
    public void run(int opt) throws IOException {
        Department department;
        City city;
        switch (opt) {
            case 1:
                System.out.println("Multiple insert running..");
                //multipleInsert(20, city, "objecttest");
                break;
            case 2:
                //departmentService = new DepartmentDao("test_shema");
                System.out.println("Create trend by department: ");

                department = Util.createTrendByDepartment();
               // departmentService.createTrendByDepartment(department);
                break;
            case 3:
                cityService = new CityDaoImpl("test_shema");
                System.out.println("Created trend by city: ");
                city = Util.createTrendByCity();

                cityService.createTrendByCity(city);
            default:
                throw new IOException();
        }
    }

}
