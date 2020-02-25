package com.getitdone.getdoneprojectmanager.web;


import com.getitdone.getdoneprojectmanager.domain.Project;
import com.getitdone.getdoneprojectmanager.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/project")
public class ProjectController {

    @Autowired // (AlecIssue1)
    private ProjectService projectService;

    @PostMapping("")
    public ResponseEntity<Project> createNewProject(@RequestBody Project project){      //Response Entity allows more control of JSON Objects
        Project project1 = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(project, HttpStatus.CREATED);

    }
}
