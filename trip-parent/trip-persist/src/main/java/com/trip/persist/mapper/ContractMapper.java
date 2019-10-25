package com.trip.persist.mapper;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.trip.model.Contract;



public interface ContractMapper {
@Select("select * from t_c_contract where id=#{id}")
public Contract queryById(@Param("id") Long Id);
}
