package com.getitdone.getdoneprojectmanager.services;


import com.getitdone.getdoneprojectmanager.domain.Project;
import com.getitdone.getdoneprojectmanager.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired // THIS UNDERLINE COULD BE AN ISSUE. Doesn't like field injection, but I don't think we give a fuck (AlecIssue1)
    private ProjectRepository projectRepository; // Gives access to Repository functionality

    public Project saveOrUpdateProject(Project project){


        return projectRepository.save(project);
    }

}

