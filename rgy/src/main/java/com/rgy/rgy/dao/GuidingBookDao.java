package com.rgy.rgy.dao;

/**
 * @Author：gaoyk
 * @Date: 2019/11/17 16:00
 */

import com.rgy.rgy.bean.GuidingBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GuidingBookDao extends JpaRepository<GuidingBook,Integer> {

    @Query("select a from GuidingBook a where a.guidingBookId=?1")
    GuidingBook findByGId(int guidingBookId);
    List<GuidingBook> findByGuidingBookName(String name);
    List<GuidingBook> findByGuidingBookNameLike(String guidingBookName);
}
