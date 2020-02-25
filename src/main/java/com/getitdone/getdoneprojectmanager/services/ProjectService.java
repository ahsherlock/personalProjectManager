package com.getitdone.getdoneprojectmanager.services;


import com.getitdone.getdoneprojectmanager.domain.Project;
import com.getitdone.getdoneprojectmanager.exceptions.ProjectIdException;
import com.getitdone.getdoneprojectmanager.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired // THIS UNDERLINE COULD BE AN ISSUE. Doesn't like field injection, but I don't think we give a fuck (AlecIssue1)
    private ProjectRepository projectRepository; // Gives access to Repository functionality

    public Project saveOrUpdateProject(Project project){
        try{
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }catch(Exception e){
            throw new ProjectIdException("Project ID '"+ project.getProjectIdentifier().toUpperCase()+"' already exists up in this bitch.");
        }


    }
    public Project findProjectByIdentifier(String projectId){

        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if(project == null){
            throw new ProjectIdException("That project does not exist up in this bitch");
        }
        return project;
    }

    public Iterable<Project>findAllProjects(){
        return projectRepository.findAll();
    }

}

