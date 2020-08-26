
CREATE DATABASE IF NOT EXISTS `supermarket`;

USE `supermarket`;

CREATE TABLE IF NOT EXISTS `alarm` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '报警编号，自增',
  `alarm_from_id` int(11) NOT NULL DEFAULT '0' COMMENT '告警发布方id',
  `alarm_type_id` int(11) NOT NULL DEFAULT '0' COMMENT '报警类别id：alarm_type表主键',
  `alarm_severity` int(4) NOT NULL DEFAULT '0' COMMENT '正常 None = 0,       提示 Minor = 1,       一般 Normal = 2,       严重  Major = 3,       危急 Critical = 4',
  `alarm_type_name` varchar(50) NOT NULL DEFAULT '-' COMMENT '告警类型名称：如，温度严重告警',
  `alarm_category` int(11) NOT NULL DEFAULT '1' COMMENT '告警类型大类(枚举)',
  `obj_id` int(11) NOT NULL DEFAULT '0' COMMENT '监测对象id，measobj表的主键',
  `obj_name` varchar(50) NOT NULL DEFAULT '-' COMMENT '名称',
  `obj_type_id` int(11) NOT NULL DEFAULT '0' COMMENT '监测对象类型id，obj_type表的主键',
  `equipment_id` int(11) NOT NULL DEFAULT '0' COMMENT '设备id，关联设备表',
  `equipment_sn` varchar(50) NOT NULL DEFAULT '-' COMMENT '设备编号，关联设备表',
  `equipment_name` varchar(50) NOT NULL DEFAULT '-' COMMENT '设备名称',
  `acked` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0未确认、1已确认',
  `ack_user` varchar(50) NOT NULL DEFAULT '0' COMMENT '确认人',
  `ack_time` datetime DEFAULT NULL COMMENT '确认时间',
  `ack_result` int(4) NOT NULL DEFAULT '0' COMMENT '确认原因选择：TrueAlarm = 11 确认告警; FalseAlarm = 12 系统误报; Unconfirmed = 13 无法确认',
  `ack_desc` varchar(50) NOT NULL DEFAULT '-' COMMENT '确认原因描述',
  `alarm_source` varchar(50) NOT NULL DEFAULT '-' COMMENT '告警源：标识多少米、或那个通道等不好对应的信息',
  `longitude` double NOT NULL DEFAULT '99' COMMENT '经度',
  `latitude` double NOT NULL DEFAULT '99' COMMENT '纬度',
  `cleared` tinyint(1) NOT NULL DEFAULT '0' COMMENT ' 0未清除（默认）、1已清除',
  `clear_user` varchar(50) NOT NULL DEFAULT '0' COMMENT '清除人，默认系统清除，不需要人为操作',
  `cleared_time` datetime DEFAULT NULL COMMENT '清除时间',
  `alarm_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '报警时间',
  `description` varchar(255) NOT NULL DEFAULT '-' COMMENT '告警详情additional_text：位置信息，或提醒内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COMMENT='告警表';