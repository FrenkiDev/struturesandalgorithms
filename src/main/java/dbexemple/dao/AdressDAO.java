package dbexemple.dao;

import dbexemple.entity.Address;

import java.util.List;

public interface AdressDAO {
    //create
    void add(Address adreess);

    //read
    List<Address> getAll();

    Address getById(Long id);

    //update
    void update(Address address);

    //delete
    void remove(Address address);
}
