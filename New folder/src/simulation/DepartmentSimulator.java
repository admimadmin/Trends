package simulation;


import dao.DepartmentDaoImpl;
import lib.MysqlService;
import domain.City;
import domain.Department;
import domain.Trend;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IEUser
 */
public class DepartmentSimulator {

    protected DepartmentDaoImpl departmentService;
    protected static Connection connection;

    public DepartmentSimulator(String shema) {
        try {
            departmentService = new DepartmentDaoImpl();


            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/cubetrendsproject", "root", "root");
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentSimulator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DepartmentSimulator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void multipleDepartmentInsert(int cnt, Department departamento) {

        try {

            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO departamento (departamento) VALUES (?)");

            for (int i = 0; i <= cnt; i++) {
                pstmt.setObject(1, departamento);
                pstmt.executeUpdate();


            }

        } catch (SQLException ex) {
            Logger.getLogger(DepartmentSimulator.class.getName()).log(Level.SEVERE, null, ex.getCause());
        }
    }

    /**
     *
     **
     * @param department
     */
    public static void departmentInsert(Department department) {

        try {
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO departamento (departamento) VALUES (?)");
            pstmt.setObject(1, department);
            pstmt.executeUpdate();
            MysqlService.closeConnection(connection);


        } catch (SQLException ex) {
            Logger.getLogger(MysqlService.class.getName()).log(Level.SEVERE, null, ex.getErrorCode());
        }
    }

    protected static List<Department> listDepartments() {

        List<Department> result = new ArrayList<Department>();
        String sql = "SELECT * FROM department";
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                result.add((Department) rs.getObject("department"));
            }

            MysqlService.closeConnection(connection);
        } catch (SQLException e) {
            System.out.println("Eror: " + e);
        }

        return result;
    }

    public void updateDepartment(Department department) {
    }

    protected static Object deSerializeObjectFromDB(long serizalized_id) throws
            SQLException,
            IOException,
            ClassNotFoundException {

        PreparedStatement pstmt = connection.prepareStatement("");

        pstmt.setLong(1, serizalized_id);

        ResultSet rs = pstmt.executeQuery();
        rs.next();

        byte[] buf = rs.getBytes(1);
        ObjectInputStream objectIn = null;

        if (buf != null) {
            objectIn = new ObjectInputStream(new ByteArrayInputStream(buf));
        }

        Object deSerializedObject = objectIn.readObject();

        return deSerializedObject;
    }

    /**
     * *
     * This method build multiple department instances.
     *
     * @param size
     * @return
     *
     */
    public static List<Department> buildMultipleDepartament(int size) {
        List<Department> departments = new ArrayList();
        List<City> cities = CitySimulator.buildMultipleCity(100);
        List<Trend> trends = TrendSimulator.buildMultipleTrends(size);

        Department department = new Department();

        for (int i = 0; i < size; i++) {
            department.setName("department test #" + i);
            department.setUbicacion("department test5 #" + i);
            department.setTrends(trends);
            department.setCities(cities);
            department.setHabitantes(3000000);
            departments.add(department);
        }

        return departments;
    }

    /**
     * This method is an implementation for multiple's insert functionality,
     * using the recursive to sign the current instance create an add on the
     * List
     *
     * @param size
     * @param department
     * @return
     */
    public static List<Department> buildMultipleDepartament(int size, Department department) {
        List<Department> departments = new ArrayList();
        List<Trend> trends = TrendSimulator.buildMultipleTrends(size);

        for (int i = 0; i < size; i++) {
            department.setName("department test #" + i);
            department.setUbicacion("department test5 #" + i);
            department.setTrends(trends);
            departments.add(department);
            buildMultipleDepartament(size, department);
        }

        return departments;
    }

    public static Department buildDepartmentObject() {

        List<Trend> trends = TrendSimulator.buildMultipleTrends(1000);
        List<City> cities = CitySimulator.buildMultipleCity(1000);

        Department department = new Department();
        department.setName("nombre departamento");
        department.setTrends(trends);
        department.setUbicacion("ubicacion for department");
        department.setHabitantes(1000000);
        department.setCities(cities);

        return department;
    }

    public static void main(String[] args) {

        List<Trend> trends = new ArrayList();
        List<Department> departments = new ArrayList<Department>();

        trends = TrendSimulator.buildMultipleTrends(100);
        departments = DepartmentSimulator.buildMultipleDepartament(100);

        Department department = DepartmentSimulator.buildDepartmentObject();

        DepartmentSimulator.departmentInsert(department);
    }
}
