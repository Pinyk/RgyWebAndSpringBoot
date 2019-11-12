package com.rgy.rgy.service;

import com.rgy.rgy.bean.Template;
import com.rgy.rgy.dao.TemplateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Author: gaoyk
 * @Date: 2019/10/31 21:00
 */
@Service
public class TemplateService {
    @Autowired
    TemplateDao templateDao;

    public List<Template> retall(){
        return templateDao.findAll();
    }

    public int tadd(String templateName, String basis,
                    String equipmentTypeId, String editor){
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:nn:ss");
        String editorDate = sf.format(date);
        int infoState = 0;
        templateDao.save(new Template(templateName,basis,equipmentTypeId,editor,editorDate,infoState));
        Template tem = templateDao.findByTemplateName(templateName);
        return tem.getTemplateId();
    }

    public Template tquery(String templateName){
        return templateDao.findByTemplateName(templateName);
    }

    public Boolean tdel(int templateId){
        Template template = templateDao.findByTemplateId(templateId);
        if(template!=null){
            template.setInfoState(1);
            return true;
        }else{
            return false;
        }
    }
}
