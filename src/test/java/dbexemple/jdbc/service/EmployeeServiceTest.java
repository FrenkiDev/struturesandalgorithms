package dbexemple.jdbc.service;

import dbexemple.jdbc.connectiondatabase.ConnH2DB;
import dbexemple.jdbc.dao.EmployeeDAO;
import dbexemple.jdbc.entity.Employee;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Date;

public class EmployeeServiceTest{
    public static EmployeeDAO employeeDAO;
    static ConnH2DB conn = new ConnH2DB();

    @BeforeClass
    public static void testName() {
        employeeDAO = new EmployeeService(conn.getINSTANCE());
    }

    @AfterClass
    public static void close() throws Exception {
        testRemove();
        conn.closeDB();
    }

    @Test
    public void testAdd() throws Exception {
        Employee employee = new Employee();

        employee.setId(1L);
        employee.setFirstName("Neo");
        employee.setLastName("Zeon");
        employee.setBirthDay(new Date(12345679));
        employee.setAddressId(1L);

        boolean result = employeeDAO.add(employee);
        Assert.assertTrue(result);
    }

    @Test
    public void testGetAll() throws Exception {
        Assert.assertNotNull(employeeDAO.getAll());
    }

    @Test
    public void testGetById() throws Exception {
        Assert.assertNotNull(employeeDAO.getById(1L));
    }

    @Test
    public void testUpdate() throws Exception {
        Employee employee = new Employee();

        employee.setId(1L);
        employee.setFirstName("Smit");
        employee.setLastName("Matrix");
        employee.setBirthDay(new Date(12345679));
        employee.setAddressId(1L);

        employeeDAO.update(employee);
        Employee upAddress = employeeDAO.getById(employee.getId());
        String upFirstName = upAddress.getFirstName();

        Assert.assertEquals(employee.getFirstName(), upFirstName);
    }

    public static void testRemove() throws Exception {
        Employee tmpAddress = new Employee();
        tmpAddress.setId(1L);
        Assert.assertTrue(employeeDAO.remove(tmpAddress));
    }
}
