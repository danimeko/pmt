package com.danimeko.pmt.repository;

import com.danimeko.pmt.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository  extends CrudRepository<Project , Long>{


}
