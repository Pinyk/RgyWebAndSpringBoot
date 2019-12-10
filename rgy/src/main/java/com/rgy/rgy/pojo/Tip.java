package com.rgy.rgy.pojo;

import com.rgy.rgy.bean.Items;
import com.rgy.rgy.bean.Params;
import lombok.Data;

/**
 * @Author: gaoyk
 * @Date: 2019/12/8 16:56
 */
@Data
public class Tip {
//    private Template template;

    private Items items;

    private Params params;
//
//    public Tip(Template template, Items items, Params params) {
//        this.template = template;
//        this.items = items;
//        this.params = params;
//    }

    public Tip(Items items, Params params){
        this.items = items;
        this.params = params;
    }
}
