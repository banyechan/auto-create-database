package com.banyechan.autocreatedatabase.controller;


import com.banyechan.autocreatedatabase.dto.AlarmDto;
import com.banyechan.autocreatedatabase.dto.R;
import com.banyechan.autocreatedatabase.entity.Alarm;
import com.banyechan.autocreatedatabase.service.AlarmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 告警 模块管理
 */
@Slf4j
@RestController
@RequestMapping("/alarm")
public class AlarmController {

    @Autowired
    private AlarmService alarmService;


    /**
     * 查询
     */
    @GetMapping("/{id}")
    public R getById(@PathVariable("id") Integer id) {
        return new R(alarmService.getById(id));
    }

    /**
     * 新增
     */
    @PostMapping("/add")
    public R addAlarm(@RequestBody Alarm alarm) {
        return new R(alarmService.addAlarm(alarm));
    }

    /**
     * 修改
     */
    @PutMapping("/edit")
    public R update(@RequestBody Alarm alarm) {
        return new R(alarmService.updateAlarm(alarm));
    }

    /**
     * 删除
     */
    @DeleteMapping("/{id}")
    public R delete(@PathVariable("id") Integer id) {
        return new R(alarmService.deleteById(id));
    }

    /**
     * 列表查询
     *
     * @param condition
     * @return
     */
    @PostMapping("/list")
    public R list(@RequestBody(required = false) AlarmDto condition) {
        return new R(alarmService.listByCondition(condition));
    }


    /**
     * 分页查询
     *
     * @param condition
     * @return
     */
    @PostMapping("/page")
    public R page(@RequestBody AlarmDto condition) {
        return new R(alarmService.page(condition));
    }

}
