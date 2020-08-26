package com.banyechan.autocreatedatabase.serviceImpl;


import com.banyechan.autocreatedatabase.dto.AlarmDto;
import com.banyechan.autocreatedatabase.entity.Alarm;
import com.banyechan.autocreatedatabase.mapper.AlarmMapper;
import com.banyechan.autocreatedatabase.service.AlarmService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class AlarmServiceImpl implements AlarmService {

    @Autowired
    private AlarmMapper alarmMapper;

    @Override
    public Alarm getById(Integer id) {
        return alarmMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public boolean addAlarm(Alarm record) {
        record.setAlarmDatetime(new Date());
        int flag = alarmMapper.insertSelective(record);
        return flag > 0;
    }

    @Override
    public boolean updateAlarm(Alarm record) {
        int flag = alarmMapper.updateByPrimaryKeySelective(record);
        return flag > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return alarmMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public List<Alarm> listByCondition(AlarmDto condition) {
        return alarmMapper.listByCondition(condition);
    }

    @Override
    public PageInfo<Alarm> page(AlarmDto condition) {
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        List<Alarm> warehouseList = alarmMapper.listByCondition(condition);
        return new PageInfo<>(warehouseList);
    }

    @Override
    public int getNoClearNum() {
        return alarmMapper.getNoAckedNum();
    }

    @Override
    public List<Alarm> getOrderListByCondition() {
        List<Alarm> alarmList = alarmMapper.listByAcked();
        if (alarmList != null && alarmList.size() > 0) {
            alarmList.stream().sorted(new Comparator<Alarm>() {
                @Override
                public int compare(Alarm o1, Alarm o2) {
                    return o2.getAlarmSeverity() - o1.getAlarmSeverity();
                }
            });
        }

        return alarmList;
    }

    @Override
    public int getAlarmCountAfterDate(Date startDate, Boolean acked, Boolean cleared) {
        return alarmMapper.getAlarmCountAfterDate(startDate, acked, cleared);
    }


}
