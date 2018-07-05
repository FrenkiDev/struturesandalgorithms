package dbexemple.jdbc.dao;

import dbexemple.jdbc.entity.Address;

import java.util.List;

public interface AdressDAO {
    //create
    boolean add(Address adreess);

    //read
    List<Address> getAll();

    Address getById(Long id);

    //update
    boolean update(Address address);

    //delete
    boolean remove(Address address);
}
