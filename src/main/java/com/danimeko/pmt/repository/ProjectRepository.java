package com.danimeko.pmt.repository;

import com.danimeko.pmt.domain.Project;
import com.danimeko.pmt.exceptions.ProjectIdException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository  extends CrudRepository<Project , Long>{

    Project findByProjectIdentifier(String projectId);

    @Override
    Iterable<Project> findAll();
}
