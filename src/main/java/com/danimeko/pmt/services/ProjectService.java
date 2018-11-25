package com.danimeko.pmt.services;

import com.danimeko.pmt.domain.Project;
import com.danimeko.pmt.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository  projectRepository;

    public Project saveOrUpdateProject(Project project){

        // logic part


        return projectRepository.save(project);
    }
}
