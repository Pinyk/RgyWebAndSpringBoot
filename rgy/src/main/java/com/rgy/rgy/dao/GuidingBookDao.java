package com.rgy.rgy.dao;

/**
 * @Author：AnZhuJun
 * @Date: 2019/11/17 16:00
 */

import com.rgy.rgy.bean.GuidingBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuidingBookDao extends JpaRepository<GuidingBook,Integer> {
    GuidingBook findByGuidingBookId(int id);
    GuidingBook findByGuidingBookName(String name);
}
