package dbexemple;

import org.junit.Assert;
import org.junit.Test;

//@Suite.SuiteClasses(ConnDBTest.class)
public class H2dbTest extends ConnDBTest {
    @Test
    public void filingValueConnection(){
        Assert.assertEquals(dbTest.getNameDrivers(), "org.h2.Driver");
        Assert.assertEquals(dbTest.getUrl(), "jdbc:h2:~/test");
     }
}
