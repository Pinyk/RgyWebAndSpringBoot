package com.rgy.rgy.dao;

import com.rgy.rgy.bean.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemplateDao extends JpaRepository<Template,Integer>{
    List<Template> findByTemplateNameLike(String templateName);
    Template findByTemplateName(String templateName);
    Template findByTemplateId(int templateId);
}
