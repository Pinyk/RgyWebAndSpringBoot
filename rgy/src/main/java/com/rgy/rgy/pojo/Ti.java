package com.rgy.rgy.pojo;

import com.rgy.rgy.bean.Items;
import com.rgy.rgy.bean.Template;
import lombok.Data;

/**
 * @Author: gaoyk
 * @Date: 2019/12/9 20:09
 */
@Data
public class Ti {
    private Template template;
    private Items items;

    public Ti(Template template, Items items) {
        this.template = template;
        this.items = items;
    }
}
