package dbexemple.dao;

import dbexemple.entity.ImplProj;

import java.util.List;

public interface ImplProjectDAO {
    //create
    void add(ImplProj implProj);

    //read
    List<ImplProj> getAll();

    ImplProj getByEmpoloyeeIdAndProjectId(Long employeeId, Long projectId);

    //update
    void update(ImplProj implProj);

    //delete
    void remove(ImplProj implProj);
}
