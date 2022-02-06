package dao;

import domain.Department;
import java.util.List;

/**
 * Department service hierarchy of department simulator because the CRUD
 * "structured query language SQL" query are not native in the requirement
 *
 * @author macmini
 */
class DepartmentDao {

    protected DepartmentDaoImpl departmentDaoImpl;

    public DepartmentDao() {
        departmentDaoImpl = new DepartmentDaoImpl();
    }

    public void createDepartment(Department c) {
        departmentDaoImpl.insertDepartment(c);
    }

    public void deleteDepartment(Department c) {
        departmentDaoImpl.deleteDepartment(c);
    }

    public void updateDepartment(Department c) {
        departmentDaoImpl.updateDepartment(c);
    }

    public List<Department> listDepartment() {
        return departmentDaoImpl.listDepartments();
    }

    public void findDepartment(Department c) {
        departmentDaoImpl.findDepartment(c);
    }
}
