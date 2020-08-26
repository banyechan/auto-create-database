package com.banyechan.autocreatedatabase.service;


import com.banyechan.autocreatedatabase.dto.AlarmDto;
import com.banyechan.autocreatedatabase.entity.Alarm;
import com.github.pagehelper.PageInfo;

import java.util.Date;
import java.util.List;

public interface AlarmService {

    Alarm getById(Integer id);

    boolean addAlarm(Alarm record);

    boolean updateAlarm(Alarm record);

    boolean deleteById(Integer id);

    List<Alarm> listByCondition(AlarmDto condition);

    PageInfo<Alarm> page(AlarmDto condition);

    int getNoClearNum();

    List<Alarm> getOrderListByCondition();

    int getAlarmCountAfterDate(Date startDate, Boolean acked, Boolean cleared);
}
