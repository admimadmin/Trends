package dao;

import domain.Department;
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
 * @author macmini
 */
public class DepartmentDaoImpl {

    protected Connection connection;

    protected void insertDepartment(Department department) {
        System.out.println("Insert citizen: " + CitizenDaoImpl.class.getSimpleName());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:8889/cubetrendsproject",
                            "root", "root");

            /**
             * *
             * id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY , `name` VARCHAR( 50
             * ) NOT NULL , `ubicacion` VARCHAR( 50 ) NOT NULL , `cities` BLOB
             * NOT NULL , `trends` BLOB NOT NULL , `habitantes` INT NOT NULL
             *
             *
             */
            PreparedStatement ps;
            ps = connection.prepareStatement("INSERT INTO department "
                    + "(name, ubicacion, cities, trends, habitantes)"
                    + " VALUES (?, ?, ?, ? ,?)");

            ps.setString(1, department.getName());
            ps.setString(2, department.getUbicacion());
            ps.setObject(3, department.getCities());
            ps.setObject(5, department.getTrends());
            ps.setInt(4, department.getHabitantes());

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDaoImpl.class.getName()).log(Level.SEVERE,
                    null, ex);
        } catch (ClassNotFoundException cnfe) {
            Logger.getLogger(DepartmentDaoImpl.class.getName()).log(Level.SEVERE,
                    null, cnfe);
        }
    }

    public void deleteDepartment(Department department) {
        System.out.println("Delete citizen: " + DepartmentDaoImpl.class.getSimpleName());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:8889/cubetrendsproject",
                            "root", "root");
            PreparedStatement ps;
            ps = connection.prepareStatement("DELETE FROM department WHERE id=?");
            ps.setInt(1, 1);

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DepartmentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void updateDepartment(Department department) {
        System.out.println("Update citizen: " + CitizenDaoImpl.class.getSimpleName());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:8889/cubetrendsproject",
                            "root", "root");
            PreparedStatement ps;
            ps = connection.
                    prepareStatement("UPDATE citizen set edad=? WHERE id=?");

            ps.setInt(1, 20);
            ps.setInt(2, 2);

            ps.executeUpdate();

        } catch (SQLException sqle) {
        } catch (ClassNotFoundException cnfe) {
        }
    }

    public void findDepartment(Department department) {
        System.out.println("Find department: " + DepartmentDaoImpl.class.getSimpleName());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:8889/cubetrendsproject",
                            "root", "root");

            PreparedStatement ps = connection
                    .prepareStatement("SELECT * FROM department WHERE edad=?");
            ps.setInt(1, 20);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("Edad: " + rs.getInt(2));
            }
        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DepartmentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Department> listDepartments() {
        List<Department> departments = new ArrayList<Department>();

        System.out.println("List department: " + DepartmentDaoImpl.class.getSimpleName());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:8889/cubetrendsproject",
                            "root", "root");

            PreparedStatement ps = connection
                    .prepareStatement("SELECT * FROM department");

            ResultSet rs = ps.executeQuery();

            Department department = new Department();

            while (rs.next()) {
                department.setName(rs.getString("nombre"));
                department.setUbicacion(rs.getString("ubicacion"));
                department.setHabitantes(rs.getInt("habitantes"));
                //System.out.println("Nombre: " +rs.getString(2));
                //System.out.println("Ubicacion: " + rs.getString(3));
                departments.add(department);
            }

        } catch (ClassNotFoundException ex) {

        } catch (SQLException ex) {
        }
        return departments;
    }

    public void listCitizenByDepartment() {
        System.out.println("List department: " + CitizenDaoImpl.class.getSimpleName());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:8889/cubetrendsproject",
                            "root", "root");

            PreparedStatement ps = connection
                    .prepareStatement("SELECT * FROM department WHERE ");
            ps.setInt(1, 20);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println("Edad: " + rs.getInt(2));
                System.out.println("Nombre: " + rs.getString(4));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DepartmentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     *
     *
     *
     * //departmentService.multipleDepartmentInsert(100, "amazonas");
     * //departmentService.loadDepartments(); // List<Object> departments =
     * departmentService.getDepartments(); //
     * System.out.println(departments.toString()); // // List< Object> cities =
     * new ArrayList<Object>(); // cities = departmentService.listDepartments();
     * // for (int i = 0; i < cities.size(); i++) { // City object = (City)
     * cities.get(i); System.out.println(object.toString());
     */
    /**
     * * }
     *
     * SQL query definition:
     *
     * INSERT INTO departament (name, ubicacion, cities, trends, habitantes) " +
     * " VALUES (?,?,?,?,?)
     *
     * "DELETE FROM `ciudad` WHERE `ciudad`.`id` = 4"?
     *
     *
     *
     * protected static String INSERT_DEPARTMENT = "INSERT INTO" +
     * Contants.DEPARTMENT_TABlE_NAME + "(name, ubicacion, cities, trends,
     * habitantes) VALUES (?,?,?,?,?)"; protected static String
     * DELETE_DEPARTMENT = "DELETE FROM" + Contants.DEPARTMENT_TABlE_NAME +
     * "WHERE" + "id=?"; protected static String UPDATE_DEPARTMENT = "";
     * protected static String FIND_DEPARTMENT = ""; protected static String
     * LIST_DEPARTMENT = ""; protected static final String
     * SQL_DESERIALIZE_OBJECT = "SELECT object FROM department WHERE id=?";
     * protected static final String SELECT_DEPARTMENTS = "SELECT * FROM
     * department"; protected static final String SELECT_CITIES = "SELECT * FROM
     * cities WHERE department =?"; protected static String sql; protected
     * ResultSet rs; protected PreparedStatement pstmtStatic; protected
     * List<Object> departments; protected static List<Object> dptos_stic_lst;
     * protected static Connection conn; protected MysqlService mysqlService;
     *
     * public void createTrendByDepartment(Department department) {
     *
     * try {
     *
     * //PreparedStatement pstmtStatic = null; pstmtStatic =
     * conn.prepareStatement("INSERT INTO departament (name, ubicacion, cities,
     * trends, habitantes) " + "VALUES (?,?,?,?,?)");
     *
     * pstmtStatic.setString(1, department.getName()); pstmtStatic.setString(2,
     * department.getUbicacion()); pstmtStatic.setObject(3,
     * department.getCities()); pstmtStatic.setObject(4,
     * department.getTrends()); pstmtStatic.setInt(5,
     * department.getHabitantes());
     *
     * pstmtStatic.executeUpdate();
     *
     * } catch (SQLException sqle) {
     * Logger.getLogger(DepartmentDao.class.getName()).log(Level.SEVERE, null,
     * sqle); } }
     *
     * public List<Trend> findTrendByDepartment(String department) {
     *
     * List<Trend> trends = null;
     *
     * return trends; }
     *
     * /**
     * *
     *
     * By default the connection is front database shema relational.
     *
     * /
     * public void DepartmentService() { mysqlService = new MysqlService();
     * //conn = mysqlService.conn; }
     *
     * public DepartmentDao(String shema) { conn =
     * MysqlService.connToDatabase(shema); }
     *
     * public Connection getConnection() { return conn; }
     *
     * public List<Object> getDepartments() { return this.departments; }
     *
     * public void createDepartment(Department department) {
     *
     * String sql = "INSERT INTO departament (name, ubicacion, cities, trends,
     * habitantes) " + "VALUES (?,?,?,?,?)";
     *
     * try { Class.forName("com.mysql.jdbc.Driver"); conn =
     * DriverManager.getConnection("jdbc:mysql://localhost:3306/cubetrendsproject",
     * "backmachine", ""); pstmtStatic = conn.prepareStatement(sql);
     * pstmtStatic.setString(1, department.getName()); pstmtStatic.setString(2,
     * department.getUbicacion()); pstmtStatic.setObject(3,
     * department.getCities()); pstmtStatic.setObject(4,
     * department.getTrends()); pstmtStatic.setInt(5,
     * department.getHabitantes());
     *
     * pstmtStatic.executeUpdate();
     *
     * } catch (SQLException ex) {
     * Logger.getLogger(DepartmentDao.class.getName()).log(Level.SEVERE, null,
     * ex.getErrorCode()); } catch (ClassNotFoundException ex) {
     * Logger.getLogger(DepartmentDao.class.getName()).log(Level.SEVERE, null,
     * ex); } }
     *
     * protected List<Object> findCitiesByDepartment(String departamento) {
     *
     * List<Object> cities = new ArrayList<Object>(); String sql = "SELECT *
     * FROM city"; rs = null; pstmtStatic = null;
     *
     * try {
     *
     * departments = new ArrayList<Object>(); pstmtStatic =
     * conn.prepareStatement(sql); rs = pstmtStatic.executeQuery(); while
     * (rs.next()) { cities.add(rs.getObject("object")); }
     *
     * } catch (SQLException e) { System.out.println("Eror: " + e); }
     *
     * return cities; }
     *
     * protected List<Object> showDepartments() {
     *
     * List<Object> result = new ArrayList<Object>();
     *
     * try {
     *
     * pstmtStatic = conn.prepareStatement(sql); rs =
     * pstmtStatic.executeQuery(); while (rs.next()) {
     * result.add(rs.getObject("department")); }
     *
     * } catch (SQLException ex) {
     * Logger.getLogger(DepartmentDao.class.getName()).log(Level.SEVERE, null,
     * ex.getErrorCode()); }
     *
     * return result; }
     *
     * public static void test(String[] args) { Department department =
     * DepartmentSimulator.buildDepartmentObject(); DepartmentDao
     * departmentService = new DepartmentDao("relational_shema");
     *
     * //departmentService.createTrendByDepartment(department);
     * //departmentService.createDepartment(department);
     * //departmentService.multipleDepartmentInsert(100, department); } / }
     */
}
