package dbexemple.service;

import dbexemple.dao.AdressDAO;
import dbexemple.entity.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class AddressService implements AdressDAO {
    private Connection connection;

    public AddressService(Connection connection) {
        this.connection = connection;
    }
    @Override
    public void add(Address adreess) {
        PreparedStatement preparedStatement = null;

        String sql = String.format("INSERT INTO ADDRESS (ID, COUNTRY, CITY, STREET, POST_CODE) values(?, ?, ?, ?, ?)");
    }

    @Override
    public List<Address> getAll() {
        return null;
    }

    @Override
    public Address getById(Long id) {
        return null;
    }

    @Override
    public void update(Address address) {

    }

    @Override
    public void remove(Address address) {

    }
}
