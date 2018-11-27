package com.danimeko.pmt.services;

import com.danimeko.pmt.domain.Project;
import com.danimeko.pmt.exceptions.ProjectIdException;
import com.danimeko.pmt.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository  projectRepository;

    public Project saveOrUpdateProject(Project project){
        try{
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());

            return projectRepository.save(project);
        }catch(Exception  e){
            throw new ProjectIdException("Project Id ' " + project.getProjectIdentifier().toUpperCase() +"' already exist");
        }

    }

    public Project findProjectByIdentifier(String projectId){

        Project project = projectRepository.findByProjectIdentifier(projectId);

        if(project == null){
            throw new ProjectIdException("Project id ' "+projectId+" ' doesn't exist");
        }

        return project;
    }

    public Iterable<Project> findAllProjects(){

        return projectRepository.findAll();
    }

    public void deleteProjectByIdentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase() );

        if(project == null ){
            throw new ProjectIdException("Can't find project with id");
        }

        projectRepository.delete(project);
    }
}
