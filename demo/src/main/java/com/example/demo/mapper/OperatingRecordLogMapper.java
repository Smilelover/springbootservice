package com.example.demo.mapper;

import com.example.demo.entity.OperatingRecordLog;
import com.example.demo.entity.OperatingRecordLogWithBLOBs;

public interface OperatingRecordLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OperatingRecordLogWithBLOBs record);

    int insertSelective(OperatingRecordLogWithBLOBs record);

    OperatingRecordLogWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OperatingRecordLogWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OperatingRecordLogWithBLOBs record);

    int updateByPrimaryKey(OperatingRecordLog record);
}