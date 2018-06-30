package dbexemple;


import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.assertNotNull;

public class ConnDBTest {
    ConnH2DB dbTest = new ConnH2DB();
    @Before
    public void testGetINSTANCE() throws Exception {
        assertNotNull(dbTest.getINSTANCE());

    }

    @After
    public void testCloseDB(){
        dbTest.closeDB();
    }
}