package dbexemple;


import dbexemple.jdbc.connectiondatabase.ConnH2DB;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import static org.junit.Assert.assertNotNull;

public class  ConnDBTest {
    public static ConnH2DB dbTest = new ConnH2DB();
    @BeforeClass
    public static void testGetINSTANCE() throws Exception {
        assertNotNull(dbTest.getINSTANCE());

    }

    @AfterClass
    public static void testCloseDB(){
        dbTest.closeDB();
    }
}