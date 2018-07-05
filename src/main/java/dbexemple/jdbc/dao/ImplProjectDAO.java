package dbexemple.jdbc.dao;

import dbexemple.jdbc.entity.ImplProj;

import java.util.List;

public interface ImplProjectDAO {
    //create
    boolean add(ImplProj implProj);

    //read
    List<ImplProj> getAll();

    ImplProj getByEmpoloyeeIdAndProjectId(Long employeeId, Long projectId);

    //update
    boolean update(ImplProj implProj, ImplProj upImplProj);

    //delete
    boolean remove(ImplProj implProj);
}
