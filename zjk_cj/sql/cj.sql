/*
Navicat MySQL Data Transfer

Source Server         : 192.168.102.15
Source Server Version : 50134
Source Host           : 192.168.102.15:3306
Source Database       : cj

Target Server Type    : MYSQL
Target Server Version : 50134
File Encoding         : 65001

Date: 2017-06-15 18:28:30
*/

SET FOREIGN_KEY_CHECKS=0;


DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(20) NOT NULL,
  `password` varchar(255) NOT NULL,
  `secret` varchar(6) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `swjg_dm` varchar(20) NOT NULL,
  `is_del` tinyint(4) NOT NULL DEFAULT '0',
  `p_id` int(11) DEFAULT NULL,
  `role` tinyint(4) NOT NULL,
  `create_user` int(11) DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL,
  `update_user` int(11) DEFAULT NULL,
  `update_time` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `app`;
CREATE TABLE `app` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `path` varchar(255) NOT NULL,
  `version` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `app_notice`;
CREATE TABLE `app_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `is_del` tinyint(4) NOT NULL DEFAULT '0',
  `message` text,
  `send_time` bigint(20) DEFAULT NULL,
  `create_user` int(11) DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL,
  `update_user` int(11) DEFAULT NULL,
  `update_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `app_read`;
CREATE TABLE `app_read` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enterprise_id` int(11) NOT NULL,
  `app_id` int(11) NOT NULL,
  `is_read` tinyint(4) NOT NULL DEFAULT '0',
  `read_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `enterprise`;
CREATE TABLE `enterprise` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_code` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `secret` varchar(6) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `swjg_dm` varchar(20) NOT NULL,
  `is_del` tinyint(4) NOT NULL DEFAULT '0',
  `create_user` int(11) DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL,
  `update_user` int(11) DEFAULT NULL,
  `update_time` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `login_time` bigint(20) DEFAULT NULL,
  `bind` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` text,
  `create_time` bigint(11) DEFAULT NULL,
  `create_user` int(11) DEFAULT NULL,
  `message` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `noticeread`;
CREATE TABLE `noticeread` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `nid` int(11) DEFAULT NULL,
  `create_time` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `page_notice`;
CREATE TABLE `page_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `is_del` tinyint(4) NOT NULL DEFAULT '0',
  `message` text,
  `start_time` bigint(20) DEFAULT NULL,
  `end_time` bigint(20) DEFAULT NULL,
  `create_user` int(11) DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL,
  `update_user` int(11) DEFAULT NULL,
  `update_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `page_read`;
CREATE TABLE `page_read` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enterprise_id` int(11) NOT NULL,
  `page_id` int(11) NOT NULL,
  `is_read` tinyint(4) NOT NULL DEFAULT '0',
  `read_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `phone_notice`;
CREATE TABLE `phone_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `is_del` tinyint(4) NOT NULL DEFAULT '0',
  `message` text,
  `send_time` varchar(8) NOT NULL,
  `create_user` int(11) DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL,
  `update_user` int(11) DEFAULT NULL,
  `update_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `phone_send`;
CREATE TABLE `phone_send` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enterprise_id` int(11) NOT NULL,
  `phone_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `pre_time`;
CREATE TABLE `pre_time` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_time` bigint(20) DEFAULT NULL,
  `now_time` bigint(20) DEFAULT NULL,
  `is_use` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `swjg`;
CREATE TABLE `swjg` (
  `SWJG_DM` varchar(255) NOT NULL DEFAULT '',
  `SWJGMC` varchar(255) DEFAULT NULL,
  `SWJGJC` varchar(255) DEFAULT NULL,
  `SWJGBZ` varchar(255) DEFAULT NULL,
  `SJSWJG_DM` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`SWJG_DM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tax`;
CREATE TABLE `tax` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `yingys` decimal(10,2) DEFAULT NULL,
  `qysds` decimal(10,2) DEFAULT NULL,
  `grsds` decimal(10,2) DEFAULT NULL,
  `zys` decimal(10,2) DEFAULT NULL,
  `yjs` decimal(10,2) DEFAULT NULL,
  `fcs` decimal(10,2) DEFAULT NULL,
  `yhs` decimal(10,2) DEFAULT NULL,
  `tdsys` decimal(10,2) DEFAULT NULL,
  `tdzzs` decimal(10,2) DEFAULT NULL,
  `ccs` decimal(10,2) DEFAULT NULL,
  `yanys` decimal(10,2) DEFAULT NULL,
  `gdzys` decimal(10,2) DEFAULT NULL,
  `qs` decimal(10,2) DEFAULT NULL,
  `zzs` decimal(10,2) DEFAULT NULL,
  `total` decimal(10,2) NOT NULL,
  `add_time` bigint(20) NOT NULL,
  `enterprise_id` int(11) NOT NULL,
  `time_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `time_notice`;
CREATE TABLE `time_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `is_del` tinyint(4) NOT NULL DEFAULT '0',
  `message` text,
  `is_time` tinyint(4) NOT NULL DEFAULT '0',
  `send_time` varchar(8) NOT NULL,
  `create_user` int(11) DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL,
  `update_user` int(11) DEFAULT NULL,
  `update_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

