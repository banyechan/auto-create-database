package com.banyechan.autocreatedatabase.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Alarm implements Serializable {
    private static final long serialVersionUID = -8092031829115164976L;
    private Integer id;

    private Integer alarmFromId;

    private Integer alarmTypeId;

    private Integer alarmSeverity;

    private String alarmTypeName;

    private Integer alarmCategory;

    private Integer objId;

    private String objName;

    private Integer objTypeId;

    private Integer equipmentId;

    private String equipmentSn;

    private String equipmentName;

    private Boolean acked;

    private String ackUser;

    private Date ackTime;

    private Integer ackResult;

    private String ackDesc;

    private String alarmSource;

    private Double longitude;

    private Double latitude;

    private Boolean cleared;

    private String clearUser;

    private Date clearedTime;

    private Date alarmDatetime;

    private String description;
}