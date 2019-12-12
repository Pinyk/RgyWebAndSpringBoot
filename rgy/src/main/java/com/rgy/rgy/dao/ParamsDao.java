package com.rgy.rgy.dao;

import com.rgy.rgy.bean.Params;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParamsDao extends JpaRepository<Params,Integer> {
    List<Params> findByItemsId(Integer itemsId);
    List<Params> findByParamsNameLike(String paramsName);
    Params findByParamsId(Integer paramsId);
}
