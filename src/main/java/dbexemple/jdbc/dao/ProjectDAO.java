package dbexemple.jdbc.dao;

import dbexemple.jdbc.entity.Project;

import java.util.List;

public interface ProjectDAO {
    //create
    boolean add(Project project);

    //read
    List<Project> getAll();

    Project getById(Long id);

    //update
    boolean update(Project project);

    //delete
    boolean remove(Project project);
}
