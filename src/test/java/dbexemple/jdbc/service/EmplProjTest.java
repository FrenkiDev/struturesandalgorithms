package dbexemple.jdbc.service;

import dbexemple.jdbc.connectiondatabase.ConnH2DB;
import dbexemple.jdbc.dao.ImplProjectDAO;
import dbexemple.jdbc.entity.ImplProj;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmplProjTest {
    public static ImplProjectDAO impProjService;
    static ConnH2DB conn = new ConnH2DB();

    @BeforeClass
    public static void testName() {
        impProjService = new ImplProjService(conn.getINSTANCE());
    }

    @AfterClass
    public static void close() throws Exception {
        // testRemove();
        conn.closeDB();
    }

    @Test
    public void testAdd() throws Exception {
        ImplProj implproj = new ImplProj();

        implproj.setEmployeeId(1L);
        implproj.setProjectId(1L);

        boolean result = impProjService.add(implproj);
        Assert.assertTrue(result);
    }

    @Test
    public void testGetAll() throws Exception {
        Assert.assertNotNull(impProjService.getAll());
    }

    @Test
    public void testGetById() throws Exception {
        Assert.assertNotNull(impProjService.getByEmpoloyeeIdAndProjectId(1L, 1L));
    }

    @Test
    public void testUpdate() throws Exception {
        ImplProj implproj = new ImplProj();

        implproj.setEmployeeId(1L);
        implproj.setProjectId(1L);

        ImplProj upImplproj = new ImplProj();

        upImplproj.setEmployeeId(3L);
        upImplproj.setProjectId(2L);

        impProjService.update(implproj, upImplproj);
        ImplProj upAddress = impProjService.getByEmpoloyeeIdAndProjectId(upImplproj.getEmployeeId(), upImplproj.getProjectId());
        Long upAddressEmployeeId = upAddress.getEmployeeId();

        Assert.assertEquals(upImplproj.getEmployeeId(), upAddressEmployeeId);
    }

    public static void testRemove() throws Exception {
        ImplProj tmpImpProj = new ImplProj();
        tmpImpProj.setEmployeeId(3L);
        tmpImpProj.setProjectId(2L);
        Assert.assertTrue(impProjService.remove(tmpImpProj));
    }
}
