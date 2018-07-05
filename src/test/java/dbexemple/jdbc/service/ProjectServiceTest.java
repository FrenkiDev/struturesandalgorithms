package dbexemple.jdbc.service;

import dbexemple.jdbc.connectiondatabase.ConnH2DB;
import dbexemple.jdbc.dao.ProjectDAO;
import dbexemple.jdbc.entity.Project;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProjectServiceTest {
    public static ProjectDAO projectService;
    static ConnH2DB conn = new ConnH2DB();

    @BeforeClass
    public static void testName() {
        projectService = new ProjectService(conn.getINSTANCE());
    }

    @AfterClass
    public static void close() throws Exception {
        // testRemove();
        conn.closeDB();
    }

    @Test
    public void testAdd() throws Exception {
        Project project = new Project();

        project.setId(2L);
        project.setTitle("Title_1");

        boolean result = projectService.add(project);
        Assert.assertTrue(result);
    }

    @Test
    public void testGetAll() throws Exception {
        Assert.assertNotNull(projectService.getAll());
    }

    @Test
    public void testGetById() throws Exception {
        Assert.assertNotNull(projectService.getById(1L));
    }

    @Test
    public void testUpdate() throws Exception {
        Project project = new Project();

        project.setId(1L);
        project.setTitle("TitleRF");

        projectService.update(project);
        Project upAddress = projectService.getById(project.getId());
        String upTitle = upAddress.getTitle();

        Assert.assertEquals(project.getTitle(), upTitle);
    }

    public static void testRemove() throws Exception {
        Project tmpAddress = new Project();
        tmpAddress.setId(1L);
        Assert.assertTrue(projectService.remove(tmpAddress));
    }
}
