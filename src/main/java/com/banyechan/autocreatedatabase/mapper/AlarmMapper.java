package com.banyechan.autocreatedatabase.mapper;


import com.banyechan.autocreatedatabase.dto.AlarmDto;
import com.banyechan.autocreatedatabase.entity.Alarm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface AlarmMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Alarm record);

    Alarm selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Alarm record);

    List<Alarm> listByCondition(AlarmDto condition);

    List<Alarm> listByAreaIdAndZoneId(Integer areaId, Integer zoneId);

    List<Alarm> listByAreaId(Integer areaId);

    //查询出未确认的告警消息
    List<Alarm> listByAcked();

    // 查询未清除告警的个数
    int getNoAckedNum();

    // 查询告警的个数
    int getAlarmCountAfterDate(@Param("startDate") Date startDate, @Param("acked") Boolean acked, @Param("cleared") Boolean cleared);
}