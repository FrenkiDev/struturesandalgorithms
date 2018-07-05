package dbexemple.jdbc.service;

import dbexemple.Logers;
import dbexemple.jdbc.dao.EmployeeDAO;
import dbexemple.jdbc.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService implements EmployeeDAO {
    private Connection connection;

    public EmployeeService(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean add(Employee employee) {
        boolean result = true;
        String sql = "INSERT INTO EMPLOYEE(ID, FIRSTNAME, LASTNAME, BIRTHDAY, ADDRESSID) VALUES(?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, employee.getId());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getLastName());
            preparedStatement.setDate(4, employee.getBirthDay());
            preparedStatement.setLong(5, employee.getAddressId());

            preparedStatement.executeUpdate();

            Logers.addPASS(employee.toString());
        } catch (SQLException ex) {
            result = false;
            Logers.addFALSE(employee.toString(), ex.getMessage());
        }
        return result;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> addressList;

        String sql = "SELECT ID, FIRSTNAME, LASTNAME, BIRTHDAY, ADDRESSID FROM EMPLOYEE";

        try(Statement streamResult = connection.createStatement()){
            ResultSet resultSet = streamResult.executeQuery(sql);
            addressList = filingAddresList(resultSet);
            Logers.getAllPASS(addressList.toString());
        } catch (SQLException ex) {
            addressList = null;
            Logers.getAllFAIL(sql, ex.getMessage());
        }
        return addressList;
    }

    @Override
    public Employee getById(Long id) {
        Employee employee = null;
        String sql = "SELECT ID, FIRSTNAME, LASTNAME, BIRTHDAY, ADDRESSID FROM EMPLOYEE WHERE ID = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            employee = getEmployee(resultSet);
            Logers.getByIdPASS(id.toString(), employee.toString());
        }catch(SQLException ex){
            Logers.getByIdFAIL(id.toString(), ex.getMessage());
        }

        return employee;
    }

    @Override
    public boolean update(Employee employee) {
        boolean result = true;
        String sql = "UPDATE EMPLOYEE SET FIRSTNAME = ?, LASTNAME = ?, BIRTHDAY = ?, ADDRESSID = ? WHERE ID = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setDate(3, employee.getBirthDay());
            preparedStatement.setLong(4, employee.getAddressId());
            preparedStatement.setLong(5, employee.getId());

            preparedStatement.executeUpdate();
            Logers.updatePASS(employee.toString());
        }catch (SQLException ex){
            Logers.updateFAIL(employee.toString(), ex.getMessage());
            result = false;
        }
        return result;
    }

    @Override
    public boolean remove(Employee employee) {
        String sql = "DELETE FROM EMPLOYEE WHERE id = ?";
        boolean result = true;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, employee.getId());
            preparedStatement.executeUpdate();
            Logers.removeRASS(employee.toString());
        }catch (SQLException ex){
            Logers.removeFAIL(employee.toString(), ex.getMessage());
            result = false;
        }
        return result;
    }

    private Employee getEmployee(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();

        employee.setId(resultSet.getLong("id"));
        employee.setFirstName(resultSet.getString("firstName"));
        employee.setLastName(resultSet.getString("lastName"));
        employee.setBirthDay(resultSet.getDate("birthDay"));
        employee.setAddressId(resultSet.getLong("addressID"));

        return employee;
    }

    private List<Employee> filingAddresList(ResultSet resultSet) throws SQLException {
        List<Employee> addressList = new ArrayList<>();

        while (resultSet.next()){
            Employee tmpAddress = getEmployee(resultSet);
            addressList.add(tmpAddress);
        }
        return addressList;
    }
}
