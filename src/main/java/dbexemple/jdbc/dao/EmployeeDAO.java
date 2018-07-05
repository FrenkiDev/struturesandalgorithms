package dbexemple.jdbc.dao;

import dbexemple.jdbc.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    //create
    boolean add(Employee employee);

    //read
    List<Employee> getAll();

    Employee getById(Long id);

    //update
    boolean update(Employee employee);

    //delete
    boolean remove(Employee employee);
}
