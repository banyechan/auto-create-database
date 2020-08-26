package com.banyechan.autocreatedatabase.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AlarmDto extends BaseDto {
    private static final long serialVersionUID = -6999695298061050487L;

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
