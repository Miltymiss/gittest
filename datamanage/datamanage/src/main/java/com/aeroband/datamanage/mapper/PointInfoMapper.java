package com.aeroband.datamanage.mapper;

import com.aeroband.datamanage.domain.PointInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PointInfoMapper {
    @Select("call ")
    List<PointInfo> getOverview();
}
