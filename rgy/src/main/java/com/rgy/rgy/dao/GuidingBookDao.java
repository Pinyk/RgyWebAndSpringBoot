package com.rgy.rgy.dao;

/**
 * @Author：AnZhuJun
 * @Date: 2019/11/17 16:00
 */

import com.rgy.rgy.bean.GuidingBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuidingBookDao extends JpaRepository<GuidingBook,Integer> {
    GuidingBook findByGuidingBookId(int id);
    List<GuidingBook> findByGuidingBookName(String name);
}
