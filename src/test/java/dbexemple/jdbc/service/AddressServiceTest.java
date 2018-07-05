package dbexemple.jdbc.service;


import dbexemple.jdbc.connectiondatabase.ConnH2DB;
import dbexemple.jdbc.dao.AdressDAO;
import dbexemple.jdbc.entity.Address;
import org.junit.*;

public class AddressServiceTest{
    public static AdressDAO addressService;
    static ConnH2DB conn = new ConnH2DB();

    @BeforeClass
    public static void testName() {
        addressService = new AddressService(conn.getINSTANCE());
    }

    @AfterClass
    public static void close() throws Exception {
       // testRemove();
        conn.closeDB();
    }

    @Test
    public void testAdd() throws Exception {
        Address address = new Address();

        address.setId(1L);
        address.setCountry("RF");
        address.setCity("Moskow");
        address.setStreet("Mira");
        address.setPostCode("12345");

        boolean result = addressService.add(address);
        Assert.assertTrue(result);
    }

    @Test
    public void testGetAll() throws Exception {
        Assert.assertNotNull(addressService.getAll());
    }

    @Test
    public void testGetById() throws Exception {
        Assert.assertNotNull(addressService.getById(1L));
    }

    @Test
    public void testUpdate() throws Exception {
        Address address = new Address();

        address.setId(1L);
        address.setCountry("RF");
        address.setCity("Novograd");
        address.setStreet("Mira");
        address.setPostCode("54321");

        addressService.update(address);
        Address upAddress = addressService.getById(address.getId());
        String upCityAddress = upAddress.getCity();

        Assert.assertEquals(address.getCity(), upCityAddress);
    }

    public static void testRemove() throws Exception {
        Address tmpAddress = new Address();
        tmpAddress.setId(1L);
        Assert.assertTrue(addressService.remove(tmpAddress));
    }
}