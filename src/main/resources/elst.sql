/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : elst

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2019-10-31 16:08:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for elst_menu
-- ----------------------------
DROP TABLE IF EXISTS `elst_menu`;
CREATE TABLE `elst_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `menu_id` varchar(255) NOT NULL,
  `menu_name` varchar(255) DEFAULT '' COMMENT '菜单名称',
  `parent_id` varchar(255) DEFAULT '' COMMENT '父类id',
  `menu_url` varchar(255) DEFAULT NULL,
  `menu_path` varchar(255) DEFAULT NULL,
  `menu_enabled` smallint(1) NOT NULL DEFAULT 1 COMMENT '是否启用 1 启用，0 禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of elst_menu
-- ----------------------------
INSERT INTO `elst_menu` VALUES ('1', '1', '考务管理', '0', '/kw/**', null, '1');
INSERT INTO `elst_menu` VALUES ('2', '2', '机构管理', '0', '/jg/**', null, '1');
INSERT INTO `elst_menu` VALUES ('3', '3', '计划管理', '1', '/jh/**', null, '1');
INSERT INTO `elst_menu` VALUES ('4', '4', '报名管理', '1', '/bm/**', null, '1');
INSERT INTO `elst_menu` VALUES ('5', '5', '编排管理', '1', '/bp/**', null, '1');
INSERT INTO `elst_menu` VALUES ('6', '6', '试卷管理', '1', '/sj/**', null, '1');
INSERT INTO `elst_menu` VALUES ('7', '7', '数据管理', '1', '/sj/**', null, '1');
INSERT INTO `elst_menu` VALUES ('8', '8', '成绩管理', '1', '/cj/**', null, '1');
INSERT INTO `elst_menu` VALUES ('9', '9', '通知管理', '1', '/tz/**', null, '1');

-- ----------------------------
-- Table structure for elst_organization
-- ----------------------------
DROP TABLE IF EXISTS `elst_organization`;
CREATE TABLE `elst_organization` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `org_id` varchar(255) NOT NULL,
  `parent_id` varchar(255) DEFAULT '0' COMMENT '父机构id',
  `org_name` varchar(255) DEFAULT '' COMMENT '机构名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of elst_organization
-- ----------------------------
INSERT INTO `elst_organization` VALUES ('1', '', null, '安徽省');
INSERT INTO `elst_organization` VALUES ('2', '', '1', '合肥市');
INSERT INTO `elst_organization` VALUES ('3', '', '2', '高新区');
INSERT INTO `elst_organization` VALUES ('4', '', '2', '蜀山区');
INSERT INTO `elst_organization` VALUES ('5', '', '1', '六安市');
INSERT INTO `elst_organization` VALUES ('6', '', '5', '金安区');
INSERT INTO `elst_organization` VALUES ('7', '', '5', '裕安区');

-- ----------------------------
-- Table structure for elst_role
-- ----------------------------
DROP TABLE IF EXISTS `elst_role`;
CREATE TABLE `elst_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `role_id` varchar(255) NOT NULL DEFAULT '',
  `role_name` varchar(255) DEFAULT '' COMMENT '角色名称',
  `zh_name` varchar(255) DEFAULT '' COMMENT '角色中文名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of elst_role
-- ----------------------------
INSERT INTO `elst_role` VALUES ('1', '1', 'admin', null);
INSERT INTO `elst_role` VALUES ('2', '2', 'teacher', null);
INSERT INTO `elst_role` VALUES ('3', '3', 'super', null);

-- ----------------------------
-- Table structure for elst_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `elst_role_menu`;
CREATE TABLE `elst_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `role_id` varchar(255) NOT NULL DEFAULT '' COMMENT '角色id',
  `menu_id` varchar(255) NOT NULL DEFAULT '' COMMENT '菜单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of elst_role_menu
-- ----------------------------
INSERT INTO `elst_role_menu` VALUES ('1', '1', '1');
INSERT INTO `elst_role_menu` VALUES ('2', '1', '2');
INSERT INTO `elst_role_menu` VALUES ('3', '2', '2');

-- ----------------------------
-- Table structure for elst_user
-- ----------------------------
DROP TABLE IF EXISTS `elst_user`;
CREATE TABLE `elst_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `user_id` varchar(255) NOT NULL DEFAULT '',
  `user_name` varchar(255) NOT NULL COMMENT '登录用户名',
  `user_pwd` varchar(255) NOT NULL COMMENT '登录密码',
  `user_enabled` smallint(1) NOT NULL DEFAULT 1 COMMENT '是否启用： 1启用，0不启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of elst_user
-- ----------------------------
INSERT INTO `elst_user` VALUES ('1', '1', 'zhangsan', '$2a$10$NEsrNyBIPGELx9DpIbm/x.VwAMOzhmX4cOfO4jzwRJf6XizYrxjI2', '1');
INSERT INTO `elst_user` VALUES ('2', '2', 'lisi', '$2a$10$NEsrNyBIPGELx9DpIbm/x.VwAMOzhmX4cOfO4jzwRJf6XizYrxjI2', '1');

-- ----------------------------
-- Table structure for elst_user_organization
-- ----------------------------
DROP TABLE IF EXISTS `elst_user_organization`;
CREATE TABLE `elst_user_organization` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `user_id` varchar(255) NOT NULL DEFAULT '' COMMENT '用户id',
  `org_id` varchar(255) NOT NULL DEFAULT '' COMMENT '机构id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of elst_user_organization
-- ----------------------------
INSERT INTO `elst_user_organization` VALUES ('1', '1', '3');
INSERT INTO `elst_user_organization` VALUES ('2', '2', '6');

-- ----------------------------
-- Table structure for elst_user_role
-- ----------------------------
DROP TABLE IF EXISTS `elst_user_role`;
CREATE TABLE `elst_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `user_id` varchar(255) NOT NULL DEFAULT '' COMMENT '用户id',
  `role_id` varchar(255) NOT NULL DEFAULT '' COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of elst_user_role
-- ----------------------------
INSERT INTO `elst_user_role` VALUES ('1', '1', '1');
INSERT INTO `elst_user_role` VALUES ('2', '2', '2');
INSERT INTO `elst_user_role` VALUES ('3', '1', '3');
