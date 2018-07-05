package dbexemple.jdbc.service;

import dbexemple.Logers;
import dbexemple.jdbc.dao.AdressDAO;
import dbexemple.jdbc.entity.Address;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressService implements AdressDAO {
    private Connection connection;

    public AddressService(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean add(Address addreess){
        String sql = "INSERT INTO ADDRESS (ID, COUNTRY, CITY, STREET, POST_CODE) VALUES(?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setLong(1, addreess.getId());
            preparedStatement.setString(2, addreess.getCountry());
            preparedStatement.setString(3, addreess.getCity());
            preparedStatement.setString(4, addreess.getStreet());
            preparedStatement.setString(5, addreess.getPostCode());

            preparedStatement.executeUpdate();
            Logers.addPASS(addreess.toString());
            return true;
        } catch (SQLException ex) {
            Logers.addFALSE(addreess.toString(), ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Address> getAll() {
        List<Address> addressList;

        String sql = "SELECT id, country, city, street, post_code FROM address";

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
    public Address getById(Long id) {
        Address address = null;
        String sql ="SELECT id, country, city, street, post_code FROM address WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            address = getAddress(resultSet);
            Logers.getByIdPASS(id.toString(), address.toString());
        }catch (SQLException ex){
            Logers.getByIdFAIL(id.toString(), ex.getMessage());
        }
        return address;
    }

    @Override
    public boolean update(Address address) {
        boolean result = true;
        String sql = "UPDATE ADDRESS SET COUNTRY = ?, CITY = ?, STREET = ?, POST_CODE = ? WHERE ID = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, address.getCountry());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getStreet());
            preparedStatement.setString(4, address.getPostCode());
            preparedStatement.setLong(5, address.getId());

            preparedStatement.executeUpdate();
            Logers.updatePASS(address.toString());
        }catch (SQLException ex){
            Logers.updateFAIL(address.toString(), ex.getMessage());
            result = false;
        }
        return result;
    }

    @Override
    public boolean remove(Address address) {
        String sql = "DELETE FROM ADDRESS WHERE id = ?";
        boolean result = true;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, address.getId());
            preparedStatement.executeUpdate();
            Logers.removeRASS(address.toString());
        }catch (SQLException ex){
            Logers.removeFAIL(address.toString(), ex.getMessage());
            result = false;
        }
        return result;
    }

    private List<Address> filingAddresList(ResultSet resultSet) throws SQLException {
        List<Address> addressList = new ArrayList<>();

        while (resultSet.next()){
            Address tmpAddress = getAddress(resultSet);
            addressList.add(tmpAddress);
        }
        return addressList;
    }

    private Address getAddress(ResultSet resultSet) throws SQLException {
        Address tmpAddress = new Address();

        tmpAddress.setId(resultSet.getLong("id"));
        tmpAddress.setCountry(resultSet.getString("country"));
        tmpAddress.setCity(resultSet.getString("city"));
        tmpAddress.setStreet(resultSet.getString("street"));
        tmpAddress.setPostCode(resultSet.getString("post_code"));
        return tmpAddress;
    }
}
