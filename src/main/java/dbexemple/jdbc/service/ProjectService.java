package dbexemple.jdbc.service;

import dbexemple.Logers;
import dbexemple.jdbc.dao.ProjectDAO;
import dbexemple.jdbc.entity.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectService implements ProjectDAO {
    private Connection connection;

    public ProjectService(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean add(Project project) {
        boolean result = true;
        String sql = "INSERT INTO Project(ID, TITLE) VALUES(?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, project.getId());
            preparedStatement.setString(2, project.getTitle());

            preparedStatement.executeUpdate();

            Logers.addPASS(project.toString());
        } catch (SQLException ex) {
            result = false;
            Logers.addFALSE(project.toString(), ex.getMessage());
        }
        return result;
    }

    @Override
    public List<Project> getAll() {
        List<Project> projectList;

        String sql = "SELECT ID, TITLE FROM project";

        try(Statement streamResult = connection.createStatement()){
            ResultSet resultSet = streamResult.executeQuery(sql);
            projectList = filingProjectList(resultSet);
            Logers.getAllPASS(projectList.toString());
        } catch (SQLException ex) {
            projectList = null;
            Logers.getAllFAIL(sql, ex.getMessage());
        }
        return projectList;
    }

    @Override
    public Project getById(Long id) {
        Project project = null;
        String sql = "SELECT ID, TITLE FROM Project WHERE ID = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            project = getProject(resultSet);
            Logers.getByIdPASS(id.toString(), project.toString());
        }catch(SQLException ex){
            Logers.getByIdFAIL(id.toString(), ex.getMessage());
        }

        return project;
    }

    @Override
    public boolean update(Project project) {
        boolean result = true;
        String sql = "UPDATE project SET TITLE = ? WHERE ID = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, project.getTitle());
            preparedStatement.setLong(2, project.getId());

            preparedStatement.executeUpdate();
            Logers.updatePASS(project.toString());
        }catch (SQLException ex){
            Logers.updateFAIL(project.toString(), ex.getMessage());
            result = false;
        }
        return result;
    }

    @Override
    public boolean remove(Project project) {
        String sql = "DELETE FROM project WHERE id = ?";
        boolean result = true;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, project.getId());
            preparedStatement.executeUpdate();
            Logers.removeRASS(project.toString());
        }catch (SQLException ex){
            Logers.removeFAIL(project.toString(), ex.getMessage());
            result = false;
        }
        return result;
    }

    private Project getProject(ResultSet resultSet) throws SQLException {
        Project project = new Project();

        project.setId(resultSet.getLong("id"));
        project.setTitle(resultSet.getString("title"));

        return project;
    }

    private List<Project> filingProjectList(ResultSet resultSet) throws SQLException {
        List<Project> addProject = new ArrayList<>();

        while (resultSet.next()){
            Project tmpProject = getProject(resultSet);
            addProject.add(tmpProject);
        }
        return addProject;
    }
}
