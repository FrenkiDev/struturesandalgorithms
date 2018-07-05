package dbexemple.jdbc.service;

import dbexemple.Logers;
import dbexemple.jdbc.dao.ImplProjectDAO;
import dbexemple.jdbc.entity.ImplProj;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImplProjService implements ImplProjectDAO {
    private Connection connection;

    public ImplProjService(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean add(ImplProj implproj) {
        boolean result = true;
        String sql = "INSERT INTO EMPL_PROJ(EMPLOYEEID, PROJECTID) VALUES(?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, implproj.getEmployeeId());
            preparedStatement.setLong(2, implproj.getProjectId());

            preparedStatement.executeUpdate();

            Logers.addPASS(implproj.toString());
        } catch (SQLException ex) {
            result = false;
            Logers.addFALSE(implproj.toString(), ex.getMessage());
        }
        return result;
    }

    @Override
    public List<ImplProj> getAll() {
        List<ImplProj> implProjList;

        String sql = "SELECT EMPLOYEEID, PROJECTID FROM EMPL_PROJ";

        try(Statement streamResult = connection.createStatement()){
            ResultSet resultSet = streamResult.executeQuery(sql);
            implProjList = filingImplProjList(resultSet);
            Logers.getAllPASS(implProjList.toString());
        } catch (SQLException ex) {
            implProjList = null;
            Logers.getAllFAIL(sql, ex.getMessage());
        }
        return implProjList;
    }

    @Override
    public ImplProj getByEmpoloyeeIdAndProjectId(Long employeeId, Long projectId) {
        ImplProj implproj = null;
        String sql = "SELECT EMPLOYEEID, PROJECTID FROM EMPL_PROJ WHERE EMPLOYEEID = ? AND PROJECTID = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, employeeId);
            preparedStatement.setLong(2, projectId);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            implproj = getImplProj(resultSet);
            Logers.getByIdPASS("Employee_id = " + employeeId.toString() + " Project_id = " + projectId, implproj.toString());
        }catch(SQLException ex){
            Logers.getByIdFAIL("Employee_id = " + employeeId.toString() + " Project_id = " + projectId, ex.getMessage());
        }

        return implproj;
    }

    @Override
    public boolean update(ImplProj implproj, ImplProj upImplproj) {
        boolean result = true;
        String sql = "UPDATE EMPL_PROJ SET EMPLOYEEID = ?, PROJECTID = ? WHERE EMPLOYEEID = ? AND PROJECTID = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, upImplproj.getEmployeeId());
            preparedStatement.setLong(2, upImplproj.getProjectId());
            preparedStatement.setLong(3, implproj.getEmployeeId());
            preparedStatement.setLong(4, implproj.getProjectId());

            preparedStatement.executeUpdate();
            Logers.updatePASS(implproj.toString());
        }catch (SQLException ex){
            Logers.updateFAIL(implproj.toString(), ex.getMessage());
            result = false;
        }
        return result;
    }

    @Override
    public boolean remove(ImplProj implproj) {
        String sql = "DELETE FROM EMPLPROJ WHERE EMPLOYEEID = ? AND PROJECTID = ?";
        boolean result = true;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, implproj.getEmployeeId());
            preparedStatement.setLong(1, implproj.getProjectId());

            preparedStatement.executeUpdate();
            Logers.removeRASS(implproj.toString());
        }catch (SQLException ex){
            Logers.removeFAIL(implproj.toString(), ex.getMessage());
            result = false;
        }
        return result;
    }

    private ImplProj getImplProj(ResultSet resultSet) throws SQLException {
        ImplProj implproj = new ImplProj();

        implproj.setEmployeeId(resultSet.getLong("employeeId"));
        implproj.setProjectId(resultSet.getLong("projectId"));

        return implproj;
    }

    private List<ImplProj> filingImplProjList(ResultSet resultSet) throws SQLException {
        List<ImplProj> implProjList = new ArrayList<>();

        while (resultSet.next()){
            ImplProj tmpImplProj = getImplProj(resultSet);
            implProjList.add(tmpImplProj);
        }
        return implProjList;
    }
}
