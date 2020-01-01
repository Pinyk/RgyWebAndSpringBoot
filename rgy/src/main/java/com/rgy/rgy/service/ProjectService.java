package com.rgy.rgy.service;


import com.rgy.rgy.bean.Project;
import com.rgy.rgy.dao.ProjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: gaoyk
 * @Date: 2019/10/30 21:01
 */

@Service
public class ProjectService {
    @Autowired
    ProjectDao projectDao;

    public boolean add(Project project){
        project.setInfoState(0);

        Project project1 = projectDao.save(project);
        if(project1 != null){
            return true;
        }else{
            return false;
        }
    }

    public boolean update(Project project){
        Project project1 = projectDao.findByid(project.getProjectId());
        if(project1 == null){
            return false;
        }
        project1 = project;
        if(projectDao.save(project1) != null){
            return true;
        }
        return false;
    }

    public boolean delete(Integer projectId){
        Project project = projectDao.findByid(projectId);
        if(project != null){
            project.setInfoState(1);
            projectDao.save(project);
            return true;
        }else{
            return false;
        }
    }

    public List<Project> findAll(){
        return projectDao.findAll();
    }

    public List<Project>  findByProjectType(String projectType){
        return projectDao.findByProjectType(projectType);
    }

    public List<Project> findByCondition(String projectName,String projectType,String projectGroup){
        return projectDao.findByCondition(projectName,projectType,projectGroup);
    }


}
