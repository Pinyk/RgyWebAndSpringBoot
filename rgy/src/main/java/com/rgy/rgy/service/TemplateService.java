package com.rgy.rgy.service;

import com.rgy.rgy.bean.Items;
import com.rgy.rgy.bean.Template;
import com.rgy.rgy.dao.EquipmentTypeDao;
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
    EquipmentTypeDao equipmentTypeDao;

    @Autowired
    ItemsService itemsService;

    @Autowired
    ParamsDao paramsDao;

    public List retall(){
        List<Object> list = new ArrayList<>();
        List<Template> templates = templateDao.findAll();

        for (int i = 0; i < templates.size(); i++ ) {
            Map<String, Object> map = new HashMap<>();
            if (templates.get( i ).getInfoState() == 1) {
                templates.remove( i );
                i--;
            } else {
                templates.get( i ).setEquipmentTypeId( setEquipmentTypeId( templates.get(i).getEquipmentTypeId()) );
                map.put("template", templates.get( i ));
                List<Items> byTemplateId = itemsDao.findByTemplateId( templates.get( i ).getTemplateId() );
                for ( int j = 0; j < byTemplateId.size(); j++) {
                    if (byTemplateId.get( j ).getInfoState() == 1) {
                        byTemplateId.remove( j );
                        j--;
                    }
                }
                Collections.sort(byTemplateId);
                map.put("items", byTemplateId);
                list.add(map);
            }
        }
        return list;
    }

//    public TreeMap<Template, List<Items>> findAll2(){
//        List<Template> templates = templateDao.findAll();
//        for (int i = 0; i < templates.size(); i++) {
//            templates.get( i ).setEquipmentTypeId( setEquipmentTypeId( templates.get(i).getEquipmentTypeId()) );
//            if (1 == templates.get( i ).getInfoState()) {
//                templates.remove( i );
//                i--;
//            }
//        }
//        TreeMap<Template, List<Items>> map = new TreeMap<>();
//        for(int i = 0; i < templates.size(); i++){
//            List<Items> msg = itemsDao.findByTemplateId(templates.get( i ).getTemplateId());
//            Collections.sort(msg);
//            map.put( templates.get( i ), msg);
//        }
//        return map;
//    }

    public List<Template> findAll(){
        List<Template> templates = templateDao.findAll();
        for (int i = 0; i < templates.size(); i++) {
            if (templates.get( i ).getInfoState() == 1) {
                templates.remove( i );
                i--;
            } else {
               templates.get( i ).setEquipmentTypeId( setEquipmentTypeId( templates.get(i).getEquipmentTypeId()) );
            }
        }
        return templates;
    }


    public String setEquipmentTypeId(String equipmentTypeId) {

        String[] equ = equipmentTypeId.split( "," );
        String realId = new String(  );

        for (String a : equ) {
            String Id = equipmentTypeDao.findByEquipmentTypeID( Integer.valueOf( a ) ).getEquipmentTypeName();
            if (Id == null) {
                Id = a;
            }
            realId = realId +  "," + Id;
        }

        return realId.substring( 1, realId.length() );
    }

    public String getEquipmentTypeId(String equipmentTypeId) {
        String[] equ = equipmentTypeId.split( "," );
        String realId = new String();
        equipmentTypeDao.findByEquipmentTypeName( equ[1]);
        for (String a : equ) {
            String Id = equipmentTypeDao.findByEquipmentTypeName( a ).get(0).getEquipmentTypeID().toString();
            if (Id == null) {
                Id = a;
            }
            realId = realId +  "," + Id;
        }
        return realId.substring( 1, realId.length() );
    }


    public Integer add(Template template){
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        template.setEditorDate( sf.format(date) );
        template.setInfoState( 0 );

        template.setEquipmentTypeId( getEquipmentTypeId( template.getEquipmentTypeId() ) );

        Template save = templateDao.save( template );
        if (save != null) {
            Template tem = templateDao.findByTemplateName(template.getTemplateName());
            return tem.getTemplateId();
        } else {
            return -1;
        }
    }

    public List<Template> findByNameLike(String templateName){
        List<Template> templates = templateDao.findByTemplateNameLike( "%" + templateName + "%" );
        for (int i = 0; i < templates.size(); i++) {
            if (templates.get( i ).getInfoState() == 1) {
                templates.remove( i );
                i--;
            } else {
                templates.get( i ).setEquipmentTypeId( setEquipmentTypeId( templates.get(i).getEquipmentTypeId()) );
            }
        }
        return templates;
    }

    public Boolean del(Integer templateId){
        Template template = templateDao.findByTemplateId(templateId);
        if(template != null){
            template.setInfoState(1);
            templateDao.save( template );
            List<Items> byTemplateId = itemsDao.findByTemplateId( templateId );
            for (Items i : byTemplateId) {
                itemsService.del( i.getItemsId() );
            }
            return true;
        }else{
            return false;
        }
    }

    public boolean update(Template template) {
        Template template1 = templateDao.findByTemplateId( template.getTemplateId() );
        if (template1 == null) {
            return false;
        }

        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        template.setEditorDate( sf.format(date) );

        template.setBasis( template1.getBasis() );
        template.setEditor( template1.getEditor() );

        template.setEquipmentTypeId( getEquipmentTypeId( template.getEquipmentTypeId() ) );
        template.setInfoState( 0 );


        if (templateDao.save( template ) != null) {
            return true;
        } else {
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
}
