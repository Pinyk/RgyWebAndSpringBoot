package com.rgy.rgy.dao;

import com.rgy.rgy.bean.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectDao extends JpaRepository<Project,Integer> {
    Project findByProjectName(String projectName);

    List<Project>  findByProjectType(String projectType);

    @Query("select a from Project a where a.projectId=?1")
    Project findByid(Integer projectId);

    @Query(value = "select * from project where if(?1 != '',project_name=?1,1=1)and if(?2 !='',project_type=?2,1=1)" +
            "and if(?3 != '',project_group=?3,1=1)",nativeQuery = true)
    List<Project> findByCondition(String X1, String X2, String X3);
}
