package com.rgy.rgy.service;

import com.rgy.rgy.bean.Items;
import com.rgy.rgy.bean.Params;
import com.rgy.rgy.bean.Template;
import com.rgy.rgy.pojo.Ti;
import com.rgy.rgy.pojo.Tip;
import com.rgy.rgy.dao.ItemsDao;
import com.rgy.rgy.dao.ParamsDao;
import com.rgy.rgy.dao.TemplateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: gaoyk
 * @Date: 2019/10/31 21:00
 */
@Service
public class TemplateService {
    @Autowired
    TemplateDao templateDao;

    @Autowired
    ItemsDao itemsDao;

    @Autowired
    ParamsDao paramsDao;

    public List retall(){
        List<Object> list = new ArrayList<>();
        List<Template> templates = templateDao.findAll();
//        LinkedHashMap<Items,List<Params>> msg = new LinkedHashMap<>();
//        for(int i = 0; i < items.size(); i++){
//            msg.put(items.get(i),paramsDao.findByItemsId(items.get(i).getItemsId()));
//        }
//        return msg;
        for (Template template : templates) {
            Map<String, Object> map = new HashMap<>();
            map.put("template", template);
            map.put("items", itemsDao.findByTemplateId(template.getTemplateId()));
            list.add(map);
        }

        return list;
    }

    public Integer tadd(Template template){
        /**
         * 1.对传来的设备字符串进行处理
         * 2.对上传者进行处理
         */
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        template.setEditorDate(sf.format(date));
        template.setInfoState(0);
        templateDao.save(template);
        Template tem = templateDao.findByTemplateName(template.getTemplateName());
        return tem.getTemplateId();
    }

    public List<Template> tquery(String templateName){
        return templateDao.findByTemplateNameLike("%"+templateName+"%");
    }

    public Boolean tdel(Integer templateId){
        Template template = templateDao.findByTemplateId(templateId);
        if(template != null){
            template.setInfoState(1);
            templateDao.save(template);
            return true;
        }else{
            return false;
        }
    }

    public boolean update(Template template) {
        Template template1 = templateDao.findByTemplateId(template.getTemplateId());
        if(template1 == null){
            return false;
        }
        template1 = template;
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        template1.setEditorDate(sf.format(date));
        if(templateDao.save(template1) != null){
            return true;
        }else{
            return false;
        }
    }

    public List findBytId(Integer templateId) {

        List<Object> list = new ArrayList<>();
        List<Items> items = itemsDao.findByTemplateId(templateId);
//        LinkedHashMap<Items,List<Params>> msg = new LinkedHashMap<>();
//        for(int i = 0; i < items.size(); i++){
//            msg.put(items.get(i),paramsDao.findByItemsId(items.get(i).getItemsId()));
//        }
//        return msg;
        for (Items item : items) {
            Map<String, Object> map = new HashMap<>();
            map.put("item", item);
            map.put("params", paramsDao.findByItemsId(item.getItemsId()));
            list.add(map);
        }

        return list;
    }

    public List<Template> findall() {
        return templateDao.findAll();
    }

//    public List<Tip> findBytId(Integer templateId) {
//        List<Items> items = itemsDao.findByTemplateId(templateId);
//        List<Tip> tips = new ArrayList<>();
//        List<Params> params = new ArrayList<>();
//        for(int i = 0; i < items.size(); i++){
//            params = paramsDao.findByItemsId(items.get(i).getItemsId());
//            if(params == null && !params.isEmpty()){
//                continue;
//            }
//            for(int j=0; j < params.size(); j++){
//                tips.add(new Tip(items.get(i),params.get(j)));
//            }
//        }
//        return tips;
//    }
}
